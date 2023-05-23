package Java_정석_객체지향개념.ch07;

class MyPoint3 extends Object{
	int x;
	int y;
	
	MyPoint3(int x, int y){ 
		this.x = x;
		this.y = y;
	}
	
	//Object클래스의 toString()을 오버라이딩
	public String toString() {
		return "x:"+ x +", y: "+y;
	}
	
}

public class OverrideTest {

	public static void main(String[] args) {
		MyPoint3 p = new MyPoint3(1,2);//가독성이 밑에 코드보다 좋아졌다.
		System.out.println(p);
		
//		MyPoint3 p = new MyPoint3 
//		p.x = 3;
//		p.y = 5;
//		System.out.println("p.x=" + p.x);
//		System.out.println("p.y=" + p.y);
	}

}
