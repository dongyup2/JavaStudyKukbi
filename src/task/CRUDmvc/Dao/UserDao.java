package task.CRUDmvc.Dao;

public interface UserDao {
	public int insertUser() throws Exception;
	public int selectUser() throws Exception;
	public void updateUser() throws Exception;
	public int deleteUser() throws Exception;
}
