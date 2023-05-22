package j12_상속_다형성.추상.computer;

public class ComputerMain {

	public static void main(String[] args) {
		Computer c1 = new Laptop();
		Computer c2 = new DeskTopImpl();
		
		c1.onDisplay();
		c1.onKeyPress();
		c1.onSound();
		
		c2.onDisplay();
		c2.onKeyPress();
		c2.onSound();
		
		((Desktop) c2).onMouseClick();
	}

}
