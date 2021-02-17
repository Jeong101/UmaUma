package delivery.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.action.Action;

/**
 * Servlet implementation class FrontCnt
 */
@WebServlet("/count")
public class FrontCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		int cnt = Integer.parseInt(request.getParameter("price"));
		HttpSession session = request.getSession();
//		int ccc = Integer.parseInt(request.getParameter("cnt").trim());
	
		System.out.println("매핑에서 price값을 세션 "+cnt);
//		System.out.println("매핑에서 cnt값을 세션 "+ccc);
		System.out.println("command="+command);
		ActionForward af = new ActionForward();
		
		response.setContentType("text/html; charset= utf-8");
		Action action = af.getAction(command);
		if(action!=null) {
			action.execute(request, response);
		}else {
			response.sendRedirect("error/Error.jsp");
		}
	}

}
