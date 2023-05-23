package j16_제네릭;

import j14_lombok.Car;

public class GenericMain {

	public static void main(String[] args) {
		GenericTest<Integer, String> genericTest = new GenericTest<Integer, String>();
		GenericTest<String, Car> genericTest2 = new GenericTest<String, Car>();
		
		genericTest.setNumber(100);
		genericTest.setData("원");
		
		System.out.println(genericTest.getNumber() + genericTest.getData());
	}

}
