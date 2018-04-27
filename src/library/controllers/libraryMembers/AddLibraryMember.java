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


@WebServlet("/addLibraryMember")
public class AddLibraryMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/views/addLibraryMemberForm.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibraryMemberDAO libmemDAO = new LibraryMemberDAO();
		libmemDAO.persistLibraryMember(request.getParameter("name"), request.getParameter("surname"), request.getParameter("address"), request.getParameter("phone_number"));
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/listLibraryMembers");
		rd.forward(request, response);
		libmemDAO.closeConnection();
	}

}
