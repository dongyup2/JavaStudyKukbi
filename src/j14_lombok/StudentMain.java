package j14_lombok;

public class StudentMain {

	public static void main(String[] args) {
		Student student = new Student(); //생성자
		Student student2 = new Student(20220001, "이동엽", 2, 29); //전체생성자 가능
		
		System.out.println(student2);
	}

}
