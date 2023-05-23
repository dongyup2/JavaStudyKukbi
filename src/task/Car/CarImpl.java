package task.Car;

import lombok.Data;

@Data
public class CarImpl {
	private Car car;
	
	public CarImpl(Car car) {
		this.car = car;
	}
	public void getCarBrand() {
		car.carBrand();
	}
	public void getCarSpeedUp() {
		car.carSpeedUp();
	}
	public void getCarSpeedDown() {
		car.carSpeedDown();
	}
	public void getCarUnique() {
		car.carUnique();
	}
	
}
