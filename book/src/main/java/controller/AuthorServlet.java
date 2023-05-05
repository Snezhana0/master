package controller; 
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ConnectionProperty;


import domain.Author;
@WebServlet("/authors") 
public class AuthorServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	ConnectionProperty prop;
	String select_all_author = "SELECT * FROM authors";
	String insert_author = "INSERT INTO authors (id, firstname, lastname) VALUES(?,?,?)";
	ArrayList<Author> author = new ArrayList<Author>();
	String userPath;
	 public AuthorServlet() throws FileNotFoundException, IOException {
	 prop = new ConnectionProperty();
	 }
	 
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) 
	throws ServletException, IOException {
	response.setContentType("text/html");
	ConnectionProperty builder = new ConnectionProperty();
	// Загрузка всех авторов
	try (Connection conn = builder.getConnection()) {
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(select_all_author);
	if(rs != null) {
	author.clear();
	while (rs.next()) {
		author.add(new Author(rs.getLong("id"),
	rs.getString("firstname"),
	rs.getString("lastname")));
	}
	rs.close();
	request.setAttribute("author", author);
	}
	} catch (Exception e) {
	System.out.println(e);
	} 
	userPath = request.getServletPath();
	if("/authors".equals(userPath)){
	request.getRequestDispatcher("/WEB-INF/view/author.jsp")
	.forward(request, response);
	}
	}
	
	/**
	* @see HttpServlet#doPost(HttpServletRequest request, 
	HttpServletResponse response)
	*/
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ConnectionProperty builder = new ConnectionProperty();
			try (Connection conn = builder.getConnection()){
			Long id = (long) Integer.parseInt(request.getParameter("id"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
		
			try (PreparedStatement preparedStatement = 
			conn.prepareStatement(insert_author)){
			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, lastname);
			
			int result = preparedStatement.executeUpdate();
			} catch (Exception e) {
			System.out.println(e);
			}
			} catch (Exception e) {
			System.out.println(e);
			getServletContext().getRequestDispatcher("/WEB-INF/view/author.jsp")
			.forward(request, response); 
			}
			doGet(request, response);
			}

}
