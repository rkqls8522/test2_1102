package green.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dao.PersonDao;
import green.vo.Person;


@SuppressWarnings("serial")
@WebServlet("/person/update")
public class PersonUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PersonUpdateServlet doGet ok");
		try {
			ServletContext sc = this.getServletContext();
			PersonDao personDao = (PersonDao) sc.getAttribute("personDao");
			Person person = personDao.selectOne(
					Integer.parseInt(request.getParameter("num"))
					);
			request.setAttribute("person", person);
			RequestDispatcher rd = 
				request.getRequestDispatcher("/person/PersonUpdateForm.jsp");
			rd.forward(request, response);
			} catch(Exception e){
				e.printStackTrace();
				request.setAttribute("error",e);
				RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
				rd.forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PersonUpdateServlet doPost ok");
		try {
			ServletContext sc = this.getServletContext();
			PersonDao personDao = (PersonDao) sc.getAttribute("personDao");
			personDao.update((new Person())
					.setNum(Integer.parseInt(request.getParameter("num")))
					.setName(request.getParameter("name"))
					.setPersonId(request.getParameter("personId"))
					.setJuso(request.getParameter("juso"))
					.setPhone(request.getParameter("phone"))
					.setSibling(Integer.parseInt(request.getParameter("sibling")))
					.setDadName(request.getParameter("dadName"))
					);
			response.sendRedirect("list");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp" );
			rd.forward(request, response);
		}
	}
}
