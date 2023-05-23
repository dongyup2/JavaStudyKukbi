package task.Omokgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.Data;
@Data
public class OmokServer {

	private static final int PORT = 7464;
	private static final int BOARD_SIZE = 15;
	private static final int BLACK = 1;
	private static final int WHITE = 2;
	private static final int EMPTY = 0;

	private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
	private int currentPlayer = BLACK;

	public static void main(String[] args) {
	    OmokServer server = new OmokServer();
	    try {
	        ServerSocket serverSocket = new ServerSocket(7464);
	        System.out.println("서버 시작!");

	        Socket client1 = serverSocket.accept();
	        System.out.println("클라이언트 1이 접속했습니다.");
	        DataInputStream dis1 = new DataInputStream(client1.getInputStream());
	        DataOutputStream dos1 = new DataOutputStream(client1.getOutputStream());

	        Socket client2 = serverSocket.accept();
	        System.out.println("클라이언트 2가 접속했습니다.");
	        DataInputStream dis2 = new DataInputStream(client2.getInputStream());
	        DataOutputStream dos2 = new DataOutputStream(client2.getOutputStream());

	        while (true) {
	            int row = -1;
	            int col = -1;
	            
	            if (server.getCurrentPlayer() == BLACK) {
	                System.out.println("클라이언트 1의 차례입니다.");
	                row = dis1.readInt();
	                col = dis1.readInt();
	            } else {
	                System.out.println("클라이언트 2의 차례입니다.");
	                row = dis2.readInt();
	                col = dis2.readInt();
	            }

	            if (server.isValidMove(row, col)) {
	                server.makeMove(row, col);

	                dos1.writeInt(row);
	                dos1.writeInt(col);
	                dos1.flush();
	                dos2.writeInt(row);
	                dos2.writeInt(col);
	                dos2.flush();

	                if (server.isGameOver()) {
	                    break;
	                }
	            } else {
	                System.out.println("잘못된 위치입니다.");
	            }
	        }

	        dis1.close();
	        dis2.close();
	        dos1.close();
	        dos2.close();
	        client1.close();
	        client2.close();
	        serverSocket.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}



	 public boolean isValidMove(int row, int col) {
	        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == 0;
	    } 

	    public void makeMove(int row, int col) {
	        // 서버로 위치 정보 전송         
			board[row][col] = currentPlayer;
			if (isGameOver()) {    
			    System.out.println("게임종료: 플레이어 " + currentPlayer + "가 이겼습니다!");
			    System.exit(0);
			}
			currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
	    }


	    public boolean isGameOver() {
	        boolean result = true;

	        // 현재 수를 놓을 수 있는 곳이 있는지 확인
	        for (int i = 0; i < BOARD_SIZE; i++) {
	            for (int j = 0; j < BOARD_SIZE; j++) {
	                if (board[i][j] == 0) {
	                    result = false;
	                    break;
	                }
	            }
	            if (!result) {
	                break;
	            }
	        }

	        // 다섯 개의 돌이 연속해서 놓인 경우 게임 종료
	        if (result) {
	            System.out.println("게임종료 : 무승부");
	            return true;
	        }

	        for (int i = 0; i < BOARD_SIZE; i++) {
	            for (int j = 0; j < BOARD_SIZE; j++) {
	                // 가로로 다섯 개가 연속해서 놓인 경우
	                if (j < BOARD_SIZE - 4 && board[i][j] == currentPlayer && board[i][j + 1] == currentPlayer && board[i][j + 2] == currentPlayer
	                        && board[i][j + 3] == currentPlayer && board[i][j + 4] == currentPlayer) {
	                	
	                    return true;
	                }
	                // 세로로 다섯 개가 연속해서 놓인 경우
	                if (i < BOARD_SIZE - 4 && board[i][j] == currentPlayer && board[i + 1][j] == currentPlayer && board[i + 2][j] == currentPlayer
	                        && board[i + 3][j] == currentPlayer && board[i + 4][j] == currentPlayer) {
	                	
	                    return true;
	                }
	                // 왼쪽 대각선으로 다섯 개가 연속해서 놓인 경우
	                if (i < BOARD_SIZE - 4 && board[i][j] == currentPlayer && board[i + 1][j] == currentPlayer &&board[i + 2][j + 2] == currentPlayer
	                		&& board[i + 3][j + 3] == currentPlayer && board[i + 4][j + 4] == currentPlayer) {   
	                	
	                    return true;
	                }


	             // 오른쪽 대각선으로 다섯 개가 연속해서 놓인 경우
	                if (i < BOARD_SIZE - 4 && j >= 4 && board[i][j] == currentPlayer && board[i + 1][j - 1] == currentPlayer) {
	                    if (board[i + 2][j - 2] == currentPlayer && board[i + 3][j - 3] == currentPlayer && board[i + 4][j - 4] == currentPlayer) {  
	                    	
	                        return true;
	                    }
	                }
	            }
	        }
			return result;
	    }

	    public void printBoard() {
	        System.out.print("  ");
	        for (int i = 0; i < BOARD_SIZE; i++) {
	            System.out.printf("%2d ", i);
	        }
	        System.out.println();

	        for (int i = 0; i < BOARD_SIZE; i++) {
	            System.out.printf("%2d ", i);  // 위치를 나타내는 숫자 출력
	            for (int j = 0; j < BOARD_SIZE; j++) {
	                if (board[i][j] == BLACK) {
	                    System.out.print("●  ");
	                } else if (board[i][j] == WHITE) {
	                    System.out.print("○  ");
	                } else {
	                    System.out.print("+  ");
	                }
	            }
	            System.out.printf("%2d\n", i);
	        }

	        System.out.print("  ");
	        for (int i = 0; i < BOARD_SIZE; i++) {
	        	System.out.printf("%2d ", i);
	        }
	        System.out.println();
	    }
}