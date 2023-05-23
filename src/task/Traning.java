package task;

import java.util.Arrays;

public class Traning {

	public static void main(String[] args) {
		// 콘솔창에 50,60,70,80,90
//		int num1 = 50;
//		for(int i=0; i<5; i++){
//			System.out.println(num1 + i*10);					  	
//		}
		// 1.배열에 1 ~ 10까지 값을 할당합니다.
		// 2. [3,4,6,7,8,9]값이 출력되어야 합니다.
		// 3. 초기값, 조건식을 제외한 코드는 수정하지 않습니다.
//		int[] num = new int[10];
//		for(int i = 3; i<10; i++){
//	       if(i == 5) {
//	    	   continue;
//	       }
//	       	num[i]=i;
//       		System.out.print(num[i]);
//		}
//	}					
		// 1. [1,2,3,4,5,9,10,11,12]값이 출력되어야 합니다.
		// 2. 재할당,조건식을 제외한 코드는 수정하지 않습니다.

//			int[] nums = new int[10];
//				for (int i = 1; i < 10; i++) {
//					nums[i] = i; // 1씩 증가한 i를 num[i] 에 담는다
//					if (i > 5) {
//						nums[i] = i + 3;
//					}	
//					System.out.println(nums[i]);
//				}

		// for문 안에 새로운 코드를 추가하여 아래 표기된 값과 동일한 결과를 출력하십시오.
		// 1 2 3
		// 4 5 6
		// 7 8 9
//		 for (int i = 1; i < 10; i++) {
//			 System.out.print(i + " ");
//			 if(i % 3 == 0) {
//				 System.out.println();
//				}
//			 }
//	
		// 2차원 배열입니다. nums[i][j] = j+1에 연산을 추가하여 위의 문제와 동일한 출력을 하십시오.
		int[][] nums = new int[3][3];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				nums[i][j] = j + 1;
				System.out.print(nums[i][j] + " ");

			}
			System.out.println();
		}

		// 위 문제를 활용해 아래와 같이 출력하십시오.
		// 0 2 3
		// 4 0 6
		// 7 8 0

		// 위 문제를 활용해 아래와 같이 출력하십시오.
		// 1 2 0
		// 4 0 6
		// 0 8 9
		// 조건과 값을 바꿔 nums[i]를 출력했을 때
		// 7 0 32 71 23 0 0 13 이 출력되게 만드세요.
//			int[] nums1 = {7, 21, 32, 71, 23, 33, 9, 13};
//			for (int i = 0; i < nums1.length; i++) {
//				if(nums1[i] % 3 == 0) {
//					nums1[i] = 0;
//				}
//				System.out.print(nums1[i] + " ");
//			}
		// 2중for문을 사용하여 아래와 같이 출력하십시오.

		// *****
		// ****
		// ***
		// **
		// *
		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		// *
		// **
		// ***
		// ****
		// *****
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		// *
		// ***
		// *****
		// *******
		// *********
		int sum = 0;
		for (sum = 0; sum < 5; sum++) {
			for (int j = sum; j < 4; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void delete() {
	int jumin = 0;
	System.out.println("삭제할 주민등록번호를 입력하세요 :");
	searchJu = sc.next();

	for (int i = 0; i < index; i++) {
		if (jumin[i].equals(searchJu)) {
			System.out.println("이름 : " + name[i] + " 주민번호 : " + jumin[i] + " 주소 : " + addr[i]);

			System.out.println();

			for (int j = i; j <= index; j++) {

				jumin[j] = jumin[j + 1];
				name[j] = name[j + 1];
				addr[j] = addr[j + 1];		
			}
		}
	}		
}
}
