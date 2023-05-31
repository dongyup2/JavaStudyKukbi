package task.CRUDmvc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import task.CRUDmvc.DBconnectionMrg.DBconnectionMrg;
import task.CRUDmvc.Dto.User;

public class UserDaoImpl implements UserDao {
	// DBConnectionMrg 인스턴스를 가리키는 pool 변수
	private DBconnectionMrg pool;

	// 데이터베이스 연결(Connection) 객체
	private Connection conn;

	// SQL 문을 실행하기 위한 PreparedStatement 객체
	private PreparedStatement pstmt;

	// SQL 쿼리를 저장하는 문자열 변수
	private String sql;

	// 결과를 저장하는 ResultSet 객체
	private ResultSet rs;

	public UserDaoImpl() {
		// DBconnectionMrg 인스턴스를 얻어서 pool 변수에 할당
		pool = DBconnectionMrg.getInstance();
	}
	
	@Override
	public int insertUser(User user) throws Exception {
		int result = 0;
		sql = "INSERT INTO\r\n"
				+ "	user\r\n"
				+ "VALUES(\r\n"
				+ "	0,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	?,\r\n"
				+ "	NOW()\r\n"
				+ ");";
		conn = pool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId());
			pstmt.setString(3, user.getPwd());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getAddress());
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public int selectUser() throws Exception {
		int result = 0;
		sql = "SELECT\r\n"
				+ "	*\r\n"
				+ "FROM\r\n"
				+ "	USER";
		conn = pool.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, );
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}

	@Override
	public void updateUser() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteUser() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
