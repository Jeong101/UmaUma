package delivery.store.choice;

import java.io.IOException;
import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.store.dao.StoreListDAO;
import delivery.store.dto.FoodDTO;
import delivery.store.dto.StoreDTO;

/**
 * Servlet implementation class SelectStore
 */
@WebServlet("/selectStore.do")
public class SelectStore extends HttpServlet implements Serializable {
   private static final long serialVersionUID = 1L;
     static int sum = 0;
    public SelectStore() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
   }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       
       int storeNo = Integer.parseInt(request.getParameter("num").trim());
      System.out.println("가게번호"+ storeNo);
      
      
      //storeSelect에서 가져온 가게번호!
      
      ArrayList<FoodDTO> fdto = null;
      StoreListDAO dao = new StoreListDAO();   
      fdto = dao.findFood(storeNo);   //가게넘버를 가진 음식을 전부 가져와서 리스트에 저장
      
      ArrayList<StoreDTO> store = null;
      store = dao.selectStoreInfo(storeNo);
         
      System.out.println("넘긴거 확인1"+store.toString());
      System.out.println("넘긴거 확인2"+fdto.toString());
      
      HttpSession session = request.getSession();
      session.setAttribute("store", store);
      session.setAttribute("fdto", fdto);
      int num=0;
      session.setAttribute("num", num);
      session.setAttribute("sum", sum);
       
       // 위에 방식으로하면 잘넘어감.
       //밑에방식으로 하면 css적용이 안됨.
//      response.sendRedirect("./storelist/select.jsp");
      RequestDispatcher rdp = request.getRequestDispatcher("./storelist/select.jsp");
      rdp.forward(request, response);
      
      
   }

}