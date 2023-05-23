package j13_최상위클래스;

public class StringEquals {

	public static void main(String[] args) {
		String name1 = "이동엽";
		String name2 = "이동엽";
		String name3 = new String("이동엽");
		String name4 = name3;
		
		System.out.println("name1: " + name1);
		System.out.println("name2: " + name2);
		System.out.println("name3: " + name3);
		System.out.println("name3: " + name4);
		
		System.out.println();
		
		System.out.println("name1 == name2: " + (name1 == name2)); //t
		System.out.println("name1 == name3: " + (name1 == name3)); //f
		System.out.println("name1 == name4: " + (name3 == name4)); //t
		
		System.out.println("name1.equals(name2) :" + name1.equals(name2)); //equals는 값비교는 아니지만
		System.out.println("name1.equals(name3) :" + name1.equals(name3));
		System.out.println("name3.equals(name4) :" + name3.equals(name4));
	}

}
