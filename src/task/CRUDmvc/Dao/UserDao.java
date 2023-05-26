package task.CRUDmvc.Dao;

import task.CRUDmvc.Dto.User;

public interface UserDao {
	public int insertUser(User user) throws Exception;
	public int selectUser() throws Exception;
	public void updateUser() throws Exception;
	public int deleteUser() throws Exception;
}
