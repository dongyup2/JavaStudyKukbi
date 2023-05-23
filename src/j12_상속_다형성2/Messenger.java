package j12_상속_다형성2;

public interface Messenger {
	
	//스태틱 상수를 가질 수 있다.
	
	//모든 메소드는 기본적으로 추상메소드이다.
	
	public void send(); //무조건 추상메소드가 된다. 일반 메소드처럼 쓰고싶으면 default 를 써야한다.
	public void receive();// 추상 생략
	void call(); // 일반 메소드
}
