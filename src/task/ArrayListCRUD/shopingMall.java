package task.ArrayListCRUD;

import java.util.Scanner;

public class shopingMall {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DaoImpl daoImpl = new DaoImpl();
		
		while(true) {
		System.out.println("-----[쇼핑몰 관리 프로그램]-----");
		System.out.println("1번 회원가입\t| 2번 회원조회 \t| 3번 회원수정 \t| 4번 회원삭제 \tq.나가기");
		String btn = scanner.nextLine();
			if(btn.equals("1")) {
				daoImpl.insertUser();
			}else if(btn.equals("2")) {
				daoImpl.selectUser();
			}else if(btn.equals("3")) {
				daoImpl.updateUser();
			}else if(btn.equals("4")) {
				daoImpl.deleteUser();
			}else if(btn.equals("q")) {
				for(int i = 0; i < 10; i++) {
					System.out.println(i + 1 + "/10");
				try {					
					Thread.sleep(100);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}	
				System.out.println("종료되었습니다.");
				return;
			}else {
				System.err.println("경고!!없는 명령어입니다!");
		}
	}			
}
}