package green.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import green.vo.Person;


@SuppressWarnings("serial")
@WebServlet("/r")
public class RequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
			Person person = new Person();
			person.setName("가빙");
			person.setPersonId("010928-1111111");
			person.setNum(5);
			request.setAttribute("a", "7");
			request.setAttribute("person", person);//키값을 person로
			//jsp에서 requestScope.person 
			request.setAttribute("pw", request.getParameter("pw"));
			request.setAttribute("addr", request.getParameter("addr"));
			request.setAttribute("tel", request.getParameter("tel"));
			RequestDispatcher rd = request.getRequestDispatcher("1.jsp");
			rd.forward(request, response);
	}

}
