package task.MallProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;
import lombok.Getter;


public class MallTest  { 
	
	public static void main(String[] args) {
		MallDaoImpl mallDaoImpl = new MallDaoImpl();
		mallDaoImpl.getScanner();
		String select = null;
		
		while(true) {
		System.out.println("[쇼핑몰 관리 프로그램]");
		System.out.println("1. 회원가입 | 2. 유저 리스트 조회 | 3. 유저 삭제 | 4. 유저 수정 | q. 프로그램 종료");
		System.out.println(".　　　､ゞヾ∧\"\"'∧;,\r\n"
				+ "　　ヾ　　　・ω・ 彡\r\n"
				+ "　 ﾐ　　　　o　 o　 ミ\r\n"
				+ "　~彡　　　　　　　 ﾐ\r\n"
				+ "　　/ｿ,,　,０; ,;;:､０ヾ`\r\n"
				+ "");
		
		select = mallDaoImpl.getScanner().nextLine();
		switch(select) {
	    case "1":
	        mallDaoImpl.addMalluser();// Create
	        break;
	    case "2":
	        mallDaoImpl.printUser();// Read
	        break;
	    case "3":
	        mallDaoImpl.removeUser();// Delete
	        break;
	    case "4":
	        mallDaoImpl.updateUser();// Update
	        break;
	    case "q":
	        System.out.println("프로그램을 종료합니다.");
	        for(int i = 0; i < 10; i++) {
	            System.out.println(i + 1 +"/10");
	            try {
	                Thread.sleep(100);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("종료되었습니다.");
	        return;
	    default:
	        System.out.println("존재하지 않는 명령어입니다.");
			}	
		}
	}
}