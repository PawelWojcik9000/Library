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
import library.dao.BookDAO;
import library.entities.Author;


@WebServlet("/editAuthor")
public class EditAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String authorId = null;
	String authorName = null;
	String authorSurname = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("authorid"));
		authorId = request.getParameter("authorid");
		AuthorDAO authorDAO = new AuthorDAO();
		Author author = authorDAO.getAuthorById(Integer.parseInt(authorId));
		request.setAttribute("author", author);
		getServletContext().getRequestDispatcher("/views/editAuthorForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthorDAO authorDAO = new AuthorDAO();
		authorName = request.getParameter("author_name");
		authorSurname = request.getParameter("author_surname");
		authorDAO.editAuthor(authorId, authorName, authorSurname);
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listAuthors");
		rd.forward(request, response);
		authorDAO.closeConnection();
	}

}
