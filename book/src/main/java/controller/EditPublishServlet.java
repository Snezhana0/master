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
import domain.Publish;
/**
 * Servlet implementation class EditAuthorServlet
 */

@WebServlet("/editpublish")
public class EditPublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionProperty prop;
	String select_all_publish = "SELECT id, namepublish, site, add FROM publishs ORDER BY namepublish ASC";
	String select_publish_ById = "SELECT id, namepublish, site, add FROM publishs WHERE id = ?";
	String edit_publish = "UPDATE publishs SET namepublish = ?, site = ?, add = ? WHERE id = ?";
	ArrayList<Publish> publishs = new ArrayList<Publish>();
	ArrayList<Publish> editpublishs = new ArrayList<Publish>();
	String publishPath;
	 
	 /**
	 * @see HttpServlet#HttpServlet()
	 */
	 public EditPublishServlet() throws FileNotFoundException, IOException 
	{
	 super();
	 // TODO Auto-generated constructor stub
	 prop = new ConnectionProperty();
	 }
	protected void doGet(HttpServletRequest request, 
	HttpServletResponse response) 
	throws ServletException, IOException {
	response.setContentType("text/html");
	ConnectionProperty builder = new ConnectionProperty();
	// Загрузка всех должностей
	try (Connection conn = builder.getConnection()) {
	String strId = request.getParameter("id");
	Long id = null; // id редактируемой должности
	if(strId != null) {
	id = Long.parseLong(strId);
	}
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(select_all_publish);
	if(rs != null) {
		publishs.clear();
	while (rs.next()) {
		publishs.add(new Publish(rs.getLong("id"), 
	rs.getString("namepublish"),
	rs.getString("site"),
	rs.getString("add")));
	}
	rs.close();
	request.setAttribute("publishs", publishs);
	}
	else
	{
	System.out.println("Ошибка загрузки publish");
	}
	try (PreparedStatement preparedStatement = 
	conn.prepareStatement(select_publish_ById)) {
	preparedStatement.setLong(1, id);
	rs = preparedStatement.executeQuery();
	if(rs != null) {
	editpublishs.clear();
	while (rs.next()) {
	editpublishs.add(new
	Publish(rs.getLong("id"), rs.getString("namepublish"), rs.getString("site"), rs.getString("add")));
	}
	rs.close();
	request.setAttribute("publishsEdit", editpublishs);
	}
	else
	{
	System.out.println("Ошибка загрузки publish");
	}
	} catch (Exception e) {
	System.out.println(e);
	}
	} catch (Exception e) {
	System.out.println(e);
	} 
	publishPath = request.getServletPath();
	if("/editpublish".equals(publishPath)){
	request.getRequestDispatcher("/WEB-INF/view/editpublish.jsp").forward(request, response);
	}
	}
	protected void doPost(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException, IOException {
	ConnectionProperty builder = new ConnectionProperty();
	try (Connection conn = builder.getConnection()) {
	String strId = request.getParameter("id");
	Long id = null;
	if(strId != null) {
	id = Long.parseLong(strId);
	}
	String namepublish = request.getParameter("namepublish");
	String site = request.getParameter("site");
	String add = request.getParameter("add");
	try (PreparedStatement preparedStatement = 
	conn.prepareStatement(edit_publish)) {
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
	}
	doGet(request, response);
	}

}
