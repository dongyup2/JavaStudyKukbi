package j07_입력;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		/*
		 * 이름(name): 이동엽
		 * 연락처(phone): 010-7464-0339
		 * 직업(job): 학생
		 * 성별(gender): 남
		 * 나이(age): 23
		 * 주소(address): 부산광역시 해운대구 반여동
		 * 
		 * 
		 * 고객의 이름은 이동엽이고 직업은 학생입니다.
		 * 나이는 23이며 성별은 남성입니다.
		 * 연락처: 010-7464-0339
		 * 주소: 부산광역시 해운대구 반여동
		 */
		Scanner scanner = new Scanner(System.in);
		
		String name = null;
		String phone = null;
		String job = null;
		String gender = null;
		int age = 0;
		String address = null;
		String email = null;
		
		
		
//		System.out.print("이름: ");
//		name = scanner.next();
//		System.out.print("연락처: ");
//		phone = scanner.next();
//		System.out.print("직업: ");
//		job = scanner.next();
//		System.out.print("성별: ");
//		gender = scanner.next();
		System.out.print("나이: ");
		age = Integer.parseInt(scanner.next());
//		scanner.nextLine();
//		System.out.print("주소: ");
//		address = scanner.nextLine();
//		System.out.print("이메일: ");
//		email = scanner.next();
		
		System.out.println("고객의 이름은" + name + "이고 직업은 " + job + "입니다.");
		System.out.println("나이는" + Integer.toString(age + 1) + "이며 성별은 " + gender + "성입니다. ");
		System.out.println("연락처: " + phone);
		System.out.println("주소: " + address);
		System.out.println("이메일(email): " + email);
		
	}

}
