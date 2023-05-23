package task.MallProgram;

import java.util.ArrayList;

public interface MallDao {
	public ArrayList<MallDto> addMalluser();
	public void printUser();
	public void updateUser();
	public void removeUser();
}
