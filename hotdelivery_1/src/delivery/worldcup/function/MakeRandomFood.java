package delivery.worldcup.function;

import java.util.ArrayList;

import delivery.member.dto.MemberDTO;
import delivery.worldcup.dao.MakeRandomFoodDAO;
import delivery.worldcup.dto.FoodDTO;

public class MakeRandomFood {
	public int[] randomFood(ArrayList<FoodDTO> selectKind) {
		int[] idx= new int[16];
			
		int su = 0;
		for(int i=0;i<idx.length;i++) {
			idx[i]=selectKind.get(i).getFoodNo();
		}
	      boolean bDash=false; // 중복 여부 확인. 중복 = true/중복 아님 = false
	      //난수 4개 발생

	      
	      for(int i=0; i<idx.length; i++)
	      {
	         bDash=true;
	         while(bDash) // 중복시 계속 루프 수행
	         {
	            su=(int)(Math.random()*16)+1;//1~9사이의 난수 발생
	            bDash=false;
	            
	            //중복 여부 확인
	            for(int j=0; j<i; j++)
	            {
	               if(idx[j]==su) // 중복된 수가 있다면
	               {
	                  // 다시 while문 수행(난수 다시 발생)
	                  bDash=true;
	                  break; //for문만 벗어남
	               }
	            }
	         }
	         idx[i]=su; // 중복이 없는 경우 저장
	         
	      }
	      for(int i=0;i<idx.length;i++) {
				selectKind.get(i).setFoodNo(idx[i]);
	      }
		return idx;
	}
	
	public ArrayList<FoodDTO> mixFood(ArrayList<FoodDTO> list) {
		ArrayList<FoodDTO> list16 = new ArrayList<>();
		int[] idx= new int[16];
		MakeRandomFoodDAO dao = new MakeRandomFoodDAO();
		FoodDTO dto = new FoodDTO();
		int su = 0;
		for(int i=0;i<idx.length;i++) {
			idx[i]=list.get(i).getFoodNo();
		}
	      boolean bDash=false; // 중복 여부 확인. 중복 = true/중복 아님 = false
	      //난수 4개 발생

	      
	      for(int i=0; i<idx.length; i++)
	      {
	         bDash=true;
	         while(bDash) // 중복시 계속 루프 수행
	         {
	            su=(int)(Math.random()*16)+1;//1~9사이의 난수 발생
	            bDash=false;
	            
	            //중복 여부 확인
	            for(int j=0; j<i; j++)
	            {
	               if(idx[j]==su) // 중복된 수가 있다면
	               {
	                  // 다시 while문 수행(난수 다시 발생)
	                  bDash=true;
	                  break; //for문만 벗어남
	               }
	            }
	         }
	         idx[i]=su; // 중복이 없는 경우 저장
	         
	      }
	      
	      for(int i=0;i<idx.length;i++) {
				dto=dao.selectFood(idx[i]);
				list16.add(dto);
	      }
		return list16;
	}
	
}
