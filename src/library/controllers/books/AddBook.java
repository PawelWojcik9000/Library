package library.controllers.books;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/addBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AuthorDAO authorDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authorDAO = new AuthorDAO();
		List<Author> authors = authorDAO.getAuthors();
		request.setAttribute("authors", authors);
		getServletContext().getRequestDispatcher("/views/addBookForm.jsp").forward(request, response);
		authorDAO.closeConnection();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		
		String title = request.getParameter("book_title");
		String type = request.getParameter("book_type");
		boolean available = false;
		String checkedAvailable = request.getParameter("book_available");
		if(checkedAvailable != null && !checkedAvailable.isEmpty()) {
			available = true;
		}
		int rentAmount = Integer.parseInt(request.getParameter("book_rent_amount"));
		int returnedToLate = Integer.parseInt(request.getParameter("book_returned_to_late"));
		String isbn = request.getParameter("book_isbn");
		int pages = Integer.parseInt(request.getParameter("book_pages"));
		String published = request.getParameter("book_published");
		
//		String[] authors = request.getParameterValues("author_id");
//		System.out.println(Arrays.toString(authors));
		
		bookDAO.persistBook(title, type, available, rentAmount, returnedToLate, isbn, pages, published);
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listBooks");
		rd.forward(request, response);
		bookDAO.closeConnection();
	}

}
