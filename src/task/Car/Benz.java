package task.Car;

public class Benz implements Car {

	@Override
	public void carBrand() {
		System.out.println("Benz 브랜드입니다");
	}

	@Override
	public void carSpeedUp() {
		System.out.println("Benz의 속도가 올라갑니다.");
		
	}

	@Override
	public void carSpeedDown() {
		System.out.println("Benz의 속도가 내려갑니다.");
	}

	@Override
	public void carUnique() {
		System.out.println("Benz의 고유기능을 실행합니다.");
		
	}

}
