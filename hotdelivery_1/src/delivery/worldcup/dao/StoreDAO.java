package delivery.worldcup.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.store.dto.StoreDTO;
import delivery.worldcup.dto.FoodDTO;

public class StoreDAO {
	public ArrayList<StoreDTO> codefind(String foodcode) {
		ResultSet rs = null;
		ArrayList<StoreDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		StoreDTO dto = null;
		String sql = "select * from store where foodcode='i,j'";
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,foodcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			list.add(dto = new StoreDTO(rs.getInt("storeNo"),
										rs.getString("storeName"),
										rs.getString("storePhone"),
										rs.getString("address"),
										rs.getDouble("latitude"),
										rs.getDouble("longitude"),
										rs.getString("imgUrl"),
										rs.getString("foodcode")));				
			}
	
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	public String findcode(String foodcode){
		if(foodcode.equals("l")){
			foodcode = "i,j,l";
		}
		else if(foodcode.equals("i") || foodcode.equals("j") ){
			foodcode="i,j";
		}
		else if(foodcode.equals("f") ||foodcode.equals("g")){
			foodcode = "f,g";
		}
		
		return foodcode;
	}
	
	public ArrayList<StoreDTO> codefind_2(String foodcode) {
		ResultSet rs = null;
		ArrayList<StoreDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		StoreDTO dto = null;
		String sql = "select * from store where foodcode="+foodcode+","+foodcode;
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			list.add(dto = new StoreDTO(rs.getInt("storeNo"),
										rs.getString("storeName"),
										rs.getString("storePhone"),
										rs.getString("address"),
										rs.getDouble("latitude"),
										rs.getDouble("longitude"),
										rs.getString("imgUrl"),
										rs.getString("foodcode")));				
			}
	
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	public ArrayList<StoreDTO> selectStore() {
		ResultSet rs = null;
		ArrayList<StoreDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		StoreDTO dto = null;
		String sql = "select * from store";
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			list.add(dto = new StoreDTO(rs.getInt("storeNo"),
										rs.getString("storeName"),
										rs.getString("storePhone"),
										rs.getString("address"),
										rs.getDouble("latitude"),
										rs.getDouble("longitude"),
										rs.getString("imgUrl"),
										rs.getString("foodcode")));				
			}
	
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		
	}

}
