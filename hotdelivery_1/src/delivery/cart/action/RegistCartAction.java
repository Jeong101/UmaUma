package delivery.cart.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.cart.dao.GetMoneyDAO;
import delivery.cart.dao.InsertCartDAO;
import delivery.cart.dao.MinusMoneyDAO;
import delivery.member.action.Action;
import delivery.member.dto.MemberDTO;
import delivery.store.dto.FoodDTO;

public class RegistCartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
		String address = dto.getAddress();
			ArrayList<FoodDTO> foodList=(ArrayList<FoodDTO>)session.getAttribute("foodlist");
	
		String id=dto.getId();
			GetMoneyDAO gdao = new GetMoneyDAO();
			MinusMoneyDAO mdao = new MinusMoneyDAO();
			
		int sum = (Integer)session.getAttribute("sum");
		InsertCartDAO dao = new InsertCartDAO();
		int money = gdao.getMoney(id);
		
		if(dto.getMoney()>=sum) {
				money=money-sum;
			dao.insertCart(id,foodList,address);
			mdao.updateMoney(id,money);
			
				session.setAttribute("dto", dto);
				session.setAttribute("sum", sum);
				
			RequestDispatcher rdp = request.getRequestDispatcher("main/Main.jsp");
			rdp.forward(request, response);
		}else if(dto.getMoney()<sum) {
				session.setAttribute("dto", dto);
				session.setAttribute("sum", sum);
				
			RequestDispatcher rdp = request.getRequestDispatcher("mypage/myPage.jsp");
			rdp.forward(request, response);
		}
	}

}
