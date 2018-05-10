package library.controllers.authors;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.xml.crud.AuthorsXmlDAO;


@WebServlet("/addAuthorXML")
public class AddAuthorXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/views/addAuthorXMLForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("author_name"));
		System.out.println(request.getParameter("author_surname"));
		AuthorsXmlDAO authorXmlDAO = new AuthorsXmlDAO();
		authorXmlDAO.addAuthorXml(request.getParameter("author_name"), request.getParameter("author_surname"));
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/homexml");
		rd.forward(request, response);
	}

}
