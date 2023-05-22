package j10_메소드;

public class MethodEx1 {
	static int sum(int x, int y) {
		return x + y;
	}
	
	static boolean oddOrEven(int num) { //이방법을 선호
		boolean result = false;
		if(num % 2 != 0) {
			result = true;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(sum(100,200));
		int num = sum(200,300);
		System.out.println(num);
		boolean tAndF = oddOrEven(10);
		
		System.out.println(tAndF);
	}
}
