package library.controllers.authors;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.AuthorDAO;


@WebServlet("/addAuthor")
public class AddAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/views/addAuthorForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("author_name"));
		System.out.println(request.getParameter("author_surname"));
		AuthorDAO authorDAO = new AuthorDAO();
		authorDAO.persistAuthor(request.getParameter("author_name"), request.getParameter("author_surname"));
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listAuthors");
		rd.forward(request, response);
		authorDAO.closeConnection();
		

	}

}
