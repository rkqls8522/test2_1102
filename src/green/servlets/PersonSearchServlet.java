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
@WebServlet("/person/search")
public class PersonSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PersonSearchServlet doGet ok");
		RequestDispatcher rd = request.getRequestDispatcher(
				"/person/PersonSearchForm.jsp"
				);
		rd.forward(request, response); //jsp페이지로 이동 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PersonSearchServlet doPost ok");
		try {
			ServletContext sc = this.getServletContext();
			PersonDao personDao = (PersonDao) sc.getAttribute("personDao");
			
			String name;
			name = request.getParameter("searchName");
			System.out.println("searchName 받았습니다 : " + name);
			request.setAttribute("persons", personDao.search(name));
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/person/PersonSearchList.jsp");
			rd.include(request,response);
		} catch(Exception e ) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response); 
		}
	}
	
}
