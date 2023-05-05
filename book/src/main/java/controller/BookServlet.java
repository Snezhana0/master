package controller; 
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ConnectionProperty;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import domain.Publish;
import domain.Author;
import domain.Book;
@WebServlet("/books") 
public class BookServlet extends HttpServlet { 
 
	private static final long serialVersionUID = 1L;
	ConnectionProperty prop;
	String select_all_person = "SELECT title, code, yearpublish, countpage, hardcover, abstract, statuc, authorid, publishid, id FROM books";
	String select_all_author = "SELECT * FROM authors";
	String select_all_publish = "SELECT * FROM publishs";
	String insert_book = "INSERT INTO books( title, code, yearpublish, countpage, hardcover, abstract, statuc, authorid, publishid, id) VALUES(?,?,?,?,?,?,?,?,?,?)";

	ArrayList<Author> authors = new ArrayList<Author>();
	ArrayList<Publish> publishs = new ArrayList<Publish>();
	ArrayList<Book> books = new ArrayList<Book>();
	String userPath;
	String publishPath;
	 public BookServlet() throws FileNotFoundException, IOException{
	 prop = new ConnectionProperty();
	 }
	 
	 // Поиск должности по id
	 private Author FindById(Long id, ArrayList<Author> authors) {
	 if(authors != null) {
	 for(Author r: authors) {
	 if((r.getId()).equals(id)) {
	 return r;
	 }
	
	 }
	 }
	 else {
	 return null;
	 }
	 return null;
	 }
	 
	 private Publish FindByIdPublish(Long id, ArrayList<Publish> publishs) {
		 if(publishs != null) {
		 for(Publish r: publishs) {
		 if((r.getId()).equals(id)) {
		 return r;
		 }
		
		 }
		 }
		 else {
		 return null;
		 }
		 return null;
		 }
	protected void doGet(HttpServletRequest request, 
	HttpServletResponse response) 
	throws ServletException, IOException {
	response.setContentType("text/html");
	ConnectionProperty builder = new ConnectionProperty();
	try (Connection conn = builder.getConnection()) {
	// Загрузка всех авторов
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(select_all_author);
	if(rs != null) {
	authors.clear();
	while (rs.next()) {
	authors.add(new Author(rs.getLong("id"),
			rs.getString("firstname"),
			rs.getString("lastname")));
	}
	rs.close();
	request.setAttribute("authors", authors);
	}
	else
	{
	System.out.println("Ошибка загрузки author");
	}
	//Загрузка всех издательств
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
	else
	{
	System.out.println("Ошибка загрузки publish");
	}
	// Загрузка всех сотрудников
	long authorId;
	long publishId;
	stmt = conn.createStatement();
	rs = stmt.executeQuery(select_all_person);
	if(rs != null) {
	books.clear();
	while (rs.next()) {
		authorId = rs.getLong("authorid");
		publishId = rs.getLong("publishid");
	books.add(new
		Book(rs.getLong("id"),
		rs.getString("title"),
		rs.getString("code"),
		rs.getString("yearpublish"),
		rs.getString("countpage"),
		rs.getString("hardcover"),
		rs.getString("abstract"),
		rs.getString("statuc"),
		FindById(authorId, authors),
		FindByIdPublish(publishId, publishs),
		authorId,
		publishId));
		}
	rs.close();
	request.setAttribute("books", books);
	
	}
	} catch (Exception e) {
	System.out.println(e);
	} 
	String userPath = request.getServletPath();
	if("/books".equals(userPath)){
	request.getRequestDispatcher("/WEB-INF/view/book.jsp")
	.forward(request, response);
	}
	}
	/**
	* @see HttpServlet#doPost(HttpServletRequest request, 
	HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
			ConnectionProperty builder = new ConnectionProperty();
			try (Connection conn = builder.getConnection()){
			Long id = (long) Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String code = request.getParameter("code");
			String yearpublish = request.getParameter("yearpublish");
			String countpage = request.getParameter("countpage");
			String Hardcover = request.getParameter("hardcover");
			String Abstract = request.getParameter("abstract");
			String Statuc = request.getParameter("statuc");
			String author = request.getParameter("authorid");
			String publish = request.getParameter("publishid");
			int index1 = author.indexOf('='); 
			int index2 = author.indexOf(","); 
			int index3 = publish.indexOf('='); 
			int index4 = publish.indexOf(",");
			String r1 = author.substring(index1+1, index2);
			String r2 = publish.substring(index3+1, index4);
			Long authorId = Long.parseLong(r1.trim());
			Long publishId = Long.parseLong(r2.trim());
			
			PreparedStatement preparedStatement = 
			conn.prepareStatement(insert_book);
			
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, code);
			preparedStatement.setString(3, yearpublish);
			preparedStatement.setString(4, countpage );
			preparedStatement.setString(5, Hardcover );
			preparedStatement.setString(6, Abstract );
			preparedStatement.setString(7, Statuc );
			preparedStatement.setLong(8, authorId );
			preparedStatement.setLong(9, publishId );
			preparedStatement.setLong(10, id );
			int rows = preparedStatement.executeUpdate();
			} catch (Exception e) {
			System.out.println(e);
			getServletContext().getRequestDispatcher("/WEB-INF/view/book.jsp")
			.forward(request, response); 
			}
			doGet(request, response);
			}

}
