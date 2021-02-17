package delivery.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.action.Action;
import delivery.store.dto.FoodDTO;

public class payment implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String a = request.getParameter("price");
		System.out.println("price="+a);
		
//		
//		ArrayList<FoodDTO> dto = new ArrayList<FoodDTO>();
//		HttpSession session = request.getSession();
//		dto = (ArrayList)session.getAttribute("ftdo");
//		System.out.println(dto.toString());
		response.setContentType("text/html; charset= utf-8");
		String b = request.getParameter("name");
		System.out.println("name="+b);
		
		

	}

}
