package delivery.cart.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMoneyDAO {
	public int getMoney(String id) {
		int money=-1;
		String sql="select money from deliveryMember where id=?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);

				pstmt.setString(1, id);
		
			rs=pstmt.executeQuery();
			if(rs.next()) {
			money=rs.getInt("money");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
		
		return money;
	}
}
