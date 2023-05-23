package task.Car;

public interface Car<T> {
	public void carBrand();
	public void carSpeedUp();
	public void carSpeedDown();
	default void carUnique() {
	
	}
}
