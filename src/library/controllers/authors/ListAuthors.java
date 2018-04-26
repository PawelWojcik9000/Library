package library.controllers.authors;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.AuthorDAO;
import library.dao.BookDAO;
import library.entities.Author;


@WebServlet("/listAuthors")
public class ListAuthors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthorDAO authorDAO = new AuthorDAO();
		List<Author> authors = authorDAO.getAuthors();
		//System.out.println(authors);
		request.setAttribute("authors", authors);
		getServletContext().getRequestDispatcher("/views/listAuthors.jsp").forward(request, response);
		authorDAO.closeConnection();
		
		BookDAO bookDAO = new BookDAO();
		System.out.println(bookDAO.getAuthorsIdByBookId("2"));
		bookDAO.closeConnection();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
