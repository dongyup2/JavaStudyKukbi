package task.BankingApp;

public class Toss implements BankingApp{

	@Override
	public void sendMoney() {
		System.out.println("토스로 입금합니다.");
	}

	@Override
	public void getMoney() {
		System.out.println("토스로 돈을 받습니다.");
	}

	@Override
	public void sendGift() {
		System.out.println("토스로 선물을 보냅니다.");
	}
	public void tossEvent() {
		System.out.println("토스 이벤트");
	}

	@Override
	public void getType(BankingApp bankingApp) {
		// TODO Auto-generated method stub
		
	}

}
