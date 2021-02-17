package delivery.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.dao.DeleteMemberDAO;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id=request.getParameter("deleteId");
		String password=request.getParameter("deletePwd");
		System.out.println("지울ID : "+id);
		System.out.println("지울 비밀번호 : "+password);
		DeleteMemberDAO dao = new DeleteMemberDAO();
		dao.DeleteMember(id, password);
		session.invalidate();
		RequestDispatcher rdp = request.getRequestDispatcher("main/Main.jsp");
		rdp.forward(request, response);
	}

}
