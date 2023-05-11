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
import domain.Book;
import domain.Publish;
@WebServlet("/editbook")
public class EditBookServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
ConnectionProperty prop;
String select_all_book = "SELECT id, title, code,yearpublish, countpage, hardcover,abstract, statuc, authorid, publishid  FROM books ORDER BY title ASC";
String select_all_author = "SELECT id, firstname, lastname FROM authors";
String select_all_publish = "SELECT id, namepublish, site, add FROM publishs";
String select_book_ById = "SELECT id, title, code, yearpublish, countpage, hardcover,abstract, statuc, authorid, publishid FROM books WHERE id = ?";
String edit_book = "UPDATE books SET title = ?, code= ?,yearpublish= ?, countpage= ?, hardcover= ?,abstract= ?, statuc= ?, authorid= ?, publishid = ? WHERE id = ?";
ArrayList<Author> author = new ArrayList<Author>();
ArrayList<Publish> publishs = new ArrayList<Publish>();
ArrayList<Book> books = new ArrayList<Book>();
ArrayList<Book> editbooks = new ArrayList<Book>();
String userPath;
String publishPath;

 
 public EditBookServlet() throws FileNotFoundException, 
IOException {
 super();
 // TODO Auto-generated constructor stub
 prop = new ConnectionProperty();
 }
 
// Поиск должности по id
 private Author FindById(Long id, ArrayList<Author> author) {
 if(author != null) {
 for(Author r: author) {
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
//Поиск должности по id
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
String strId = request.getParameter("id");
Long idPersonSelected = null;
if(strId != null) {
idPersonSelected = Long.parseLong(strId);
}
// Загрузка всех должностей
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
else
{
System.out.println("Ошибка загрузки role");
}

//Загрузка всех должностей
Statement stm = conn.createStatement();
ResultSet rss = stm.executeQuery(select_all_publish);
if(rs != null) {
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
System.out.println("Ошибка загрузки role");
}

// Загрузка всех сотрудников

long authorid;
long publishid;
stmt = conn.createStatement();
rs = stmt.executeQuery(select_all_book);
if(rs != null) {
books.clear();
while (rs.next()) {
authorid = rs.getLong("authorid");
publishid = rs.getLong("publishid");
books.add(new
		Book(rs.getLong("id"),
 rs.getString("title"),
 rs.getString("code"),
 rs.getString("yearpublish"),
 rs.getString("countpage"),
 rs.getString("hardcover"),
 rs.getString("abstract"),
 rs.getString("statuc"),
 FindById(authorid, author),
 FindByIdPublish(publishid, publishs),
 authorid,
 publishid));
}
rs.close();
request.setAttribute("books", books); 
}
else
{
System.out.println("Ошибка загрузки person");
}
try (PreparedStatement preparedStatement = 
conn.prepareStatement(select_book_ById)) {
preparedStatement.setLong(1, idPersonSelected);
rs = preparedStatement.executeQuery();
if(rs != null) {
editbooks.clear();
while (rs.next()) {
editbooks.add(new Book(
		rs.getLong("id"),
		 rs.getString("title"),
		 rs.getString("code"),
		 rs.getString("yearpublish"),
		 rs.getString("countpage"),
		 rs.getString("hardcover"),
		 rs.getString("abstract"),
		 rs.getString("statuc"),
		 rs.getLong("authorid"),
		 rs.getLong("publishid")));
}
rs.close();
request.setAttribute("booksEdit", editbooks);
}
else
{
System.out.println("Ошибка загрузки book");
}
} catch (Exception e) {

System.out.println(e);
}
} catch (Exception e) {
System.out.println(e);
} 
String userPath = request.getServletPath();
if("/editbook".equals(userPath)){
request.getRequestDispatcher("/WEB-INF/view/editbook.jsp").forward(request, response);
}
}
protected void doPost(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException {
	ConnectionProperty builder = new ConnectionProperty();
try (Connection conn = builder.getConnection()){
String strId = request.getParameter("id");
Long id = null;
if(strId != null) {
id = Long.parseLong(strId);
}
String title = request.getParameter("title");
String code = request.getParameter("code");
String yearpublish = request.getParameter("yearpublish");
String countpage = request.getParameter("countpage");
String hardcover = request.getParameter("hardcover");
String Abstract = request.getParameter("abstract");
String statuc = request.getParameter("statuc");
String author = request.getParameter("authorid");
String publish = request.getParameter("publishid");
int index1 = author.indexOf('='); 
int index2 = author.indexOf(","); 
String r1 = author.substring(index1+1, index2);
Long authorid = Long.parseLong(r1.trim());
int index3 = publish.indexOf('='); 
int index4 = publish.indexOf(","); 
String r2 = publish.substring(index3+1, index4);
Long publishid = Long.parseLong(r2.trim());
PreparedStatement preparedStatement = 
conn.prepareStatement(edit_book);

preparedStatement.setLong(1, id);
preparedStatement.setString(2, title);
preparedStatement.setString(3, code);
preparedStatement.setString(4, yearpublish);
preparedStatement.setString(5, countpage );
preparedStatement.setString(6, hardcover);
preparedStatement.setString(7, Abstract);
preparedStatement.setString(8, statuc );
preparedStatement.setLong(9, authorid );
preparedStatement.setLong(10, publishid );



 int rows = preparedStatement.executeUpdate();
} catch (Exception e) {
System.out.println(e);
getServletContext().getRequestDispatcher("/WEB-INF/view/book.jsp")
.forward(request, response);
}
doGet(request, response);
}
}
