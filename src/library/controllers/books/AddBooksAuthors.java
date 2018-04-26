package library.controllers.books;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.BookDAO;


@WebServlet("/addBooksAuthors")
public class AddBooksAuthors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getServletContext().getRequestDispatcher("/views/booksDetails.jsp").forward(request, response);
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		String bookId = request.getParameter("book_id");
		String[] authorsIds = request.getParameterValues("author_id");
		for (String authorId : authorsIds) {
			bookDAO.addBooksAuthors(bookId, authorId);
		}
		bookDAO.closeConnection();
		System.out.println(Arrays.toString(request.getParameterValues("book_id")));
		System.out.println(Arrays.toString(request.getParameterValues("author_id")));
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listBooks");
		rd.forward(request, response);
	}

}
