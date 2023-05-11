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
import domain.Publish;
import domain.Book;
@WebServlet("/deletebook")
public class DeleteBookServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
ConnectionProperty prop;
String select_all_book = "SELECT id, title, code,yearpublish, countpage, hardcover,abstract, statuc, authorid, publishid  FROM books ORDER BY title ASC";
String select_all_author = "SELECT id, firstname, lastname FROM authors";
String select_all_publish = "SELECT id, namepublish, site, add FROM publishs";
String select_book_ById = "SELECT id, title, code, yearpublish, countpage, hardcover,abstract, statuc, authorid, publishid FROM books WHERE id = ?";
String delete_book = "DELETE FROM books WHERE id = ?";
ArrayList<Author> author = new ArrayList<Author>();
ArrayList<Publish> publishs = new ArrayList<Publish>();
ArrayList<Book> books = new ArrayList<Book>();
ArrayList<Book> deletebooks = new ArrayList<Book>();
String userPath;
 
 public DeleteBookServlet() 
throws FileNotFoundException, IOException {
 super();
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
HttpServletResponse response) throws ServletException, IOException {
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
System.out.println("Ошибка загрузки author");
}
//Загрузка всех должностей
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
rs.close();
request.setAttribute("publishs", publishs); 
}
else
{
System.out.println("Ошибка загрузки publish");
}
// Загрузка всех сотрудников
stmt = conn.createStatement();
Long authorid;
Long publishid;
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
deletebooks.clear();
Long idauthor = null;
Long idpublish = null;
while (rs.next()) {
	idauthor = rs.getLong("authorid");
	idpublish = rs.getLong("publishid");
deletebooks.add(new Book(
rs.getLong("id"), 
rs.getString("title"),
rs.getString("code"),
rs.getString("yearpublish"),
rs.getString("countpage"),
rs.getString("hardcover"),
rs.getString("abstract"),
rs.getString("statuc"),
idauthor,
idpublish));
}
rs.close();
request.setAttribute("booksDelete", deletebooks);
}
else
{
System.out.println("Ошибка загрузки author");
}
} catch (Exception e) {
System.out.println(e);
}
} catch (Exception e) {
System.out.println(e);
} 
String userPath = request.getServletPath();
if("/deletebook".equals(userPath)){
request.getRequestDispatcher("/WEB-INF/view/deletebook.jsp").forward(request, response);
}
}
protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 

throws ServletException, IOException {
ConnectionProperty builder = new ConnectionProperty();
try (Connection conn = builder.getConnection()){
String strId = request.getParameter("id");
Long id = null;
if(strId != null) {
id = Long.parseLong(strId);
}
try (PreparedStatement preparedStatement = 
conn.prepareStatement(delete_book)) {
preparedStatement.setLong(1, id);
int result = preparedStatement.executeUpdate();
} catch (Exception e) {
System.out.println(e);
}
} catch (Exception e) {
System.out.println(e);
}
doGet(request, response);
}
}

