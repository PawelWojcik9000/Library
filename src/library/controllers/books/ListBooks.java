package library.controllers.books;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.BookDAO;
import library.entities.Book;


@WebServlet("/listBooks")
public class ListBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		List<Book> books = bookDAO.getBooks();
		request.setAttribute("books", books);
		getServletContext().getRequestDispatcher("/views/listBooks.jsp").forward(request, response);
		bookDAO.closeConnection();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
