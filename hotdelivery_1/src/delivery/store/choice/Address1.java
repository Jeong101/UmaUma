package delivery.store.choice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import delivery.member.dto.MemberDTO;

/**
 * Servlet implementation class Address1
 */
@WebServlet("/Address1.do")
public class Address1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Address1() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		String addr = (String)request.getParameter("inputAddr");
		System.out.println("asdadsasd"+addr);
		
		
		
		HttpSession session = request.getSession();
		  
	      MemberDTO dto = (MemberDTO)session.getAttribute("dto");
	      String address = addr;
//	      System.out.println("dto 주소 변경 전 " + dto.getAddress());
	      
	      dto = new MemberDTO(dto.getId(),dto.getName(),dto.getEmail(),dto.getAddress(),dto.getMoney(),
	    		  dto.getKind()  );
	      session.setAttribute("dto", dto);
	      
	      
	      System.out.println("dto 주소 변경 후 " + dto.toString());
		
		
		
		response.setContentType("text/html; charset=utf-8"); 
		RequestDispatcher rdp = request.getRequestDispatcher("./storelist/payment.jsp");
		rdp.forward(request, response);
		
		
	}

}
