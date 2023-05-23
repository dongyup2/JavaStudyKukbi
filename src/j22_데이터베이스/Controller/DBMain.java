package j22_데이터베이스.Controller;

import j22_데이터베이스.dao.UserDao;
import j22_데이터베이스.jdbc.DBConnectionMgr;

public class DBMain {
	public static void main(String[] args) {
		UserDao userDao = new UserDao(DBConnectionMgr.getInstance());
		
		userDao.getUserMstAll();
	}
}
