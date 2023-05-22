package j10_메소드;

import java.util.Scanner;

public class MethodEx2 {
	/*
	 * 윤년 계산을 메소드를 이용해서 만들기
	 * year 1 , 2, 3 입력
	 * 
	 * calcLeapYear()
	 * year 1 = 윤년입니다.
	 * year 2 = 윤년이 아닙니다.
	 * year 3 = 윤년입니다.
	 */
//	static boolean calcLeapYear(int year) {
//		boolean result = false;
//		if(year % 4 == 0 || year % 100 != 0 && year % 400 == 0) {
//			 result = true;
//		}
//		return result;
//	}
	static boolean calcLeapYear(int year) {
		boolean result = false;
		if(year % 4 == 0 && year % 100 == 0 || year % 400 == 0) {
			result = true;
	}	
		
		return result;
}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year1 = 0;
		int year2 = 0;
		int year3 = 0;
		
		System.out.println("년도1 입력: ");
		year1 = scanner.nextInt();
		System.out.println("년도2 입력: ");
		year2 = scanner.nextInt();
		System.out.println("년도2 입력: ");
		year3 = scanner.nextInt();
		
		String result1 = calcLeapYear(year1) ? "윤년입니다." : "윤년이 아닙니다.";
		String result2 = calcLeapYear(year2) ? "윤년입니다." : "윤년이 아닙니다.";
		String result3 = calcLeapYear(year3) ? "윤년입니다." : "윤년이 아닙니다.";
		
		System.out.println("year1은 " + result1);
		System.out.println("year2은 " + result2);
		System.out.println("year3은 " + result3);
		
//		calcLeapYear(year1);
//		calcLeapYear(year2);
//		calcLeapYear(year3);
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("윤년1: ");
//		year = scanner.nextLine();
//		System.out.println("윤년2: ");
//		result = scanner.nextInt();
//		System.out.println("윤년3: ");
//		result = scanner.nextInt();
		
	}
}
