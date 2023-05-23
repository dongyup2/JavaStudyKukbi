package task.Car;

public class Bmw implements Car{

	@Override
	public void carBrand() {
		System.out.println("Bmw 브랜드 입니다.");
	}

	@Override
	public void carSpeedUp() {
		System.out.println("Bmw 의 속도가 올라갑니다");
	}

	@Override
	public void carSpeedDown() {
		System.out.println("Bmw 의 속도가 내려갑니다");
	}

	@Override
	public void carUnique() {
		System.out.println("Bmw의 고유기능 실행합니다");
	}

}
