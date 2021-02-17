package delivery.member.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import delivery.member.dto.MemberDTO;

public class UpdateMemberDAO {
	public MemberDTO updateMember(MemberDTO dto) {
		String sql="update deliveryMember set password=?, email=?,address=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			System.out.println("--------------");
			System.out.println(dto.getId());
			System.out.println(dto.getPwd());
			System.out.println(dto.getEmail());
			System.out.println(dto.getPwd());
			
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);			
			pstmt.setString(1, dto.getPwd());							
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
		
		
		return dto;
	}
}
