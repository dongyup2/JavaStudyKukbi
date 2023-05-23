package task;

import java.util.Arrays;
import java.util.Scanner;

import lombok.Data;
@Data
public class FibonacciNumbersArrays {
	private int[] fiboArray; // 배열을 하나만든다.
	
	public FibonacciNumbersArrays(int size) {
		fiboArray = new int[size];
		fiboArray[0] = 0;
		fiboArray[1] = 1;
		
	}
	public void calcFibonacciNumbersArrays(int end) {
		for(int i = 2; i < fiboArray.length; i++) {
			fiboArray[i] = fiboArray[i - 1] + fiboArray[i - 2]; //반복문 내에서 배열의 i번째 요소는
		}														// (i - 1)번째 요소와 (i - 2)번째 요소를 더한 값을 넣는다
	}
	@Override
	public String toString() {
		return Arrays.toString(fiboArray);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		
		FibonacciNumbersArrays fibonacciNumbersArrays = new FibonacciNumbersArrays(size);
		fibonacciNumbersArrays.calcFibonacciNumbersArrays(size);
		System.out.println(fibonacciNumbersArrays.toString());
		
	}
	
	

}
