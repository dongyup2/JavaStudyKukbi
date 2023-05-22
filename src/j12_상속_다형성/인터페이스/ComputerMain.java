package j12_상속_다형성.인터페이스;

import java.util.Scanner;

import j12_상속_다형성.인터페이스.USB.KeyBoard;
import j12_상속_다형성.인터페이스.USB.Mouse;

public class ComputerMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //스캐너 객체 필요해서 생성(입력해야해서)
		
		String select = null; //메뉴 뭘 선택했는지 저장하기 위해서
		ConnectionTerminal connectionTerminal = null; //?
		
		System.out.println("[컴퓨터 전원 관리");
		System.out.println("1. 모니터 연결");
		System.out.println("2. 빔프로젝트 연결");
		System.out.println("선택 >>");
		
		select = scanner.nextLine(); //내가 입력한 메뉴 번호 저장 select 변수에
		
		if(select.equals("1")) { // 조건에 따라 어떤 출력장치를 선택할 것 인지
			connectionTerminal = new Monitor();
			//모니터 객체 생성해서 connectionTerminal변수에 대입(업캐스팅이 됨)
		}else if(select.equals("2")) {
			connectionTerminal = new BeamProject();
		}else {
			System.out.println("메뉴를 잘 못 선택하셨습니다.");//1,2번이 아니면 출력
		}
		
		Computer computer = new Computer(connectionTerminal, new Mouse(), new KeyBoard());
		/*
		 * 
		 */
		computer.powerOn();
		for(int i = 0; i < 5; i++) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
		computer.powerOff();
	}

}
