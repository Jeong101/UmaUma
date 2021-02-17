package delivery.worldcup.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.action.Action;
import delivery.store.dao.StoreListDAO;
import delivery.store.dto.StoreDTO;
import delivery.worldcup.dao.MakeRandomFoodDAO;
import delivery.worldcup.dao.StoreDAO;
import delivery.worldcup.dto.FoodDTO;
import delivery.worldcup.function.MakeRandomFood;

public class FoodFindAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		MakeRandomFoodDAO dao = new MakeRandomFoodDAO();
		ArrayList<FoodDTO> list = new ArrayList<FoodDTO>();
		ArrayList<StoreDTO> slist = new ArrayList<StoreDTO>();
		ArrayList<StoreDTO> slist_2 = new ArrayList<StoreDTO>();
		
		StoreDAO sdao = new StoreDAO();
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("이거다"+num);
		String foodcode = null;
		
		list=dao.findStore(num);
		for(int i=0; i<list.size(); i++){
			System.out.println("푸드코드"+list.get(i).getFoodCode());
			foodcode = list.get(i).getFoodCode();
		}
		
		slist = sdao.selectStore();
		
		String[] str =new String[slist.size()];				// 선택한 푸드코드 담는 배열
		
		for(int i=0;i<slist.size();i++) {
			 str[i] = slist.get(i).getFoodCode();
			 System.out.println(str[i]);
		}
						// 비교할 객체의 코드
		
		for(int i=0;i<slist.size();i++) {
						
			String[] str2=str[i].split(",");

			for(int j=0;j<str2.length;j++) {
				if(str2[j].equals(foodcode)) {
					slist_2.add(slist.get(i));
				}
			}
			
		}
				 
				 
				/* else {
				str2=str[i].split(",");
				//비교
					for(int k=0;k<str2.length;k++) {
						if(foodcode.equals(str2[k])) {
							if(foodcode.equals(str2[k])) {
								 slist_2.add(slist.get(i));
							 }	
						}
					}
				 }
				
						
			 }
			
		}*/
		
/*		
		for(int i=0; i<slist.size(); i++){
			
			if(slist.get(i).getFoodCode().equals(foodcode))
//			 str[i] = slist.get(i).getFoodCode();
//			 System.out.print(str[i]+"/");

			 if(str[i].length() >=2){
				 
				 str2=str[i].split(",");
				 
				 for(int j=0; j<str2.length; j++){
				 System.out.println("나눈거["+j+"]"+str2[j]);
				 }
			 }
		}
			
		for(int i = 0; i < slist.size(); i++){
			if(str[i].equals(foodcode)){
				slist_2=sdao.codefind(foodcode);
				
			}else if(slist.get(i).getFoodCode().equals(foodcode)){
				slist_2=sdao.codefind(foodcode);
			}
		}		
*/		request.setAttribute("store", slist_2);
		
	RequestDispatcher rdp = request.getRequestDispatcher("worldCup/store.jsp");
	rdp.forward(request, response);
	}

}
