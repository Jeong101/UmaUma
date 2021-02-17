package delivery.member.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.dao.IDcheckDAO;
import delivery.member.dao.RegistMemberDAO;
import delivery.member.dto.MemberDTO;

public class RegistMemberAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		MemberDTO dto = new MemberDTO();
		//요청처리
		request.setCharacterEncoding("utf-8");
		//비즈니스 로직
		String id=request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name= request.getParameter("name");
		System.out.println("한글이름:"+name);
		String email= request.getParameter("email");
		String address=request.getParameter("address");
		String kind = request.getParameter("user");
		IDcheckDAO chkdao = new IDcheckDAO();
		System.out.println(id+pwd+name+email+address+"여기 회원정보");
		int idChk=chkdao.idCheck(id);//0은 회원가입가능 1은 중복
		HttpSession session = request.getSession();
		if(idChk==0) {
		 dto= new MemberDTO(id,pwd,name,email,address,kind);
		session.invalidate();
		RegistMemberDAO dao = new RegistMemberDAO();
		dao.insertMember(dto);
		//응답처리
		response.setContentType("text/html; charset= utf-8");
		response.sendRedirect("main/Main.jsp");
		}else if(idChk==1) {
			dto=new MemberDTO(pwd,name,email,address);
			
			session.setAttribute("dto", dto);
			response.setContentType("text/html; charset= utf-8");
			RequestDispatcher rdp = request.getRequestDispatcher("regist/UserCreate.jsp");
			rdp.forward(request, response);
		}
		}	
		
}
