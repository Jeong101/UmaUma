package delivery.store.dao;

import static db.DBManager.getConnection;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.tomcat.util.digester.SetRootRule;

import delivery.store.dto.FoodDTO;
import delivery.store.dto.StoreDTO;

public class StoreListDAO {
	Connection conn = null;
	
	   public StoreListDAO(){
	      conn = getConnection();
	   }
	   // 가게의 총개수
	   public int storeCount(int num){
		   String sql = "select count(*) store storeNo =?";
		   PreparedStatement pstmt = null;
		      
	      ResultSet rs = null;
	      int count = 0;
	      
	      try {
	         pstmt= conn.prepareStatement(sql);
	         rs =pstmt.executeQuery();
	         
	         if(rs.next()) {
	             count = rs.getInt(1);
	             System.out.println("count는"+count);
	         }
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      } 
		      
	      return count;
	   }
	   
	   //메뉴가 가지고있는 storeNo 가게
	   public ArrayList<StoreDTO> storeList(ArrayList<Integer> storeNoList){
		   String sql = "select * from store";
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   ArrayList<StoreDTO> storelist = new ArrayList<StoreDTO>();
		   StoreDTO dto = null;
		   
		   ArrayList<StoreDTO> dtoo = new ArrayList<StoreDTO>();
		   
		   System.out.println("size"+storeNoList.size());	// 7,8,9,10 일식을 담고있는 storeNoList 
		
		   StoreDTO stdo = null;
		   try{
			   pstmt=conn.prepareStatement(sql);
			   rs=pstmt.executeQuery();
			   while(rs.next()){
				   for(int i =0; i<storeNoList.size();i++) {
//					   System.out.println("storeNoList.get("+i+")"+storeNoList.get(i));
					   if(storeNoList.get(i).equals(rs.getInt("storeNo"))) {
						   
						   dto = new StoreDTO(rs.getInt("storeNo"),
								   rs.getString("storeName"), 						   
								   rs.getString("storePhone"),
								   rs.getString("address"),
								   rs.getDouble("longitude"), 
								   rs.getDouble("latitude"),
								   rs.getString("imgUrl"));
						   storelist.add(dto);
					   }
				   }
				   
//				   dto = new StoreDTO(rs.getInt("storeNo"),
//						   rs.getString("storeName"), 						   
//						   rs.getString("storePhone"),
//						   rs.getString("address"),
//						   rs.getDouble("longitude"), 
//						   rs.getDouble("latitude"));
//				   storelist.add(dto);
			   }
			  
			   for(int i=0;i<storeNoList.size();i++){
				   for(int j=0;j<storelist.size();j++){
					   if(storelist.get(j).getStoreNo() == storeNoList.get(i)){
						   stdo=new StoreDTO(storeNoList.get(i),
								   storelist.get(i).getStoreName(),
								   storelist.get(i).getStorePhone(),
								   storelist.get(i).getAddress(),
								   storelist.get(i).getLatitude(),
								   storelist.get(i).getLongitude(),
								   storelist.get(i).getImgUrl());
						   dtoo.add(stdo);
					   }
				   }
			   }
		   }catch(Exception e) {
			   System.out.println("실패");
			   e.printStackTrace();
		   }
		   return dtoo; 
	   }
	   //
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
//			    	str+=n[i];
			    	storeNoTemp.add(n[i]);
			    }
			   }
		   }catch(Exception e) {
			   System.out.println("중복제거실패부분");
			   e.printStackTrace();
		   }
		   
		   return storeNoTemp; 
	   }
	public ArrayList<FoodDTO> findFood(int storeNO) {
		String sql = "select * from food where storeNo = "+storeNO;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FoodDTO fdto = null;
		ArrayList<FoodDTO> list = new ArrayList<FoodDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				fdto = new FoodDTO(rs.getInt("storeNo"),
						rs.getInt("foodKind"),
						rs.getString("foodName"),
						rs.getInt("price"));
			
				list.add(fdto);
	
			}
			System.out.println("성공");
			System.out.println("list"+ list.toString());
			
		} catch(Exception e) {
			System.out.println("실패입니다.");
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	public ArrayList<StoreDTO> selectStoreInfo(int storeNo){
		String sql ="select * from store where storeNo = "+ storeNo;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StoreDTO> list = new ArrayList<StoreDTO>();
		StoreDTO dto = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new StoreDTO(rs.getInt("storeNo"),
									rs.getString("storeName"),
									rs.getString("storePhone"),
									rs.getString("address"),
									rs.getDouble("latitude"),
									rs.getDouble("longitude"),
									rs.getString("imgUrl"));
				list.add(dto);
			}
			System.out.println("storeStoreInfo 정보" + list.toString());
		} catch(Exception e) {
			System.out.println("selectStoreInfo 실패");
			e.printStackTrace();
		}
		
		return list;
	}
	   
}
