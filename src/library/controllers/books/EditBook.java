package library.controllers.books;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.BookDAO;


@WebServlet("/editBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String bookId = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookId = request.getParameter("bookid");
		getServletContext().getRequestDispatcher("/views/editBookForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		String title = request.getParameter("book_title");
		String type = request.getParameter("book_type");
		boolean available = false;
		if(request.getParameter("book_available").equals("true")) {
			available = true;
		}
		int rentAmount = Integer.parseInt(request.getParameter("book_rent_amount"));
		int returnedToLate = Integer.parseInt(request.getParameter("book_returned_to_late"));
		String isbn = request.getParameter("book_isbn");
		int pages = Integer.parseInt(request.getParameter("book_pages"));
		String published = request.getParameter("book_published");
		
//		String[] authors = request.getParameterValues("author_id");
//		System.out.println(Arrays.toString(authors));
		
		bookDAO.editBook(title, type, available, rentAmount, returnedToLate, isbn, pages, published, bookId);
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listBooks");
		rd.forward(request, response);
		bookDAO.closeConnection();
	}

}
