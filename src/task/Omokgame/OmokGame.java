package task.Omokgame;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import java.util.Scanner;

public class OmokGame {
    private static final int BOARD_SIZE = 15;
    private static final int BLACK = 1;
    private static final int WHITE = 2;

    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private int currentPlayer = BLACK;

    public static void main(String[] args) {
        OmokGame game = new OmokGame();
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            int row = -1, col = -1;
            game.printBoard();
            while (true) {
                System.out.print("Player " + game.currentPlayer + " 턴 입니다.\n");
                System.out.print("x좌표: ");
                String inputX = scanner.nextLine();
                System.out.print("y좌표: ");
                String inputY = scanner.nextLine();

                if (isNumeric(inputX) && isNumeric(inputY)) {
                    row = Integer.parseInt(inputX);
                    col = Integer.parseInt(inputY);

                    if (game.isValidMove(row, col)) {
                        break;
                    } else {
                        System.out.println("유효하지 않은 위치입니다. 다시 시도해주세요.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 숫자로 구성된 좌표를 입력해주세요.");
                }
            }

            game.makeMove(row, col);
        }

        scanner.close();
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }

    public int checkPattern(int row, int col, int dx, int dy) {
        int count = 0;
        int x = row, y = col;
        int curPlayer = board[row][col];
        if (curPlayer == 0) return 0;
        while (isValidCoordinate(x, y) && board[x][y] == curPlayer) {
            count++;
            x += dx;
            y += dy;
        }
        return count;
    }

    public boolean isForbidden(int row, int col) {
        int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
        int[] patternCounts = new int[8];

        board[row][col] = currentPlayer;
        for (int i = 0; i < 4; i++) {
            patternCounts[i * 2] = checkPattern(row, col, directions[i][0], directions[i][1]);
            patternCounts[i * 2 + 1] = checkPattern(row, col, -directions[i][0], -directions[i][1]);
        }
        board[row][col] = 0;

        int threeCount = 0;
        int fourCount = 0;
        int sixCount = 0;

        for (int i = 0; i < 4; i++) {
            int count = patternCounts[i * 2] + patternCounts[i * 2 + 1] - 1;
            if (count == 3) {
                int x = row - directions[i][0] * patternCounts[i * 2];
                int y = col - directions[i][1] * patternCounts[i * 2];
                if (!isValidCoordinate(x, y) || board[x][y] != currentPlayer) {
                    threeCount++;
                }
            } else if (count == 4) {
                int x1 = row - directions[i][0] * patternCounts[i * 2];
                int y1 = col - directions[i][1] * patternCounts[i * 2];
                int x2 = row + directions[i][0] * patternCounts[i * 2 + 1];
                int y2 = col + directions[i][1] * patternCounts[i * 2 + 1];
                if ((!isValidCoordinate(x1, y1) || board[x1][y1] != currentPlayer) && (!isValidCoordinate(x2, y2) || board[x2][y2] != currentPlayer)) {
                    fourCount++;
                }
            } else if (count >= 6) {
                sixCount++;
            }
        }
        return (currentPlayer == BLACK) && (threeCount >= 2 || fourCount >= 2 || sixCount >= 1);
    }

    public boolean isValidMove(int row, int col) {
        return isValidCoordinate(row, col) && board[row][col] == 0 && !isForbidden(row, col);
    }

    public void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
        currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
    }

    public boolean isGameOver() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] != 0) {
                    // Check horizontal, vertical, diagonal
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            if (dx == 0 && dy == 0) continue;
                            int count = checkPattern(row, col, dx, dy);

                            if (count >= 5) {
                                printBoard();
                                System.out.println("Player " + board[row][col] + "이/가 이겼습니다.");
                                return true;
                            }
                        }
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