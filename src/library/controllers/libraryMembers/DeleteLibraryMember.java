package library.controllers.libraryMembers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.LibraryMemberDAO;


@WebServlet("/deleteLibraryMember")
public class DeleteLibraryMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibraryMemberDAO libmemberDAO = new LibraryMemberDAO();
		libmemberDAO.deleteLibraryMember(request.getParameter("libmemberid"));
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listLibraryMembers");
		rd.forward(request, response);
		libmemberDAO.closeConnection();
	}

}
