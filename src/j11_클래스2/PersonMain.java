package j11_클래스2;

public class PersonMain {

	public static void main(String[] args) {
		String[] names = {"이동엽", "박진우", "정찬"};
		int[] ages = {23, 22, 24};
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(i + 1 + "번 사람(이름): " + names[i]);
			System.out.println(i + 1 + "번 사람(나이): " + ages[i]);
		}
		 
//		Person person1 = new Person("이동엽",23);
//			
//		//메모리 주소 값을 변수에 담는다.(생성자)
//		
//		person1.setName("이동엽");
//		System.out.println(person1.getName());
		
		String name1 = "이동엽";
		String name2 = "박진우";
		String name3 = "정찬";
		int age1 = 23;
		int age2 = 22;
		int age3 = 24;
		
		System.out.println("1번 사람(이름): " + name1);
		System.out.println("2번 사람(이름): " + name2);
		
		
		
		
	}

}
