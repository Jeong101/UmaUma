package delivery.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.dao.LoginIdCheckDAO;
import delivery.member.dto.MemberDTO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rdp = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("로그인 아이디 : "+id);
		System.out.println("로그인 비밀번호 : "+pwd);
		LoginIdCheckDAO dao = new LoginIdCheckDAO();

		int idCheck=dao.idcheck(id, pwd);

		if(idCheck==0) {
			response.sendRedirect("./login/login.jsp");
		}else if(idCheck==1) {
			HttpSession session =request.getSession();
			MemberDTO dto = new MemberDTO(id);
			session.setAttribute("dto", dto);
			rdp=request.getRequestDispatcher("./login/login.jsp");
			rdp.forward(request, response);
		}else if(idCheck==2) {
			MemberDTO dto = new MemberDTO();
			dto = dao.getInform(id);
			HttpSession session =request.getSession();
			session.setAttribute("dto", dto);
			System.out.println(dto.toString());
			rdp=request.getRequestDispatcher("/main/Main.jsp");
			rdp.forward(request, response);
		}
		
		
		
		response.setContentType("text/html; charset=utf-8");
	}

}
