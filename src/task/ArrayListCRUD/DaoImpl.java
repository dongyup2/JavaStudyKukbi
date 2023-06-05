package task.ArrayListCRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class DaoImpl implements Dao{
	
	private ArrayList<User> userList;
	private Scanner scanner;
	
	public DaoImpl() {
		userList = new ArrayList<User>();
		scanner = new Scanner(System.in);
	}
	
	@Override
	public void insertUser() {
		System.out.println("회원가입을 완료해주세요");
		System.out.println("아이디를 입력해주세요: ");
		String id = scanner.nextLine();
		System.out.println("비밀번호를 입력해주세요: ");
		String pwd = scanner.nextLine();
		System.out.println("이름을 입력해주세요: ");
		String name = scanner.nextLine();
		System.out.println("이메일을 입력해주세요: ");
		String email = scanner.nextLine();
		
		User user = User.builder()
				.id(id)
				.pwd(pwd)
				.name(name)
				.email(email)
				.build();
		userList.add(user);
	}

	@Override
	public void selectUser() {
		
		System.out.println("조회된 회원 목록입니다!");
		for(User user : userList) {
			System.out.println("아이디: " + user.getId());
			System.out.println("비밀번호: " + user.getPwd());
			System.out.println("이름: " + user.getName());
			System.out.println("이메일: " + user.getEmail());
		}
		System.out.println();
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		System.out.println("삭제하실 아이디를 입력해주세요!");
		String id = scanner.nextLine();
		for(User user : userList) {
			if(id.equals(user.getId())) {
				System.out.println("비밀번호를 입력해주세요 !");
				String pwd = scanner.nextLine();
				if(pwd.equals(user.getPwd())) {
					System.out.println("");
				}
			}
		}
	}

}
