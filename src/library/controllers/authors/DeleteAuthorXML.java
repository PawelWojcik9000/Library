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


@WebServlet("/deleteAuthorXML")
public class DeleteAuthorXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthorsXmlDAO authXmlDAO = new AuthorsXmlDAO();
		String authorId = request.getParameter("authorid");
		authXmlDAO.deleteAuthorXml(authorId);
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/homexml");
		rd.forward(request, response);
	}

}
