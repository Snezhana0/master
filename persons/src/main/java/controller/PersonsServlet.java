package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Servlet;
/**
* Servlet implementation class RoleServlet_
*/
@WebServlet("/HelloRoleServlet")
public class PersonsServlet extends HttpServlet implements Servlet {

private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public PersonsServlet() {
 super();
 // TODO Auto-generated constructor stub
 }
/**
* @see HttpServlet#doGet(HttpServletRequest request,
HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//response.getWriter().append("Served at:").append(request.getContextPath());
response.setContentType("text/html");
 PrintWriter writer = response.getWriter();
 try {
 writer.println("<h2>Привет RoleServlet</h2>");
 } finally {
 writer.close();
 }
}
/**
* @see HttpServlet#doPost(HttpServletRequest request,
HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}

