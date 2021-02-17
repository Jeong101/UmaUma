package delivery.member.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import delivery.member.dto.MemberDTO;

public class RegistMemberDAO {
	public MemberDTO insertMember(MemberDTO dto) {
		String sql="insert into deliveryMember(id,password,name,email,address,userkind) values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());				
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getKind());
			pstmt.executeUpdate();
			System.out.println("입력완료");
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
		return dto;
	}
}
