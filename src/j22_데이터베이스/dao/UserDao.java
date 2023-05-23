package j22_데이터베이스.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import j22_데이터베이스.dto.UserMst;
import j22_데이터베이스.jdbc.DBConnectionMgr;
import lombok.RequiredArgsConstructor;
	
@RequiredArgsConstructor
public class UserDao {
	private final DBConnectionMgr pool;
	
	public ArrayList<UserMst> getUserMstAll(){
		//DB에서 쓰일 4가지 필수
		String sql = null; // 쿼리문 넣음
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ArrayList<UserMst> userMstList = new ArrayList<UserMst>();
		
		try {
			con = pool.getConnection();
			sql = "SELECT\r\n"
					+ "	*study\r\n"
					+ "FROM\r\n"
					+ "	user_mst;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 쿼리 실행
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));// 2번컬럼 이메일
				System.out.println(rs.getString(3));// 3번컬럼 
				System.out.println(rs.getString(4));// 4번컬럼
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return userMstList;
	}

}
