package Java_정석_객체지향개념.ch07;

class Mypoint extends Object{ //Object 클래스는 모든클래스의 조상
	int x;
	int y;
}
class Circle extends Object{ //상속
	Mypoint p;
	int r;
	public Circle() {
	p = new Mypoint();
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println(c.toString());
		System.out.println(c);
	}

}
