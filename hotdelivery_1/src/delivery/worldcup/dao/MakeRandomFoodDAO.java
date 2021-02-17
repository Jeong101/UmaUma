package delivery.worldcup.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.member.dao.IDcheckDAO;
import delivery.worldcup.action.WorldCupAction;
import delivery.worldcup.dto.FoodDTO;

public class MakeRandomFoodDAO {
//	public void saveNo(int foodNo){
//			
//		}
	public ArrayList<FoodDTO> selectKind() {
		ResultSet rs = null;
		ArrayList<FoodDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		FoodDTO dto = null;
		String sql = "select * from worldCup";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new FoodDTO(rs.getString("foodKind"), rs.getInt("foodNo"), rs.getString("imgUrl"));
				// System.out.println("결과값 : "+rs.getString("foodKind")+
				// rs.getInt("foodNo")+
				// rs.getString("imgUrl"));
				list.add(dto);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}
	public FoodDTO selectFood(int num) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		FoodDTO dto = null;
		String sql = "select * from worldCup where foodNo=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new FoodDTO(rs.getString("foodKind"), rs.getInt("foodNo"), rs.getString("imgUrl"));
				// System.out.println("결과값 : "+rs.getString("foodKind")+
				// rs.getInt("foodNo")+
				// rs.getString("imgUrl"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}

		return dto;
	}

	public ArrayList<FoodDTO> setDTO(ArrayList<FoodDTO> list) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		FoodDTO dto = null;
		String sql = "select * from worldCup where foodNo=?";
		/*WorldCupAction wa =new WorldCupAction();*/
		//int cnt = wa.getCnt();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < list.size(); i++) {
				pstmt.setInt(1, list.get(i).getFoodNo());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					list.add(dto = new FoodDTO(rs.getString("foodKind"), rs.getInt("foodNo"), rs.getString("imgUrl")));				
				}
			}
	
	
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	
	
	public ArrayList<FoodDTO> setUrl(int[] idx) {
		ResultSet rs = null;
		ArrayList<FoodDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		FoodDTO dto = null;
		String sql = "select * from worldCup where foodNo=?";
		/*WorldCupAction wa =new WorldCupAction();*/
		//int cnt = wa.getCnt();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < idx.length; i++) {
				pstmt.setInt(1, idx[i]);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					list.add(dto = new FoodDTO(rs.getString("foodKind"), rs.getInt("foodNo"), rs.getString("imgUrl")));				
				}
			}
	
	
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	public ArrayList<FoodDTO> setUrl_2(ArrayList<Integer> idx) {
		ResultSet rs = null;
		ArrayList<FoodDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		FoodDTO dto = null;
		String sql = "select * from worldCup where foodNo=?";
		/*WorldCupAction wa =new WorldCupAction();*/
		//int cnt = wa.getCnt();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < idx.size(); i++) {
				pstmt.setInt(1, idx.get(i));
				rs = pstmt.executeQuery();
				if (rs.next()) {
					list.add(dto = new FoodDTO(rs.getString("foodKind"), rs.getInt("foodNo"), rs.getString("imgUrl")));				
				}
			}
	
	
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	public ArrayList<FoodDTO> findStore(int num) {
		ResultSet rs = null;
		ArrayList<FoodDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		FoodDTO dto = null;
		String sql = "select * from worldCup where foodNo=?";
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

		
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			list.add(dto = new FoodDTO(rs.getString("foodKind"), rs.getInt("foodNo"), rs.getString("imgUrl"),rs.getString("foodcode")));				
			}
	
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
		
	}

}
