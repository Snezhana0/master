package controller; 
 
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletContext; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException; 


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionProperty;
import domain.Author;
import domain.Publish;
@WebServlet("/publishs") 
public class PublishServlet extends HttpServlet { 
 
	private static final long serialVersionUID = 1L;
	ConnectionProperty prop;
	String select_all_publish = "SELECT * FROM publishs";
	String insert_publish = "INSERT INTO publishs(id, namepublish, site, add) VALUES(?,?,?,?)";
	ArrayList<Publish> publishs = new ArrayList<Publish>();
	String publishPath;
	 public PublishServlet() throws FileNotFoundException, IOException {
	 prop = new ConnectionProperty();
	 }
	 
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) 
	throws ServletException, IOException {
	response.setContentType("text/html");
	ConnectionProperty builder = new ConnectionProperty();
	// Загрузка всех должностей
	try (Connection conn = builder.getConnection()) {
	Statement stm = conn.createStatement();
	ResultSet rss = stm.executeQuery(select_all_publish);
	if(rss != null) {
		publishs.clear();
	while (rss.next()) {
		publishs.add(new Publish(rss.getLong("id"),
	rss.getString("namepublish"),
	rss.getString("site"),
	rss.getString("add")));
	}
	rss.close();
	request.setAttribute("publishs", publishs);
	}
	} catch (Exception e) {
	System.out.println(e);
	} 
	publishPath = request.getServletPath();
	if("/publishs".equals(publishPath)){
	request.getRequestDispatcher("/WEB-INF/view/publish.jsp")
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
			String namepublish = request.getParameter("namepublish");
			String site = request.getParameter("site");
			String add = request.getParameter("add");
		
			try (PreparedStatement preparedStatement = 
			conn.prepareStatement(insert_publish)){
			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, namepublish);
			preparedStatement.setString(3, site);
			preparedStatement.setString(4, add);
			
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