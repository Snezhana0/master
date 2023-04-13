package controller; 
 
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletContext; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import java.io.IOException; 
 

@WebServlet("/books") 
public class BookServlet extends HttpServlet { 
 
 /**
   * 
   */
  private static final long serialVersionUID = -3307587549800997681L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) 
 throws ServletException, IOException { 
 
 String path = "/WEB-INF/view/book.jsp"; 
 ServletContext servletContext = getServletContext(); 
 RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path); 
 requestDispatcher.forward(request, response); 
 } 
}
