package delivery.store.choice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.store.dto.FoodDTO;
import delivery.store.dto.StoreDTO;

/**
 * Servlet implementation class Address
 */
@WebServlet("/Address.do")
public class Address extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static int sum = 0;
    public Address() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      ArrayList<FoodDTO> flist = new ArrayList<FoodDTO>();
      flist = (ArrayList<FoodDTO>)session.getAttribute("fdto");
      ArrayList<FoodDTO> foodlist = new ArrayList<FoodDTO>();
      FoodDTO dto = null;
      int[] cnt = {0,0,0,0};
      for(int i=0;i<flist.size();i++) {
          cnt[i] = Integer.parseInt(request.getParameter("cnt"+i));
//          System.out.println("asdas"+cnt[i]);
//          System.out.println(cnt[i]);
          
      }
      for(int i=0;i<flist.size();i++) {
//         System.out.println(flist.get(i).getFoodName());
//         System.out.println("cnt배열에 있는 값 = "+cnt[i]);
         if(cnt[i]>0) {
            sum += flist.get(i).getPrice() * cnt[i];
            dto = new FoodDTO(flist.get(i).getFoodName(),cnt[i],flist.get(i).getPrice(),sum);
            foodlist.add(dto);
//            System.out.println("내가 선택한 음식값"+foodlist.get(i).getFoodName());
         }
      }
      System.out.println("sum"+sum);
   
      session.setAttribute("sum", sum);
      session.setAttribute("foodlist", foodlist);
      RequestDispatcher rdp = request.getRequestDispatcher("./storelist/select.jsp");
      rdp.forward(request, response);
      System.out.println("총합들고 넘김");
      
      
   
   }

}