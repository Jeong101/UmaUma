package delivery.member.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindPwdDAO {
	public String findPwd(String id,String name, String email) {
		String sql="select password from deliveryMember where name=? and email=? and id=?";
		String pwd="";
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				pwd=rs.getString("password");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
		return pwd;
	}
}
