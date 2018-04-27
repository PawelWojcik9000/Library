package library.controllers.libraryMembers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.LibraryMemberDAO;
import library.entities.LibraryMember;


@WebServlet("/listLibraryMembers")
public class ListLibraryMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibraryMemberDAO libmemDAO = new LibraryMemberDAO();
		List<LibraryMember> libMembers = libmemDAO.getLibraryMembers();
		request.setAttribute("library_members", libMembers);
		getServletContext().getRequestDispatcher("/views/listLibraryMembers.jsp").forward(request, response);
		libmemDAO.closeConnection();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
