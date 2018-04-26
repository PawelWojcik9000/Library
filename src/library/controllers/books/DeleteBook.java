package library.controllers.books;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.BookDAO;


@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		bookDAO.deleteBook(request.getParameter("bookid"));
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listBooks");
		rd.forward(request, response);
		bookDAO.closeConnection();
	}

}
