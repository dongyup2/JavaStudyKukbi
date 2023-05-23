package task.Omokgame;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int BOARD_SIZE = 15;
    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private static final int gap = 0;
    
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private int currentPlayer = BLACK;
    
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		DataInputStream dis = null;
		
		try {
			serverSocket = new ServerSocket(7464);
			System.out.println("서버 준비 완료");
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결 완료");
			in = socket.getInputStream();
			dis = new DataInputStream(in);
			
			String userMsg = dis.readUTF();
			System.out.println("사용자에서 보낸 메세지 : " + userMsg );
			
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				dis.close();
				in.close();
				serverSocket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
