package task.BankingApp;

import java.util.Scanner;

public class BankingAppTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		KakaoPay kakaoPay = new KakaoPay();
		Toss toss = new Toss();
		
		while(true) {
			System.out.println("---은행어플 관리 프로그램---");
			System.out.println("1. 토스");
			System.out.println("2. 카카오페이");
			String btn = scanner.nextLine();
			if(btn.equals("1")) {
				BankingApp bankingApp = (BankingApp)toss; // toss 를 부모인 BankingApp으로 업캐스팅을한다.
				BankingAppMiddleWare middleWare = new BankingAppMiddleWare(toss);
				middleWare.bankingChoice();		
			}else if(btn.equals("2")) {
				BankingApp bankingApp = (BankingApp)kakaoPay;
				BankingAppMiddleWare middleWare = new BankingAppMiddleWare(kakaoPay);
				middleWare.bankingChoice();
			}else {
				System.out.println("없는 메뉴입니다. 다시시도해주세요.");
			}
		}
	}

}
