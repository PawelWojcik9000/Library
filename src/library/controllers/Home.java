package library.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.LibraryDAO;




@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("<h1>Hello world.</h1>");
		LibraryDAO libraryDAO = new LibraryDAO();
		getServletContext().getRequestDispatcher("/views/homepage.jsp").forward(request, response);
	}

	

}
