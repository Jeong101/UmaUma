package delivery.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery.member.dao.FindIdDAO;
import delivery.member.dao.FindPwdDAO;

public class FindPwdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rdp = null;
		String id = request.getParameter("findpwdId");
		String name = request.getParameter("findpwdName");
		String email = request.getParameter("findpwdEmail");
		
		FindPwdDAO dao = new FindPwdDAO();
		
		String findPwd=dao.findPwd(id,name, email);
		if(findPwd.length()!=0) {
			request.setAttribute("id", id);
			request.setAttribute("findPwd", findPwd);
		
			rdp=request.getRequestDispatcher("login/login.jsp");
			rdp.forward(request, response);
		}else {
			
			response.sendRedirect("login/login.jsp");
		}
		
		response.setContentType("text/html; charset=utf-8");
	}

}
