package j17_컬렉션.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

import j15_스태틱.Student;

public class StudentArrayList {

	public static void main(String[] args) {
		Student student1 = new Student("조문기");
		Student student2 = new Student("김호영");
		Student student3 = new Student("서재효");
		Student student4 = new Student("신승한");
		Student student5 = new Student("전나경");
		
		/*
		 * studentList 
		 * 
		 */
		ArrayList<Student> studentList = new ArrayList<Student>();
		Student[] students = {student1, student2, student3, student4, student5};
		studentList.addAll(Arrays.asList(students));
//		for(int i = o; i < students.length; i++) {
//			studentList.add(students[i]);
//		}
		System.out.println(studentList);
		for(Student student : studentList) {
			System.out.println(student);
		}

		/*
		 * 학생 이름이 서재효인 객체를 찾아서
		 * 출력하고 삭제하기.
		 */
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getName().equals("서재효")) {
				System.out.println(studentList.get(i));
				studentList.remove(i);
			}
		}
		for(Student student : studentList) {
			if(student.getName().equals("전나경")) {
				System.out.println(student);
				studentList.remove(student);
				break;
			}
		}
	}

}
