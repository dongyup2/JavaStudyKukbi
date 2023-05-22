package j09_반복;

import java.util.Scanner;

public class ForEx3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//int dan = 0;
		int dan_start = 0;
		int dan_end = 0;
		
		int start = 0;
		int end = 0;
		
		//System.out.println("단 수를 입력하세요: ");
		//dan = scanner.nextInt();
		System.out.println("시작 지점을 입력하세요: ");
		start = scanner.nextInt();
		System.out.println("마지막 지점을 입력하세요: ");
		end = scanner.nextInt();
		
		for(int dan = 0; dan < 8; dan++) {
			dan += 2;
			System.out.println(dan + "단");
			for(int i = 0; i < 9; i++) {
				int result = dan * (i + 1);
				System.out.println(dan + " x " + i + " = " + result);
				i -= 1;
			}
			System.out.println();
			dan -= 2;
		}
		
//		for(int i = 0; i < end; i++) {
//			int result = dan * (i + 1);
//			System.out.println(dan + " X " + (i + 1) + " = " + result);
//		}
	}

}
