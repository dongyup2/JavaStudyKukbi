package j12_상속_다형성;

import j12_상속.Animal;
import j12_상속.Human;
import j12_상속.Tiger;

public class AnimalTest {

	public static void main(String[] args) {
		Human human = new Human(); // human 생성자
		Animal animal = human; //업캐스팅을 하면 자식만 가지고 있는 readBooks 메소드는 사용할수없다.
		human.readBooks();
		animal.move();
		Human human2 = (Human)animal;
		human2.readBooks();
		
		/////////////////////////////////////////////
		
		Animal[] animals = new Animal[4];//동물 3마리를 만들수있는 공간을 만들었을 뿐이다. 객체생성x 
		
		animals[0] = new Human();
		animals[1] = new Tiger();
		animals[2] = new Tiger();
		animals[3] = new Animal();
		
		for(int i = 0; i < animals.length; i++) { //instanceof
			System.out.println(animals[i]);
			animals[i].move();
			if(animals[i] instanceof Human) {
				Human h = (Human)animals[i];
				h.readBooks();
				//((Human)animals[i])).readBooks();				
			}else if(animals[i] instanceof Tiger) {
				((Tiger)animals[i]).hunting();
			}else {
				System.out.println("다운캐스팅 할 수 없습니다.");
			}
		}
	}

}
