package delivery.cart.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.cart.dao.ShowCartListDAO;
import delivery.cart.dto.CartDTO;
import delivery.member.action.Action;
import delivery.member.dto.MemberDTO;

public class ShowCartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("dto"); 
		ShowCartListDAO dao = new ShowCartListDAO();
		System.out.println("11111111111111111111");
		ArrayList<CartDTO> list = dao.showList(dto);
		System.out.println("******************");
		for(int i=0;i<list.size();i++)
		System.out.println("여기다 여기 상호형거 아니다 여기다"+list.get(i).toString());
		session.setAttribute("cartList", list);
		RequestDispatcher rdp = request.getRequestDispatcher("cart/cart.jsp");
		rdp.forward(request, response);
		
	}

}
