package delivery.cart.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.cart.dao.GetMoneyDAO;
import delivery.cart.dao.PlusMoneyDAO;
import delivery.member.action.Action;
import delivery.member.dto.MemberDTO;

public class PlusMoneyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("dto");
		GetMoneyDAO gdao = new GetMoneyDAO();
		PlusMoneyDAO pdao = new PlusMoneyDAO();
			String id=dto.getId();
			int money =gdao.getMoney(id)+1000000;
		pdao.plusMoney(id,money);
			dto.setMoney(money);
			session.setAttribute("dto", dto);
		
		RequestDispatcher rdp = request.getRequestDispatcher("main/Main.jsp");
		rdp.forward(request, response);
		
	}

}
