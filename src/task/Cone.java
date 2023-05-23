package task;

import java.util.Scanner;

public class Cone {

	public static void main(String[] args){
		int[] x = new int[5];
		int[] y = new int[5];
		for(int i = 0; i < 5; i++){
			x[i] = i + 1;
			y[4-i] = x[i];
			System.out.println(x[i]);
		}
	}
}