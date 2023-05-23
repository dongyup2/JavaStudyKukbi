package j13_최상위클래스;

public class ToStringMain {

	public static void main(String[] args) {
		
		int num = 4000;
		
		System.out.println(num);
		
		ToString ts = new ToString(100, 200);
		
		System.out.println("totring 메소드로 호출");
		System.out.println(ts.toString());
		
		System.out.println("toString 메소드 생략"); //toString 을 이용하면 값처럼 사용할수있다
		System.out.println(ts);
	}

}
