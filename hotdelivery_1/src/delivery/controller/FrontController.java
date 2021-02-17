package delivery.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery.member.action.Action;

@WebServlet("/deliveryServlet")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String command = request.getParameter("command");
		System.out.println("커맨드"+command);
		ActionForward af = new ActionForward();
		Action action = af.getAction(command);
		response.setCharacterEncoding("text/html; charset=utf-8");
		if(action!=null) {
			action.execute(request, response);
		}else {
			response.sendRedirect("error/Error.jsp");
		}
	}

}
