package j12_상속_다형성2;

import lombok.Data;

@Data
public class MessengerMiddleWare {

	private Messenger messenger; // messenger 객체 생성
	
	public MessengerMiddleWare(Messenger messenger) { // MessengerMiddleWare 생성할때 Messenger 객체 생성
		this.messenger = messenger;
	}

	public void sendMessage() {// 인터페이스의 send 메소드
		messenger.send();
	}
	public void receiveMessage() {// 인터페이스의 receive 메소드
		messenger.receive();
	}
	public void messengerChoice() { // MessengerMiddleWare를 생성하고 들어오는 형에 따라 다른 메세지 출력
		MessengerMiddleWare messengerMiddleWare = new MessengerMiddleWare(messenger);
		messengerMiddleWare.sendMessage();
		System.out.println("메세지 전송 완료");
		System.out.println();
		
		messengerMiddleWare.receiveMessage();
		System.out.println("새로운 메세지를 받음.");
		System.out.println();
		messengerMiddleWare.runAddOns();
		System.out.println();
	}
	
	public void runAddOns() {
		System.out.println("추가기능 실행");
		if(messenger instanceof KakaoTalk) {
			KakaoTalk kakaoTalk = (KakaoTalk)messenger;
			kakaoTalk.sendPresent();
		}else if(messenger instanceof FaceBookMessenger) {
			FaceBookMessenger faceBookMessenger = (FaceBookMessenger)messenger;
			faceBookMessenger.call();
		}else {
			System.out.println("다운캐스팅 불가능");
		}
	}
}
