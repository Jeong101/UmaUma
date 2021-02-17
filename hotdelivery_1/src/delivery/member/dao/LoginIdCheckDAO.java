package delivery.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import delivery.member.dto.MemberDTO;

import static delivery.member.db.DBManager.*;
public class LoginIdCheckDAO {
	ResultSet rs = null;
	Connection conn=null;
	PreparedStatement pstmt = null;
	public int idcheck(String id,String pwd) {
		int idCheck=0;	//0은 회원아님 1은 비밀번호 틀림 2는 로그인가능
		String sql="select id,password from deliveryMember where id=? and password=?";
		IDcheckDAO chkdao= new IDcheckDAO();
		idCheck=chkdao.idCheck(id);
		try {
			 conn=getConnection();
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, id);
			 pstmt.setString(2, pwd);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 
			 String checkId=rs.getString("id");
			 String checkPwd=rs.getString("password");
			 
			 if(idCheck==1) {
			 if(checkId.equals(id)&&checkPwd.equals(pwd)) {
				 idCheck=2;
			 }else {
				 idCheck=0;
			 }
			 }else {
				 idCheck=1;
			 }
			 }
			 
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn,pstmt,rs);
		}
		
		return idCheck;
	}
	
	public MemberDTO getInform(String id) {
		int idCheck=0;	//0은 회원아님 1은 비밀번호 틀림 2는 로그인가능
		String sql="select * from deliveryMember where id=?";
		MemberDTO dto = new MemberDTO();
		try {
			 conn=getConnection();
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, id);
			 
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 dto = new MemberDTO(rs.getString("id"),rs.getString("password"),
						 rs.getString("name"), rs.getString("email"),
						 rs.getString("address"),rs.getInt("money"),
						 rs.getString("userkind")
						 );
				 System.out.println("DAO 안 : "+dto.toString());
			 }
			 
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn,pstmt,rs);
		}
		
		return dto;
	}
}
