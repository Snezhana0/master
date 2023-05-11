package controller;
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
import java.sql.Statement;
import java.util.ArrayList;
import dao.ConnectionProperty;

import domain.Publish;
@WebServlet("/deletepublish")
public class DeletePublishServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
ConnectionProperty prop;
String select_all_publish = "SELECT id, namepublish, site, add FROM publishs ORDER BY namepublish ASC";
String select_publish_ById = "SELECT id, namepublish, site, add FROM publishs WHERE id = ?";
String delete_publish = "DELETE FROM publishs WHERE id = ?";

ArrayList<Publish> publish = new ArrayList<Publish>();
ArrayList<Publish> deletepublishs = new ArrayList<Publish>();
String publishPath;
 
 public DeletePublishServlet() throws FileNotFoundException, IOException {
 super();
 prop = new ConnectionProperty();
 }
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
ConnectionProperty builder = new ConnectionProperty();
// Загрузка всех должностей
try (Connection conn = builder.getConnection()) {
String strId = request.getParameter("id");
Long id = null;
if (strId != null) {
id = Long.parseLong(strId);
}
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(select_all_publish);
if (rs != null) {
	publish.clear();
while (rs.next()) {
	publish.add(new Publish(rs.getLong("id"),
rs.getString("namepublish"),
rs.getString("site"),
rs.getString("add")));
}
rs.close();
request.setAttribute("publishs", publish);
} else {
System.out.println("Ошибка загрузки publishs");
}
try (PreparedStatement preparedStatement = conn.prepareStatement(select_publish_ById)) {
preparedStatement.setLong(1, id);
rs = preparedStatement.executeQuery();
if (rs != null) {
deletepublishs.clear();
while (rs.next()) {
deletepublishs.add(new Publish(rs.getLong("id"), rs.getString("namepublish"), rs.getString("site"), rs.getString("add")));
}
rs.close();
request.setAttribute("publishsDelete", 
deletepublishs);
} else {
System.out.println("Ошибка загрузки author");

}
} catch (Exception e) {
System.out.println(e);
}
} catch (Exception e) {
System.out.println(e);
}
publishPath = request.getServletPath();
if ("/deletepublish".equals(publishPath)) {
request.getRequestDispatcher("/WEB-INF/view/deletepublish.jsp").forward(request, response);
}
}
protected void doPost(HttpServletRequest request, 
HttpServletResponse response)
throws ServletException, IOException {
	ConnectionProperty builder = new ConnectionProperty();
try (Connection conn = builder.getConnection()) {
Long id = Long.parseLong(request.getParameter("id"));
try (PreparedStatement preparedStatement = conn.prepareStatement(delete_publish)) {
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