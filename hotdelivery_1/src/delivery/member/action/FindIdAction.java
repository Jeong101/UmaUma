package delivery.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.dao.FindIdDAO;
import delivery.member.dao.LoginIdCheckDAO;
import delivery.member.dto.MemberDTO;

public class FindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rdp = null;
		String name = request.getParameter("findName");
		String email = request.getParameter("findEmail");
		
		FindIdDAO dao = new FindIdDAO();
		
		String findId=dao.findId(name, email);
			request.setAttribute("findId", findId);
		
			rdp=request.getRequestDispatcher("login/login.jsp");
			rdp.forward(request, response);

		
		response.setContentType("text/html; charset=utf-8");
	}

}
