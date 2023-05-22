package j11_클래스_생성자;

public class Car_J11 {
	
	 String company;
	 String model;
	 String color;
		
	 Car_J11(){ // 기본생성자 (no argument constructor)
		System.out.println("생성자 호출?");
	 }//리턴값이 주소다
	 
	 Car_J11(int num, int num2){//사용자 지정 생성자(argument constructor) 
		 System.out.println(num + num2);
	 }
	 
	Car_J11(String company, String model, String color){ //전체생성자(all argument constructor)
		this.company = company;
		this.model = model;
		this.color = color;
		System.out.println(this);
	}
}
