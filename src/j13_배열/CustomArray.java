package j13_배열;

import java.util.Scanner;

import lombok.Data;
@Data
public class CustomArray {
	private String[] strArray; //이름을 만들수있는 배열
	
	public CustomArray() {
 		strArray = new String[0];
	}
	
	public void strArraySizeUp() { //add가 호출될때마다 늘리는 작업을한다
		String[] tempstrArray = new String[strArray.length + 1]; 
		for(int i = 0; i < strArray.length; i++) {
			tempstrArray[i] = strArray[i];
		}
		strArray = tempstrArray; // 배열의 크기를 늘리면서 옮겨준다
	}
	
	public void add(String str) {
		strArraySizeUp();
		strArray[strArray.length - 1] = str;
	}
	
	public String[] getStrArray() {
		return strArray;
	}
	
}
