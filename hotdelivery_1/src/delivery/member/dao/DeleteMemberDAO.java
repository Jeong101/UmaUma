package delivery.member.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMemberDAO {
	public void DeleteMember(String id,String pwd) {
		String sql="delete from deliveryMember where id=? and password=?";
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.executeUpdate();
			
			System.out.println("삭제완료");
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("삭제실패");
		}finally {
			close(conn, pstmt);
		}
		
	}
}
