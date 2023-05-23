package Java_정석_객체지향개념.ch07����_��ü���ⰳ��.ch07;

public class Ex7_2 {
	public static void main(String[] args) {
		Child c = new Child();
		c.method();
	}
}
class Parent{
	int x = 10; // super.x
}
class Child extends Parent{
	int x = 20; // this.x
	
	void method() {
		System.out.println("x=" + x);
		System.out.println("this.x=" + this.x);
		System.out.println("super.x=" + super.x);
		}
	}

