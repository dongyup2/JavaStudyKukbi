package task;

import java.util.ArrayList; 
import java.util.Scanner;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BankTest{
	private ArrayList<Bank> bankUserList; 
	private Scanner scanner;
	
	public BankTest(){
		bankUserList = new ArrayList<Bank>();
		scanner = new Scanner(System.in);
	}
	
		//회원가입 기능
		public void addUser() {
			String name = null;
			String username = null;
			String password = null;
			String email = null;
			
			System.out.print("아이디를 입력하세요: ");
			username = scanner.nextLine();
			System.out.print("비밀번호를 입력하세요: ");
			password = scanner.nextLine();
			System.out.println("이름을 입력하세요: ");
			name = scanner.nextLine();
			System.out.println("이메일을 입력하세요: ");
			email = scanner.nextLine();
			
			Bank bank = Bank.builder()
					.username(username)
					.password(password)
					.name(name)
					.email(email)
					.build();
			
			bankUserList.add(bank);
			System.out.println("회원가입이 완료되었습니다.");
		}	
			//유저를 삭제하는 메소드
		public void removeUser() {
			String username = null;
			String password = null;
			
			System.out.println("아이디를 입력하세요.");
			username = getScanner().next();	
			for(Bank bank : bankUserList) {
				if(bank.getUsername().equals(username)) {
					System.out.println("비밀번호를 입력하세요: ");
					password = getScanner().next();
					if(bank.getPassword().equals(password)) {
						bankUserList.remove(bank);
						System.out.println(bank);
						return;
					}else {
						System.out.println("잘못된 아이디 및 비밀번호입니다.");
						return;
					}
				}
			}
			
		}
			//정보 조회 및 출력하는 메소드
			public void printUser() {
				String print = null;
				for(Bank bank : bankUserList) {
					System.out.println("아이디: " + bank.getUsername());
					System.out.println("비밀번호: " + bank.getPassword());
					System.out.println("아이디: " + bank.getName());
					System.out.println("아이디: " + bank.getEmail());				
				}
				System.out.println(bankUserList);
		}

		public void guest() {
			
		}
	public static void main(String[] args) {
		BankTest bankTest = new BankTest();
		String select = null;
		bankTest.getScanner();
		
		while(true) {
			System.out.println("[은행 관리 프로그램]");
			System.out.println("[관리자]메뉴를 선택해주세요.");
			System.out.println("1. 회원가입");
			System.out.println("2. 사용자 정보 조회");
			System.out.println("3. 사용자 삭제");
			System.out.println("4. 고객용으로 가기");
			System.out.println("q. 나가기.");
			System.out.print("선택해주세요: ");
			
			select = bankTest.getScanner().nextLine();
			
			if(select.equals("1")) {
				bankTest.addUser();
			}else if(select.equals("2")) {
				bankTest.printUser();
			}else if(select.equals("3")){
				bankTest.removeUser();
			}else if(select.equals("4")) {
//				bank.
			}else if(select.equals("q")) {
				System.out.println("프로그램을 종료합니다.");
			}else {
				System.out.println("이용 할수 없는 명령어 입니다.");
			}
		}
	}
}



