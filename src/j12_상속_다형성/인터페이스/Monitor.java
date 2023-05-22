package j12_상속_다형성.인터페이스;

public class Monitor implements HDMI {
	Monitor(){
		
	}
	@Override
	public void Connect() {
		System.out.println("HDMI를 통해 모니터를 연결합니다.");
	}

	@Override
	public void disConnect() {
		System.out.println("HDMI를 연결된 모니터 연결을 해제합니다.");
		
	}

	@Override
	public void soundOutput() {
		System.out.println("HDMI를 통해 소리 출력");
	}
	
}
