package delivery.cart.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlusMoneyDAO {

	public void plusMoney(String id, int money) {
		String sql="update deliveryMember set money=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
		
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);			
			pstmt.setInt(1, money);							
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
	}
}
