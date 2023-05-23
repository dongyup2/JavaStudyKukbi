package task.Omokgame.wrtn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import task.Omokgame.OmokGame;

public class OmokServer {
    private static final int PORT = 12345;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OmokGame game = new OmokGame();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("오목 서버 시작...");
            Socket clientSocket1 = serverSocket.accept();
            Socket clientSocket2 = serverSocket.accept();
            
            ObjectOutputStream out1 = new ObjectOutputStream(clientSocket1.getOutputStream());
            ObjectOutputStream out2 = new ObjectOutputStream(clientSocket2.getOutputStream());
            ObjectInputStream in1 = new ObjectInputStream(clientSocket1.getInputStream());
            ObjectInputStream in2 = new ObjectInputStream(clientSocket2.getInputStream());

            while (!game.isGameOver()) {
                if (game.getCurrentPlayer() == OmokGame.BLACK) {
                    out1.writeObject(game);
                    int[] move = (int[]) in1.readObject();
                    game.makeMove(move[0], move[1]);
                } else {
                    out2.writeObject(game);
                    int[] move = (int[]) in2.readObject();
                    game.makeMove(move[0], move[1]);
                }
            }
            
            out1.writeObject(game);
            out2.writeObject(game);
        }
        
        System.out.println("오목 서버 종료...");
    }
}

