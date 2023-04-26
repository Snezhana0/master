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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.BookDao;
import dao.PublishDao;
import dao.UserDao;
import domain.Publish;
import domain.Author;
import domain.Book;
@WebServlet("/books") 
public class BookServlet extends HttpServlet { 
 
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	private PublishDao publishDao;
	private UserDao userDao;
	
	public void init() {
		bookDao = new BookDao();
		publishDao = new PublishDao();
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			/*case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;*/
			default:
				listBook(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Publish> listPublish = publishDao.selectAllPublish();
		List<Book> listBook = bookDao.selectAllBooks();
		List<Author> listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		request.setAttribute("listBook", listBook);
		request.setAttribute("listPublish", listPublish);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/book.jsp");
		dispatcher.forward(request, response);
	}


	/*private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String namepublish = request.getParameter("namepublish");
		String site = request.getParameter("site");
		String add = request.getParameter("add");
		
		Publish newUser = new Publish(null, namepublish, site, add);
		publishDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		Long id = (long) Integer.parseInt(request.getParameter("id"));
		String namepublish = request.getParameter("namepublish");
		String site = request.getParameter("site");
		String add = request.getParameter("add");
		

		Publish book = new Publish(id, namepublish, site, add);
		publishDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		publishDAO.deleteUser(id);
		response.sendRedirect("list");

	}*/
}
