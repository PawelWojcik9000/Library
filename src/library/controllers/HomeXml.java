package library.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.LibraryDAO;
import library.xml.crud.AuthorsXmlDAO;




@WebServlet("/homexml")
public class HomeXml extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("<h1>Hello world.</h1>");
//		LibraryDAO libraryDAO = new LibraryDAO();
		AuthorsXmlDAO authXmlDAO = new AuthorsXmlDAO();
		request.setAttribute("authors", authXmlDAO.getAuthorsXml());
		//authXmlDAO.addAuthorXml("Zenek", "Zenkowy");
		getServletContext().getRequestDispatcher("/views/homepagexml.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
