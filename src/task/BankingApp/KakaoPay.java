package task.BankingApp;

import j11_클래스_복습.B;

public class KakaoPay implements BankingApp {

	@Override
	public void sendMoney() {
		System.out.println("카카오페이로 입금합니다.");
	}

	@Override
	public void getMoney() {
		System.out.println("카카오페이로 돈을 받습니다.");
	}

	@Override
	public void sendGift() {
		System.out.println("카카오 기프티콘을 보냅니다.");
	}
	
	public void kakaoTalk() {
		System.out.println("카카오톡 기능을 이용합니다.");
	}

	@Override
	public void getType(BankingApp bankingApp) {
		
	}
}
