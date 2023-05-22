package j12_상속;

public class AnimalTest {

	public static void main(String[] args) {
		Human h = new Human();
		Tiger t = new Tiger();
		Animal animal = new Animal("동물");
		
		h.move();
		t.move();
		
		h.readBooks();
		t.hunting();
	}

}
