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


@WebServlet("/deleteAuthor")
public class DeleteAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthorDAO authorDAO = new AuthorDAO();
		String authorId = request.getParameter("authorid");
		authorDAO.deleteAuthor(authorId);
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listAuthors");
		rd.forward(request, response);
		authorDAO.closeConnection();
		
	}
	
	

}
