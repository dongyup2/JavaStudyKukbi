package j12_상속_다형성2;

import java.util.Scanner;

public class MessengerMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		KakaoTalk kakaoTalk = new KakaoTalk();
		FaceBookMessenger faceBookMessenger = new FaceBookMessenger();
//		MessengerMiddleWare messengerMiddleWare = null;
		while(true) {
			System.out.println("---보내실 메신저를 선택해주세요---");
			System.out.println("1.카카오톡");
			System.out.println("2.페이스북 메신저");
			String btn = scanner.nextLine();
			if(btn.equals("1")) {
				Messenger messenger = (Messenger)kakaoTalk;
				MessengerMiddleWare messengerMiddleWare = new MessengerMiddleWare(messenger);
				messengerMiddleWare.messengerChoice();
			}else if(btn.equals("2")) {
				Messenger messenger = (Messenger)faceBookMessenger;	
				MessengerMiddleWare messengerMiddleWare = new MessengerMiddleWare(messenger);
				messengerMiddleWare.messengerChoice();
			}
			
		
		}
	}
}
