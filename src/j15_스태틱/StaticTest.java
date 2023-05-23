package j15_스태틱;
		
public class StaticTest {
	
	public static String name; //스태틱은 무조건 public이다.
	private int age;
	
	public static void printTest() {
		System.out.println("출력");
		System.out.println(name);
	}
	
}
