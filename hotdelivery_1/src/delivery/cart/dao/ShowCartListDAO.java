package delivery.cart.dao;

import static delivery.member.db.DBManager.close;
import static delivery.member.db.DBManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import delivery.cart.dto.CartDTO;
import delivery.member.dto.MemberDTO;


public class ShowCartListDAO {
	public ArrayList<CartDTO> showList(MemberDTO dto){
		ArrayList<CartDTO> list = new ArrayList<CartDTO>();
		String sql="select * from cart where id=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		CartDTO cdto = null;
		String id = dto.getId();
		try {
		
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);			
									
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				cdto = new CartDTO(rs.getString("id"),rs.getString("foodName"),
						rs.getInt("quantity"),rs.getString("address"),rs.getInt("summoney"));
				list.add(cdto);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			close(conn, pstmt);
		}
		
		return list;
	}
}
