package j13_배열;

import java.util.Scanner;

import lombok.Data;

public class UserArray { // 사용자를 추가하기위한 클래스
	private CustomArray customArray;

	int cnt = 0;

	public UserArray(CustomArray customArray) {
		this.customArray = customArray;
	}

	public void insertName(Scanner scanner) { // 사용자 추가
		System.out.println("[이름 추가]");
		System.out.println("이름을 입력하세요: ");
		addName(scanner.nextLine());
	}

	public void selectNameAll() {// 사용자 전체 정보 조회
		String[] strArray = customArray.getStrArray();
		System.out.println("[이름 전체 조회]");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println((i + 1) + "번: " + strArray[i]);
		}
		System.out.println();
	}

	public void selectNameAll2() {

	}

	public void deleteName(Scanner scanner) { // 삭제 메소드
		System.out.println("삭제하실 이름을 적어주세요>>");
		String str = scanner.nextLine();
		String[] strArray = customArray.getStrArray();
		for (int i = 0; i < customArray.getStrArray().length; i++) {
			if (strArray[i].equals(str)) {
				for (int j = i; j < customArray.getStrArray().length - 1; j++) {
					strArray[j] = strArray[j + 1];
				}
				System.out.println("삭제 되었습니다.");
				cnt++;
			}
		}
	}

	public void deleteName2(Scanner scanner) {
		String[] newstrArray = new String[customArray.getStrArray().length - 1];
		String[] strArray = customArray.getStrArray();
		System.out.println("삭제하실 이름을 적어주세요>>");
		String str = scanner.nextLine();
		int index = 0;

		for (int i = 0; i < customArray.getStrArray().length; i++) { // for문을 돌려서 삭제할 인덱스가 있는 배열의 위치를 찾는다.
			if (strArray[i].equals(str)) {
				index = i; // 찾은 strArray[i] 의 위치를 index에 대입한다.
			}
		}
		for (int i = 0; i < index; i++) { // 삭제하는 인덱스 전까지 반복
			newstrArray[i] = strArray[i];
		}

		for (int i = index + 1; i < customArray.getStrArray().length; i++) {// 6
			newstrArray[i - 1] = strArray[i];
		}
		customArray.setStrArray(newstrArray);
	}

	public void deleteName3(Scanner scanner) {
		String[] tempArray = customArray.getStrArray(); // customArray 에서 가져온 데이터를 tempArray에 저장
		int newSize = 0; // 카운트 변수생성
		for (int i = 0; i < tempArray.length; i++) {
			if (!tempArray[i].equals(scanner)) {
				newSize++;
			}
		}
		String[] newtempArray = new String[newSize];// tempArray를 다시 순회하여 Scanner 객체와 일치하지 않은 문자열을 newtempArray에 저장
		//9개
		newSize = 0;
		for (int i = 0; i < newtempArray.length; i++) {//9
			if (!tempArray[i].equals(scanner)) { 
				newtempArray[newSize++] = tempArray[i];
			}
		}
		customArray.setStrArray(newtempArray);
	}

	public void updateName(Scanner scanner) {
		String[] tempArray = customArray.getStrArray();
		System.out.println("수정하실 이름을 입력해주세요.");
		String Name = scanner.nextLine();
		for(int i = 0; i < tempArray.length; i++) {
			if(tempArray[i].equals(Name)) {
				System.out.println("수정할 이름을 입력해주세요: ");
				String newName = scanner.nextLine();
				tempArray[i] = newName;
			}
		}
		customArray.setStrArray(tempArray);
	}
	private void addName(String name) {
		customArray.add(name);
		System.out.println("추가된 이름: ");
		System.out.println(getNameByLatestAddName());
		System.out.println();
	}

	private String getNameByLatestAddName() { // 최근에 추가한 정보를 보여줘
		String[] strArray = customArray.getStrArray();
		return strArray[strArray.length - 1];
	}
}
