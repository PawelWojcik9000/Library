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
import library.entities.LibraryMember;


@WebServlet("/editLibraryMember")
public class EditLibraryMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String libMemberId = null;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		libMemberId = request.getParameter("libmemberid");
		LibraryMemberDAO libmemDAO = new LibraryMemberDAO();
		LibraryMember libraryMember = libmemDAO.getLibraryMemberById(libMemberId);
		request.setAttribute("libraryMember", libraryMember);
		getServletContext().getRequestDispatcher("/views/editLibraryMemberForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibraryMemberDAO libmemDAO = new LibraryMemberDAO();
		libmemDAO.editLibraryMember(libMemberId, request.getParameter("name"), request.getParameter("surname"), request.getParameter("address"), request.getParameter("phone_number"));
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listLibraryMembers");
		rd.forward(request, response);
		libmemDAO.closeConnection();
	}

}
