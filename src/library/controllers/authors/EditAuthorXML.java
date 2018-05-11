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


@WebServlet("/editAuthorXML")
public class EditAuthorXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String authorId = null;
	String authorName = null;
	String authorSurname = null;
	AuthorsXmlDAO authXmlDAO = new AuthorsXmlDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authorId = request.getParameter("authorid");
		request.setAttribute("author", authXmlDAO.getAuthorByIdXml(authorId));
		getServletContext().getRequestDispatcher("/views/editAuthorFormXML.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authorName = request.getParameter("author_name");
		authorSurname = request.getParameter("author_surname");
		authXmlDAO.editAuthorXml(authorId, authorName, authorSurname);
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/homexml");
		rd.forward(request, response);
	}

}
