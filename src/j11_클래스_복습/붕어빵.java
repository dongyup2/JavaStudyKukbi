package j11_클래스_복습;

public class 붕어빵 {
	private String 재료;
	private String 모양;
	
	//기본생성자
	public 붕어빵() {
		
	}
	//전체생성자
	public 붕어빵(String 모양, String 재료) {
		this.재료 = 재료;
		this.모양 = 재료;
	}
	//getter
	public String get모양() {
		return 모양;
	}
	public String get재료() {
		return 재료;
	}
	//setter
	public void set재료(String 재료) {
		this.재료 = 재료;
	}
	public void set모양(String 모양) {
		this.모양 = 모양;
	}
	//showInfo()
	// 000모양의 000맛 붕어빵입니다.
	public void showInfo() {
		System.out.println(모양 + "모양의" + 재료 + "맛 붕어빵입니다.");
	}
	
}
