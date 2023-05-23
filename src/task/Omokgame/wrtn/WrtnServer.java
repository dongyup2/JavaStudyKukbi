package task.Omokgame.wrtn;

import java.io.*;
import java.net.*;
import java.util.*;

public class WrtnServer {
	private ServerSocket serverSocket;
	private List<Socket> players;
	
	private static final int BOARD_SIZE = 15;
	private static final int BLACK = 1;
	private static final int WHITE = 2;

	private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
	private int currentPlayer = 1;

	private DataInputStream dis;
	private DataOutputStream dos;
	private BufferedInputStream bis;
	private BufferedOutputStream bos;

	public WrtnServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		players = new LinkedList<>();
		
		System.out.println("오목 게임 서버가 시작되었습니다. 포트: " + port);
	}
	
	public void acceptConnections() {
		try {
			// 두 명의 플레이어를 받아들입니다.
			for (int i = 0; i < 2; i++) {
				Socket socket = serverSocket.accept();
				players.add(socket);
				System.out.println("플레이어 " + (i + 1) + "이/가 연결되었습니다.");
			}

			// 각 클라이언트에게 플레이어 번호를 전달합니다.
			for (int i = 0; i < 2; i++) {
	            Socket socket = players.get(i);
	            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	            dos.writeInt(i + 1);
	            dos.flush(); // 변경 사항 - 버퍼에 남은 데이터를 클라이언트에 전달합니다.
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("두 명의 플레이어가 연결되었습니다. 게임을 시작합니다.");
		playGame();
	}

	// 게임 로직을 수행하는 메서드 playGame() 작성
	public void playGame() {
	    while (true) {
	        try {
	            // 현재 플레이어의 소켓에서 좌표를 받습니다.
	            Socket currentSocket = players.get(currentPlayer - 1);
	            bis = new BufferedInputStream(currentSocket.getInputStream());
	            bos = new BufferedOutputStream(currentSocket.getOutputStream());
	            dis = new DataInputStream(bis);
	            dos = new DataOutputStream(bos);

	            int row = dis.readInt();
	            int col = dis.readInt();

	            if (isValidMove(row, col)) {
	                makeMove(row, col);

	                if (isGameOver(row, col)) { // 게임 종료 조건을 검사
	                    for (Socket socket : players) {
	                        bis = new BufferedInputStream(socket.getInputStream());
	                        bos = new BufferedOutputStream(socket.getOutputStream());
	                        dis = new DataInputStream(bis);
	                        dos = new DataOutputStream(bos);

	                        dos.writeInt(-1); // 게임이 종료되었음을 클라이언트에게 알림
	                        dos.flush();
	                    }
	                    
	                    break; // while 루프를 종료하여 게임을 끝냄
	                }

	                for (Socket socket : players) {	                   
	                    bos = new BufferedOutputStream(socket.getOutputStream());
	                
	                    dos = new DataOutputStream(bos);

	                    dos.writeInt(currentPlayer);
	                    dos.flush();
	                }
	                
	                currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
	                
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public boolean isValidMove(int row, int col) {
		return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == 0;
	}

	public void makeMove(int row, int col) {
		board[row][col] = currentPlayer;
		currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
	}

	public boolean isGameOver(int row, int col) {
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
				if (j < BOARD_SIZE - 4 && board[i][j] == currentPlayer && board[i][j + 1] == currentPlayer
						&& board[i][j + 2] == currentPlayer && board[i][j + 3] == currentPlayer
						&& board[i][j + 4] == currentPlayer) {
					
					return true;
				}
				// 세로로 다섯 개가 연속해서 놓인 경우
				if (i < BOARD_SIZE - 4) {
					if (board[i][j] == currentPlayer && board[i + 1][j] == currentPlayer
							&& board[i + 2][j] == currentPlayer && board[i + 3][j] == currentPlayer
							&& board[i + 4][j] == currentPlayer) {
						System.out.println("게임종료: 플레이어: " + currentPlayer + " 이겼습니다!");
						return true;
					}
				}
				// 왼쪽 대각선으로 다섯 개가 연속해서 놓인 경우
				if (i < BOARD_SIZE - 4 && j < BOARD_SIZE - 4) {
					if (board[i][j] == currentPlayer && board[i + 1][j + 1] == currentPlayer
							&& board[i + 2][j + 2] == currentPlayer && board[i + 3][j + 3] == currentPlayer
							&& board[i + 4][j + 4] == currentPlayer) {
						System.out.println("게임종료: 플레이어: " + currentPlayer + " 이겼습니다!");
						return true;
					}
				}
				// 오른쪽 대각선으로 다섯 개가 연속해서 놓인 경우
				if (i < BOARD_SIZE - 4 && j >= 4) {
					if (board[i][j] == currentPlayer && board[i + 1][j - 1] == currentPlayer
							&& board[i + 2][j - 2] == currentPlayer && board[i + 3][j - 3] == currentPlayer
							&& board[i + 4][j - 4] == currentPlayer) {
						System.out.println("게임종료: 플레이어: " + currentPlayer + " 이겼습니다!");
						return true;
					}
				}
			}
		}
		return false;
	}

	public void printBoard() {
		System.out.print("  ");
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.printf("%2d ", i);
		}
		System.out.println();

		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.printf("%2d ", i); // 위치를 나타내는 숫자 출력
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

	public static void main(String[] args) {
		try {
			WrtnServer server = new WrtnServer(33333);
			server.acceptConnections();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
