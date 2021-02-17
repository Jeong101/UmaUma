package delivery.food.dao;

//getConnection();
import static db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import delivery.store.dto.FoodDTO;
import delivery.store.dto.StoreDTO;


public class FoodDAO {
Connection conn = null;
   
   public FoodDAO(){
      conn = getConnection();
   }
   
   public int countFood(String search) {
      String sql = "select count(*) from food where foodName LIKE '%"+search+"%' ";
      PreparedStatement pstmt = null;
      
      ResultSet rs = null;
      int count = 0;
      
      try {
         pstmt= conn.prepareStatement(sql);
         rs =pstmt.executeQuery();
         
         if(rs.next()) {
             count = rs.getInt(1);
         }
         System.out.println("1단계 성공");
         
      } catch(Exception e) {
    	  System.out.println("1실패");
         e.printStackTrace();
      } 
      
      return count;
   }
   
   public ArrayList<Integer> searchFood(String search,int count) {
//      String sql = "select * from food where foodName LIKE '%찌게' ";
      String sql = "select * from food where foodName LIKE '%"+search+"%' ";
      System.out.println(sql);
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<FoodDTO> list = new ArrayList<FoodDTO>();
      String[] resultFood; //5
      
      
      int a=0;
      int p=0;
      int aTemp;
      int[] n = new int[100];
      ArrayList<Integer> storeNoTemp = new ArrayList<Integer>();
      try {
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         resultFood=new String[count];
            while(rs.next()){
            	a = rs.getInt("storeNo");
            	n[p] = a;
            	p++;
               FoodDTO dto = new FoodDTO(rs.getInt("storeNo"),
                           rs.getInt("foodkind"),
                           rs.getString("foodName"),
                           rs.getInt("price"));
               list.add(dto);
            }
         // 중복숫자 제거
			   for (int i=0; i<n.length; i++) {
			    for (int j=0; j<n.length; j++) {
			     if (n[i] == n[j]) {
			    	 aTemp = n[i];
			      n[j] = 0;
			      n[i] = aTemp;     
			     }
			    }   
			    }

			   for (int i=0; i<n.length; i++) {
			    if (n[i] > 0) {
			    	//가게번호 중복을 제거하고 가게의 총갯수를 담는곳
			    	System.out.println("중복제거한후 담은 값"+n[i]);
			    	storeNoTemp.add(n[i]);
			    }
			   }
			   
            
            
      } catch(Exception e) {
    	  System.out.println("2실패");
         e.printStackTrace();
      } 
      
      return storeNoTemp;
   }
   
   // 검색된 음식을 가지고 있는 가게의 번호를 찾아 가게주소를 찾을거임
   public ArrayList<StoreDTO> searchAllStore(ArrayList<Integer> storeNoList) {//위도
      
      //검색한 요리의 가게no랑 가게table의 가게no가 같으면 위도,경도 가져오기
//      String sql = "select latitude,longitude from store1 where storeNo IN (select storeNo from food)";
//      String sql = "select * from store1 where storeNo IN (select storeNo from food)";
      String sql = "select * from store order by storeNo asc";
      float x=0f;
      float y=0f;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<StoreDTO> list = new ArrayList<StoreDTO>();   
      ArrayList<StoreDTO> dtoo = new ArrayList<StoreDTO>();
      try {
         pstmt= conn.prepareStatement(sql);
         rs =pstmt.executeQuery();////
         
         while(rs.next()) {
//            StoreDTO sdto = new StoreDTO(rs.getInt("storeNo"),
//					   rs.getString("storeName"), 						   
//					   rs.getString("storePhone"),
//					   rs.getString("address"),
//					   rs.getDouble("longitude"), 
//					   rs.getDouble("latitude"),
//					   rs.getString("imgUrl"));
//            list.add(sdto);
        	 
        	 for(int i =0; i<storeNoList.size();i++) {
//				   System.out.println("storeNoList.get("+i+")"+storeNoList.get(i));
				   if(storeNoList.get(i).equals(rs.getInt("storeNo"))) {
					   
					   StoreDTO dto = new StoreDTO(rs.getInt("storeNo"),
							   rs.getString("storeName"), 						   
							   rs.getString("storePhone"),
							   rs.getString("address"),
							   rs.getDouble("longitude"), 
							   rs.getDouble("latitude"),
							   rs.getString("imgUrl"));
					   list.add(dto);
				   }
			   }
         }
         for(int i=0;i<storeNoList.size();i++){
			   for(int j=0;j<list.size();j++){
				   if(list.get(j).getStoreNo() == storeNoList.get(i)){
					   StoreDTO stdo=new StoreDTO(storeNoList.get(i),
							   list.get(i).getStoreName(),
							   list.get(i).getStorePhone(),
							   list.get(i).getAddress(),
							   list.get(i).getLatitude(),
							   list.get(i).getLongitude(),
							   list.get(i).getImgUrl());
					   dtoo.add(stdo);
				   }
			   }
		   }
      } catch(Exception e) {
         e.printStackTrace();
      }
      return dtoo;
   }
   
   public ArrayList<Integer> storeNoList(int num){	//foodKind = 2 (일식)
	   String sql = "select storeNo from food where foodKind = " +num;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   int p=0;
	   int[] n;
	   n=new int[100];
	   int a=0;
	   int aTemp;
	   ArrayList<Integer> storeNoTemp = new ArrayList<Integer>();
	   try{
		   pstmt=conn.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next()){
			   a = rs.getInt("storeNo");
			   n[p] = a;
			   p++;
		   }
		// 중복숫자 제거
		   for (int i=0; i<n.length; i++) {
		    for (int j=0; j<n.length; j++) {
		     if (n[i] == n[j]) {
		    	 aTemp = n[i];
		      n[j] = 0;
		      n[i] = aTemp;     
		     }
		    }   
		    }
		   
		   for (int i=0; i<n.length; i++) {
		    if (n[i] > 0) {
		    	//가게번호 중복을 제거하고 가게의 총갯수를 담는곳
		    	System.out.println("중복제거");
		    	System.out.println(n[i]);
//		    	str+=n[i];
		    	storeNoTemp.add(n[i]);
		    }
		   }
	   }catch(Exception e) {
		   System.out.println("중복제거실패부분");
		   e.printStackTrace();
	   }
	   
	   return storeNoTemp; 
   }
   public ArrayList<FoodDTO> foodInfo(){
		String sql ="select * from food";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FoodDTO> list = new ArrayList<FoodDTO>();
		FoodDTO dto = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new FoodDTO(rs.getInt("storeNo"),
									rs.getInt("foodKind"),
									rs.getString("foodName"),
									rs.getInt("price"));
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}