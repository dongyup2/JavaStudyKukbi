package task.MallProgram;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import task.Cone;
@Getter
@Setter
public class MallDaoImpl implements MallDao {
	
	private ArrayList<MallDto> mallUserList;
	private Scanner scanner;
	
	public MallDaoImpl(){ // 생성자 호출시 객체 생성
		mallUserList = new ArrayList<MallDto>();
		scanner = new Scanner(System.in);
	}
	@Override
	public ArrayList<MallDto> addMalluser() { // 메소드 호출시 정보를 받고 builder로 데이터 저장
		String username = null;
		String password = null;
		String name = null;
		String email = null;

		System.out.println("회원가입을 완료해주세요.");
		System.out.println();
		System.out.println("아이디를 입력해주세요: ");
		username = scanner.nextLine();
		System.out.println("비밀번호를 입력해주세요: ");
		password = scanner.nextLine();
		System.out.println("이름을 입력해주세요: ");
		name = scanner.nextLine();
		System.out.println("이메일을 입력해주세요: ");
		email = scanner.nextLine();
		MallDto mall = MallDto.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.build();
		
		mallUserList.add(mall);
		
		System.out.println("회원가입이 완료되었습니다.");
		return mallUserList;
	}

	@Override
	public void printUser() { // 메소드 호출시 builder 로 받은 데이터 출력
		System.out.println(mallUserList);
		System.out.println();
		for (MallDto mall : mallUserList) { // builder로 저장한 mallUserList를 돌려서 출력한다.
			System.out.println("[가입한 아이디]");
			System.out.println("아이디: " + mall.getUsername());
			System.out.println("비밀번호: " + mall.getPassword());
			System.out.println("이름: " + mall.getName());
			System.out.println("이메일: " + mall.getEmail());
			
		}
	}

	@Override
	public void updateUser() {
	    System.out.println("수정할 아이디를 입력해주세요");
	    String username = scanner.nextLine();
	    for (int i = 0; i < mallUserList.size(); i++) {
	    	MallDto mall = mallUserList.get(i);
	        System.out.println(mallUserList.get(i));
	        if(mall.getUsername().equals(username)) {
	            System.out.println("수정하실 내용을 선택해주세요.");
	            System.out.println("1.아이디 | 2.비밀번호 | 3.이름 | 이메일");
	            String btn = scanner.nextLine();
	            switch(btn) {
	            case "1":
	                System.out.println("현재 아이디: " + mall.getUsername()); 
	                System.out.println("수정할 아이디를 입력해주세요:");
	                String newUsername = scanner.nextLine();
	                mall = mall.toBuilder()
	                          .username(newUsername)
	                          .build();
	                mallUserList.set(i, mall); // 수정된 객체를 리스트에 다시 저장
	                System.out.println("수정되었습니다.");
	                break;
	            case "2":
	                System.out.println("현재 비밀번호: " + mall.getPassword()); 
	                System.out.println("수정할 비밀번호를 입력해주세요:");
	                String newPassword = scanner.nextLine();
	                mall = mall.toBuilder()
	                          .password(newPassword)
	                          .build();
	                mallUserList.set(i, mall); // 수정된 객체를 리스트에 다시 저장
	                System.out.println("수정되었습니다.");
	                break;
	            case "3":
	                System.out.println("현재 이름: " + mall.getName()); 
	                System.out.println("수정할 이름을 입력해주세요:");
	                String newName = scanner.nextLine();
	                mall = mall.toBuilder()
	                          .name(newName)
	                          .build();
	                mallUserList.set(i, mall); // 수정된 객체를 리스트에 다시 저장
	                System.out.println("수정되었습니다.");
	                break;
	            case "4":
	                System.out.println("현재 이메일: " + mall.getEmail()); 
	                System.out.println("수정할 이메일를 입력해주세요:");
	                String newEmail = scanner.nextLine();
	                mall = mall.toBuilder()
	                          .email(newEmail)
	                          .build();
	                mallUserList.set(i, mall); // 수정된 객체를 리스트에 다시 저장
	                System.out.println("수정되었습니다.");
	                break;
	            default:
	                System.out.println("없는 메뉴입니다. 다시 시도해주세요.");
	        }
        }
    }
}
	@Override
	public void removeUser() { // builder로 받은데이터중 입력한 데이터가 일치할경우 삭제
		String username = null;
		String password = null;
		
		System.out.println("삭제할 아이디를 입력해주세요: ");
		username = scanner.nextLine();
		for(MallDto mall : mallUserList) {
			if(mall.getUsername().equals(username)) { // mall에 있는 username과 일치하면
				System.out.println("비밀번호를 입력해주세요: ");// 비밀번호 입력후
				password = scanner.nextLine();
			if(mall.getPassword().equals(password)) { // 비밀번호도 일치하면 삭제
				mallUserList.remove(mall);
				System.out.println(mall);
				System.out.println("삭제가 완료되었습니다.");
				return;
			}else {
				System.out.println("잘못된 비밀번호 입니다."); // 일치하지않으면 출력
				return;
			}
		}
	}
		System.out.println("존재하지않는 아이디입니다.");
	}
//	public boolean updateExceptionMethod(String updateInfo) {
//			if() {
//				System.err.println(updateInfo + ": 아이디는 존재하지않는 아이디입니다!");	
//				return false;
//		}
//	}
}
