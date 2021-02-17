package delivery.cart.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.store.dto.FoodDTO;

public class InsertCartDAO {
/**
 * foodList 에서 getPrice가 수량 getQuantity가 가격
 * */
	public void insertCart(String id, ArrayList<FoodDTO> foodList,String address) {
		String sql="insert into cart(id,foodName,quantity,address,summoney) values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<foodList.size();i++) {
				pstmt.setString(1, id);
			pstmt.setString(2, foodList.get(i).getFoodName());
			pstmt.setInt(3, foodList.get(i).getPrice());
			pstmt.setString(4, address);
			pstmt.setInt(5, foodList.get(i).getSum());
			pstmt.executeUpdate();
			}
			System.out.println("입력완료");
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
		
	}

}
