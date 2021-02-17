package delivery.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.dao.UpdateMemberDAO;
import delivery.member.dto.MemberDTO;

public class UpdateMemberAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		 
	      if(session==null){
	         response.sendRedirect("메인페이지");
	      }else if(session!=null){//조건수정
	    	  MemberDTO dto = (MemberDTO)session.getAttribute("dto");
		         System.out.println(dto.toString());
	         UpdateMemberDAO dao = new UpdateMemberDAO();
	         String password=request.getParameter("updatePwd");
	         String email = request.getParameter("updateEmail");
	         String address = request.getParameter("updateAddress");
	          
	         
	         dto = new MemberDTO(dto.getId(),password,email,address);
	         
	         dto = dao.updateMember(dto);
	         session.setAttribute("dto", dto);
	         RequestDispatcher rdp = request.getRequestDispatcher("main/Main.jsp");
	         rdp.forward(request, response);
	      }
	}

}
