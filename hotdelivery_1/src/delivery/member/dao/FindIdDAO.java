package delivery.member.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindIdDAO {

	public String findId(String name, String email) {
		String sql="select id from deliveryMember where name=? and email=?";
		String id="아이디가 없습니다.";
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				id=rs.getString("id");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
		return id;
	}
	
}
