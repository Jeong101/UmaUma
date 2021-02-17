package delivery.member.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IDcheckDAO {
	public int idCheck(String id) {
		String sql="select id from deliveryMember where id=?";
		int idCheck=0;//0은 비회원 1은 아이디만 체크해서 있음
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				if(id.equals(rs.getString("id"))) {
					idCheck=1;
				}else {
					idCheck=0;
				}
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
		return idCheck;
	}
}
