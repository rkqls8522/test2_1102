package green.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.dao.PersonDao;

@WebServlet("/person/delete")
public class PersonDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	System.out.println("PersonDeleteServlet doGet ok");
    try {
      ServletContext sc = this.getServletContext();
      PersonDao personDao = (PersonDao)sc.getAttribute("personDao");
      int num = Integer.parseInt(request.getParameter("num"));
      personDao.delete(num);
      response.sendRedirect("list");
    } catch (Exception e) {
    	e.printStackTrace();
    	request.setAttribute("error", e);
    	RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
    	rd.forward(request, response);
    }
  }
}