package library.controllers.books;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.AuthorDAO;
import library.dao.BookDAO;
import library.entities.Author;
import library.entities.Book;


@WebServlet("/bookDetails")
public class BookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		AuthorDAO authorDAO = new AuthorDAO();
		String bookId = request.getParameter("bookid");
		List<Integer> authorsIdsByBook = bookDAO.getAuthorsIdByBookId(bookId);
//		System.out.println(request.getParameter("bookid"));
		List<Author> authors = new ArrayList<>();
		for (Integer authorId : authorsIdsByBook) {
			authors.add(authorDAO.getAuthorById(authorId));
		}
		Book book = bookDAO.getBookById(bookId);
		book.setAuthors(authors);
//		System.out.println(authors);
//		System.out.println(bookDAO.getBookById(bookId));
//		System.out.println(book);
		request.setAttribute("book", book);
		request.setAttribute("authors", authorDAO.getAuthors());
		getServletContext().getRequestDispatcher("/views/booksDetails.jsp").forward(request, response);
		bookDAO.closeConnection();
		authorDAO.closeConnection();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
