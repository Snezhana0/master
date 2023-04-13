package controller; 
 
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletContext; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
 
@WebServlet("/authors") 
public class AuthorServlet extends HttpServlet { 
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
 throws ServletException, IOException { 
 
 String path = "/WEB-INF/view/author.jsp"; 
 ServletContext servletContext = getServletContext(); 
 RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path); 
 requestDispatcher.forward(request, response); 
 } 
}
