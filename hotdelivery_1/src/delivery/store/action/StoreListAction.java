package delivery.store.action;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import delivery.member.action.Action;
import delivery.store.dao.StoreListDAO;
import delivery.store.dto.FoodDTO;
import delivery.store.dto.StoreDTO;

public class StoreListAction implements Action,Serializable {	//implements Serializable ..?? 자바를 하다보면 에러나는 부분

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 선택한 가게의 리스트
		// foodkind = 1 이면 양식푸드 
		// 양식푸드가 1인 storeNo애들을 위치를 전부 가져와서 출력
		
		FoodDTO fooddto = null;
		StoreListDAO dao = new StoreListDAO();
		ArrayList<StoreDTO> storelist = null;
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("numCheck="+num);
		
		int count=0;
		ArrayList<StoreDTO> storedto = new ArrayList<StoreDTO>();
		ArrayList<Integer> storeNoList = new ArrayList<Integer>();
		
		
		
		//foodkind의 있는 storeNo와 store에 있는 storeNo가 같으면 store에 있는 xy값 출력.
		switch(num){
		case 1://양식
			storeNoList = dao.storeNoList(num);//food테이블에 있는 foodkind의 값중에 storeNo숫자들을 갔고있는 값을 중복제거해서 arraylist에 저장
			storedto = dao.storeList(storeNoList);//store에 있는 storeNo == food에 있는 storeNo가 같은지 비교하고 arraylist에 저장
			System.out.println(num+"의 case마지막부분"+storedto.toString());	
			break;
		case 2://일식
			storeNoList = dao.storeNoList(num);
			storedto = dao.storeList(storeNoList);
			System.out.println(storedto.toString());	
			break;
		case 3://중식	사이즈가 달라서 그렇다 사이즈 체크 부탁!
			
			
			storeNoList = dao.storeNoList(num);	//중복된 음식의 가게번호를 저장한 리스트
			storedto = dao.storeList(storeNoList);
			System.out.println(storedto.toString());	
			break;
		case 4://한식
			storeNoList = dao.storeNoList(num);
			storedto = dao.storeList(storeNoList);
			System.out.println("한식가게" + storedto.toString());	
			break;
			default:
				System.out.println("음식종류 error");
				break;
		}
		//
//		HttpSession session = request.getSession();
//		session.setAttribute("storedto", storedto);
//		session.setAttribute("count", count);
		
		request.setAttribute("storedto", storedto);
		request.setAttribute("count", count);
		//가게의 갯수
		
		//응답처리
       response.setContentType("text/html; charset= utf-8");
       RequestDispatcher rdp = request.getRequestDispatcher("./storelist/storeSelect.jsp");	//resURL
       rdp.forward(request, response);
	
		

	}

}
