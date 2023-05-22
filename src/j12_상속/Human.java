package j12_상속;

public class Human extends Animal{
	
	public Human() {
		super("부모생성?");
		System.out.println("자식 객체 생성");
	}
	
	@Override //메소드 재정의
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}
	
	public void readBooks() {
		System.out.println("사람이 책을 읽습니다.");
	}
}
