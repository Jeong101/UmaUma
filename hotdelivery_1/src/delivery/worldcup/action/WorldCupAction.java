package delivery.worldcup.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.action.Action;
import delivery.worldcup.dao.MakeRandomFoodDAO;
import delivery.worldcup.dto.FoodDTO;
import delivery.worldcup.function.MakeRandomFood;

public class WorldCupAction implements Action {
	
@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeRandomFood makeNum= new MakeRandomFood();
		MakeRandomFoodDAO dao = new MakeRandomFoodDAO();
		FoodDTO dto = new FoodDTO();
		ArrayList<FoodDTO> list16 = new ArrayList<>();
		ArrayList<FoodDTO> list8 = new ArrayList<>();
		ArrayList<FoodDTO> list4 = new ArrayList<>();
		ArrayList<FoodDTO> list2 = new ArrayList<>();
		ArrayList<FoodDTO> list_win = new ArrayList<>();
		
		list16=dao.selectKind();

		int cnt=0;		
		int round=0;
		
		list16=makeNum.mixFood(list16);
		
		HttpSession session = request.getSession();

		session.setAttribute("round", round);
		session.setAttribute("list", list16);
		session.setAttribute("list8", list8);
		session.setAttribute("list4", list4);
		session.setAttribute("list2", list2);
		session.setAttribute("list_win", list_win);
		
		session.setAttribute("cnt", cnt);
		
		RequestDispatcher rdp = request.getRequestDispatcher("worldCup/round_16.jsp");
		rdp.forward(request, response);
		
		
	}

}
