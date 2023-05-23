package task.Omokgame.wrtn;

import java.io.*;
import java.net.*;
import java.util.*;

public class WrtnOmokgameClient1 {
    private static final int BOARD_SIZE = 15;
    private static final int BLACK = 1;
    private static final int WHITE = 2;

    private Socket socket;
    private int[][] board;
    private int currentPlayer;
    private DataInputStream dis;
    private DataOutputStream dos;
    private int playerNumber = BLACK;

    public static void main(String[] args) {
        WrtnOmokgameClient1 client = new WrtnOmokgameClient1();
        client.startGame();
    }

    public WrtnOmokgameClient1() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public void startGame() {
        try {
            socket = new Socket("localhost", 33333);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            playerNumber = dis.readInt();
            System.out.println("서버에 접속 성공! 플레이어 : " + playerNumber);
            playGame();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in); // 스캐너 객체를 메소드 바깥에 초기화했습니다.
        while (true) {
        	printBoard();

            // 현재 플레이어 읽기를 메서드로 따로 분리하였습니다.
            readCurrentPlayer();

            if (currentPlayer == -1) {
                System.out.println("게임 종료.");
                break;
            }

            if (currentPlayer == playerNumber) {
                System.out.println("플레이어 " + currentPlayer + "님의 차례입니다.");

                System.out.print("x 좌표를 입력하세요: ");
                int x = scanner.nextInt();
                System.out.print("y 좌표를 입력하세요: ");
                int y = scanner.nextInt();

                sendCoordinates(x, y);
            } else {
                readOpponentCoordinates();
            }
        }
        scanner.close(); // 스캐너 객체를 닫습니다.
    }

    private void readCurrentPlayer() {
        try {
            currentPlayer = dis.readInt();
            System.out.println("현재 플레이어: " + currentPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendCoordinates(int x, int y) {
        try {
            board[x][y] = currentPlayer;
            printBoard();

            dos.writeInt(x);
            dos.writeInt(y);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readOpponentCoordinates() {
        try {
            int x = dis.readInt();
            int y = dis.readInt();
            board[x][y] = currentPlayer;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.printf("%2d ", i);
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
