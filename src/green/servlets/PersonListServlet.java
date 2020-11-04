package green.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dao.PersonDao;

@SuppressWarnings("serial")
@WebServlet("/person/list")
public class PersonListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PersonListServlet doGet ok");
		try {
			ServletContext sc = this.getServletContext();
			PersonDao personDao = (PersonDao) sc.getAttribute("personDao");
			request.setAttribute("persons", personDao.selectlist());
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/person/PersonList.jsp");
			rd.include(request,response);
		} catch(Exception e ) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response); 
		}
	}
	
}
