package task.BankingApp;

import j12_상속_다형성2.KakaoTalk;
import lombok.Data;

@Data
public class BankingAppMiddleWare {
	private BankingApp bankingApp;
	
	public BankingAppMiddleWare(BankingApp bankingApp) {
		this.bankingApp = bankingApp;
	}
	public void sendMoney() {
		bankingApp.sendMoney();
	}
	public void getMoney() {
		bankingApp.getMoney();
	}
	public void sendGift() {
		bankingApp.sendGift();
	}
	public void bankingChoice() {
		BankingAppMiddleWare bankingAppImpl = new BankingAppMiddleWare(bankingApp);
		bankingAppImpl.sendMoney();
		System.out.println("입금 완료");
		bankingAppImpl.getMoney();
		System.out.println("입금 확인 완료");
		bankingAppImpl.sendGift();
		System.out.println("선물 보내기가 완료되었습니다.");
		
		runBankApp();
	}
	public void runBankApp() {
		System.out.println("추가 기능을 실행합니다.");
		if(bankingApp instanceof Toss) {
			Toss toss = (Toss)bankingApp;
			((Toss)bankingApp).tossEvent();
//			toss.tossEvent();
		}else if(bankingApp instanceof KakaoPay) {
			KakaoPay kakaoPay = (KakaoPay)bankingApp;
			((KakaoPay) bankingApp).kakaoTalk();
//			kakaoPay.kakaoTalk();
		}
	}
}
