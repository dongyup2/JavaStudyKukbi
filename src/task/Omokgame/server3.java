package task.Omokgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server3 {
    private static final int PORT = 7464;
    private static final int BOARD_SIZE = 15;
    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private static final int gap = 0;

    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private int currentPlayer = BLACK;

    public static void main(String[] args) {
        server3 server3 = new server3();
        Scanner scanner = new Scanner(System.in);
        try {
            ServerSocket serverSocket = new ServerSocket(7464);
            System.out.println("서버가 시작되었습니다 !");
            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(() -> {
                    try {
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        while (!server3.isGameOver()) {
                            int row = dis.readInt();
                            int col = dis.readInt();  // 클라이언트에서 돌을 둔 위치 정보를 받음
                            if (server3.isValidMove(row, col)) {
                                server3.makeMove(row, col);                                                           
                                    // 서버로부터 다른 플레이어가 둔 돌의 위치를 수신
//                                    int rowFromServer = dis.readInt();
//                                    int colFromServer = dis.readInt();
//                                    client2.board[rowFromServer][colFromServer] = (client2.currentPlayer == BLACK) ? WHITE : BLACK;
                                	server3.printBoard();
                                	int scrow = -1;
                                    int sccol = -1;
                                    while (!server3.isValidMove(scrow, sccol)) {
                                        System.out.print("Player " + server3.currentPlayer + " 턴 입니다. 열과 행을 입력해주세요: ");
                                        String input = scanner.nextLine().trim();
                                        if (input.isEmpty()) {
                                            continue;
                                        }
                                        String[] inputs = input.split(" ");
                                        if (inputs.length != 2) {
                                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                                            continue;
                                        }
                                        try {
                                        	scrow = Integer.parseInt(inputs[0]);
                                        	sccol = Integer.parseInt(inputs[1]);
                                        } catch (Exception e) {
                                            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                                        }
                                    }
                                dos.writeInt(scrow);
                                dos.writeInt(sccol);  // 클라이언트에게 다음 돌의 위치를 전송
                                dos.flush();
                                if (server3.isGameOver()) {
                                    break;
                                }
                            } else {
                                System.out.println("잘못된 위치입니다.");
                            }
                        }
                        dis.close();
                        dos.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            }
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
                if (board[i][j] == gap) {
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