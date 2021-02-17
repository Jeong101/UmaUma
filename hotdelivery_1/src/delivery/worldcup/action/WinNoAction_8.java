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

public class WinNoAction_8 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MakeRandomFoodDAO dao = new MakeRandomFoodDAO();
		ArrayList<FoodDTO> list16 = (ArrayList<FoodDTO>) session.getAttribute("list");
		ArrayList<FoodDTO> list8= (ArrayList<FoodDTO>) session.getAttribute("list8");
		ArrayList<FoodDTO> list4 = (ArrayList<FoodDTO>) session.getAttribute("list4");
		ArrayList<FoodDTO> list2 = (ArrayList<FoodDTO>) session.getAttribute("list2");
		ArrayList<FoodDTO> list_win = (ArrayList<FoodDTO>) session.getAttribute("list_win");
		
		FoodDTO dto = new FoodDTO();
		int round = (Integer) session.getAttribute("round");
		round+=1;
		int cnt = (Integer) session.getAttribute("cnt");

		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("숫자"+num);
		dto = dao.selectFood(num);
		if(round == 8){
			list8.add(dto);
			session.setAttribute("list", list8);
			for (int i = 0; i < list8.size(); i++) {
				System.out.print(list8.get(i).getFoodNo() + "/");
			}
		}
		if(round == 12){
			list4.add(dto);
			session.setAttribute("list", list4);
			for (int i = 0; i < list4.size(); i++) {
				System.out.print(list4.get(i).getFoodNo() + "/");
			}
		}
		if(round == 14){
			list2.add(dto);
			session.setAttribute("list", list2);
			for (int i = 0; i < list2.size(); i++) {
				System.out.print(list2.get(i).getFoodNo() + "/");
			}
		}
		if(round == 15){
			list_win.add(dto);
			session.setAttribute("list", list_win);
			for (int i = 0; i < list_win.size(); i++) {
				System.out.print(list_win.get(i).getFoodNo() + "/");
			}
		}
		
		
		if (round < 8) {						// 16강 보여주고 8강 담고
			session.setAttribute("list", list16);
			list8.add(dto);
			System.out.println("16강");
			for (int i = 0; i < list8.size(); i++) {
				System.out.print(list8.get(i).getFoodNo() + "/");
			}
			
			
		} else if (round >8 && round < 12) {	// 8강 보여주고 4강 담고

			session.setAttribute("list", list8);

			list4.add(dto);

			System.out.println("8강");
			for (int i = 0; i < list4.size(); i++) {
				System.out.print(list4.get(i).getFoodNo() + "/");
			}
		} else if (round > 12 && round < 14) {	// 4강 보여주고 결승 담고
			
			list2.add(dto);
			
			session.setAttribute("list", list4);
			
			for (int i = 0; i < list2.size(); i++) {
				System.out.print(list2.get(i).getFoodNo() + "/");
			}
		} else if (round >14 && round <15) {				// 결승 보여줌
			
			session.setAttribute("list", list2);
			
			for (int i = 0; i < list_win.size(); i++) {
			System.out.print(list_win.get(i).getFoodNo() + "/");
			}
		}
		session.setAttribute("cnt", cnt + 2);
		session.setAttribute("round", round);
		RequestDispatcher rdp = request.getRequestDispatcher("worldCup/round_16.jsp");
		rdp.forward(request, response);

	}

}
