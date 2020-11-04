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
import green.vo.Person;

@SuppressWarnings("serial")
@WebServlet("/person/add")
public class PersonAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PersonAddServlet doGet ok");
		RequestDispatcher rd = request.getRequestDispatcher(
				"/person/PersonForm.jsp"
				);
		rd.forward(request, response); //jsp페이지로 이동 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PersonAddServlet doPost ok");
		try {
			ServletContext sc = this.getServletContext();
			PersonDao personDao = (PersonDao) sc.getAttribute("personDao");
			personDao.insert((new Person())
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
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
