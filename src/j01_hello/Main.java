package j01_hello;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 격자점의 개수 N 입력받기

        int[] x = new int[N]; // x좌표를 저장할 배열
        int[] y = new int[N]; // y좌표를 저장할 배열
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt(); // x좌표 입력받기
            y[i] = sc.nextInt(); // y좌표 입력받기
        }

        int evenDist = Integer.MAX_VALUE; // 짝수 거리 중 최솟값
        int oddDist = Integer.MAX_VALUE; // 홀수 거리 중 최솟값
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int dist = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]); // 두 좌표 사이의 거리 계산
                if (dist % 2 == 0) { // 거리가 짝수일 경우
                    evenDist = Math.min(evenDist, dist); // 짝수 거리 중 최솟값 갱신
                } else { // 거리가 홀수일 경우
                    oddDist = Math.min(oddDist, dist); // 홀수 거리 중 최솟값 갱신
                }
            }
        }

        System.out.println(evenDist + oddDist); // 짝수 거리 중 최솟값과 홀수 거리 중 최솟값의 합 출력

        sc.close(); // 입력 스트림 닫기
    }
}