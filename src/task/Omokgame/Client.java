package task.Omokgame;

import java.io.DataOutputStream; 
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	 private static final int BOARD_SIZE = 15;
	    private static final int BLACK = 1;
	    private static final int WHITE = 2;
	    private static final int gap = 0;
	    
	    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
	    private int currentPlayer = BLACK;
	    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		OutputStream out = null;
		DataOutputStream dos = null;
		
		try {
			socket = new Socket("localhost", 7464);
			System.out.println("서버 연결 완료되었습니다.");
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			while(true) {
				System.out.println("서버로 전송할 메시지를 입력하세요");
				String msg = scanner.nextLine();
				dos.writeUTF(msg);
				if(msg.equals("끝")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		}
	
}
