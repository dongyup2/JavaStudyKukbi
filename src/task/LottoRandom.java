package task;

public class LottoRandom {

	public static void main(String[] args) {
		int[] ball = new int[45];
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i + 1; //ball[i] 에는 1이 저장된다.
			System.out.println(ball[i]);
		}
		
		int j = 0;
		System.out.println();
		for(int i = 0; i < 6; i++) {
			j = (int)(Math.random() * 45);
			if(j == j) {
				
			}
			System.out.println("번호"+ (i + 1) + "번: " + ball[j]);
		}
	}	

}
