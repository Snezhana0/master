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
import dao.PublishDao;
import domain.Publish;
@WebServlet("/publishs") 
public class PublishServlet extends HttpServlet { 
 
	private static final long serialVersionUID = 1L;
	private PublishDao publishDao;
	
	public void init() {
		publishDao = new PublishDao();
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
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listPublish(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listPublish(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Publish> listPublish = publishDao.selectAllPublish();
		request.setAttribute("listPublish", listPublish);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/publish.jsp");
		dispatcher.forward(request, response);
	}


	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String namepublish = request.getParameter("namepublish");
		String site = request.getParameter("site");
		String add = request.getParameter("add");
		
		Publish newUser = new Publish(null, namepublish, site, add);
		publishDao.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		Long id = (long) Integer.parseInt(request.getParameter("id"));
		String namepublish = request.getParameter("namepublish");
		String site = request.getParameter("site");
		String add = request.getParameter("add");
		

		Publish book = new Publish(id, namepublish, site, add);
		publishDao.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		publishDao.deleteUser(id);
		response.sendRedirect("list");

	}
}