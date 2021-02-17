package delivery.store.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.food.dao.FoodDAO;
import delivery.store.dto.FoodDTO;
import delivery.store.dto.StoreDTO;

/**
 * Servlet implementation class StoreSearchServlet
 */
@WebServlet("/StoreSearchServlet")
public class StoreSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
     }

     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        String search = request.getParameter("search");
        
        	FoodDAO dao = new FoodDAO();
         String resURL = null;
         ArrayList<FoodDTO> food_dto = new ArrayList<FoodDTO>();
         ArrayList<Integer> storeNoList = new ArrayList<Integer>();
         
         int count = dao.countFood(search);
         request.setAttribute("count", count);
         storeNoList = dao.searchFood(search,count);//중복도 허용해서 저장 검색결과 저장
//         food_dto = dao.foodInfo();//food정보
         
        
         ArrayList<StoreDTO> storedto =null;
         storedto = dao.searchAllStore(storeNoList);	//중복제거
         System.out.println("중복제거한 서블릿에서 값"+storedto.toString());
//         Iterator<FoodDTO> its = food_dto.iterator();
//         Iterator<StoreDTO> itss = storedto.iterator();
//         
//         FoodDTO food = null;
//         int num =0;
//         while(its.hasNext()) {
//      	   for(int i = 0; i<count;i++) {	//검색한 개수.
//          	   food = its.next();
//          	   num = food.getStoreNo();
//          	   food_dto.get(i).setStoreNo(num);
//      	   }
//         }
//         
//         StoreDTO store = null;
//         System.out.println("사이즈 "+storedto.size());
//         while(itss.hasNext()) {
//      	   for(int i =0; i<storedto.size();i++) {
//  	    	   store= itss.next();
//  	    	   storedto.get(i).setLatitude(store.getLatitude());
//  	    	   storedto.get(i).setLongitude(store.getLongitude());
//  	    	   storedto.get(i).setStoreNo(store.getStoreNo());
//  	    	   storedto.get(i).setStoreName(store.getStoreName());
//  	    	   storedto.get(i).setStorePhone(store.getStorePhone());
//  	    	   storedto.get(i).setAddress(store.getAddress());
//  	    	   storedto.get(i).setImgUrl(store.getImgUrl());
//      	   }
//         }
//         ArrayList<StoreDTO> tmp = new ArrayList<StoreDTO>();
//         System.out.println("food사이즈"+food_dto.toString());
//         for(int j=0;j<count;j++) {
//  	       for(int i = 0; i<storedto.size();i++) {
//  		       if(food_dto.get(j).getStoreNo() == storedto.get(i).getStoreNo()) {
//  		    	   int no = storedto.get(i).getStoreNo();
//  		    	   String name = storedto.get(i).getStoreName();
//  		    	   String phone = storedto.get(i).getStorePhone();
//  		    	   String address = storedto.get(i).getAddress();
//  				   double xx = storedto.get(i).getLatitude();
//  				   double yy = storedto.get(i).getLongitude();
//  				   String img = storedto.get(i).getImgUrl();
//  				   tmp.add(new StoreDTO(no, name, phone, address, xx, yy, img));
//  			   }
//  		   }
//         }
         HttpSession session = request.getSession();
//         session.setAttribute("tmp", tmp);
         session.setAttribute("storedto",storedto);
         
          
         
//         request.setAttribute("tmp", tmp);
//         System.out.println("--");
         System.out.println(storedto.toString());
         
         //응답처리
         response.setContentType("text/html; charset= utf-8");
         RequestDispatcher rdp = request.getRequestDispatcher("./storelist/listStore.jsp");
         rdp.forward(request, response);
         
     }


}
