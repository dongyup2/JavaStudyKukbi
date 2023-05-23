package j17_컬렉션.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Getter;

@Getter
public class UserArrayList2 {
	private List<User> userList;
	private Scanner scanner;
	
	public UserArrayList2() {
		userList = new ArrayList<User>();
		scanner = new Scanner(System.in);
	}
	public void addUser(){ //사용자 추가 메소드
		String username = null;
		String password = null;
		String name = null;
		String email = null;
		
		System.out.println("아이디: ");
		username = scanner.nextLine();
		System.out.println("비밀번호");
		password = scanner.nextLine();
		System.out.println("이름: ");
		name = scanner.nextLine();
		System.out.println("이메일: ");
		email = scanner.nextLine();
		
		User user = User.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.build();
		
		userList.add(user);
		
	}
	public void printUser() {
		System.out.println(userList);
		
		for(User user : userList) {
			System.out.println("아이디: " + user.getUsername());
			System.out.println("비밀번호: " + user.getPassword());
			System.out.println("이름: " + user.getName());
			System.out.println("이메일: " + user.getEmail());
		}
	}
	public void removeUser() {
		String username = null;
		String password =null;
		
		System.out.println("아이디: ");
		username = scanner.nextLine();
		for(User user : userList) {
			if(user.getUsername().equals(username)) {
				System.out.println("비밀번호: ");
				password = scanner.nextLine();
				if(user.getPassword().equals(password)) {
					userList.remove(user);
					System.out.println("삭제 완료");
					return;
				}
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
				return;
			}
		}
	}
	public static void main(String[]args) {
		UserArrayList2 userArrayList2 = new UserArrayList2();
		userArrayList2.getScanner();
		
		while(true) {
			String select = null;
			
			System.out.println("[사용자 추가 프로그램]");
			System.out.println("1.사용자 추가");
			System.out.println("2.사용자 리스트 조회");
			System.out.println("3.사용자 삭제");
			System.out.println("q.프로그램 종료");
			select = userArrayList2.getScanner().nextLine();
			
			if(select.equals("1")){
				userArrayList2.addUser();
			}else if(select.equals("2")){
				userArrayList2.printUser();
			}else if(select.equals("3")) {
				userArrayList2.removeUser();
			}else if(select.equals("q")){
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("실행할 수 없는 명령어입니다.");
			}
		}
		
	}
}	

