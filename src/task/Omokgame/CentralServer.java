package task.Omokgame;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class CentralServer {

    private ServerSocket serverSocket;
    private ArrayList<Socket> players = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        CentralServer server = new CentralServer();
    }


    public CentralServer() {
        try {
            serverSocket = new ServerSocket(7464);
            System.out.println("중앙 서버가 생성되었습니다.");
            acceptConnections();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptConnections() {
        while (players.size() < 2) {
            try {
                Socket socket = serverSocket.accept();
                players.add(socket);

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                if (players.size() == 1) {
                    dos.writeBoolean(true); // 첫 번째 클라이언트에게 먼저 차례임을 알립니다.
                } else {
                    dos.writeBoolean(false); // 두 번째 클라이언트에게 차례 정보를 전송합니다.
                }

                System.out.println("새로운 참가자가 연결되었습니다. 현재 참여 인원: " + players.size() + "명");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        playGame();
    }


    private void playGame() {
        int currentPlayerIndex = 0;
        boolean gameEnd = false;
        while (!gameEnd) {
            try {
                Socket currentPlayerSocket = players.get(currentPlayerIndex);
                OutputStream os = currentPlayerSocket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                try {
                	dos.writeUTF("Your Turn"); // 턴 전환을 알리는 메시지 전송
					
                	InputStream is = currentPlayerSocket.getInputStream();
                	DataInputStream dis = new DataInputStream(is);
                	
                	int rowIndex = dis.readInt();
                	int colIndex = dis.readInt();
                	
                	if (rowIndex == -1 && colIndex == -1) { // 게임 종료를 의미하는 문자열인 ‘end’의 경우 반복문을 탈출합니다.
                		gameEnd = true;
                		dos.writeUTF("end");
                		broadcast(currentPlayerSocket, rowIndex, colIndex);
                		break;
                	}
                	
                	// 턴이 종료되면 다른 플레이어에게 돌의 위치를 전송합니다.
                	broadcast(currentPlayerSocket, rowIndex, colIndex);
				} catch (Exception e) {
					// TODO: handle exception
					 gameEnd = true;
				}


                currentPlayerIndex = (currentPlayerIndex + 1) % 2; // 턴 넘기기
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void broadcast(Socket sender, int rowIndex, int colIndex) {
        for (Socket player : players) {
            if (player != sender) {
                try {
                    DataOutputStream out = new DataOutputStream(player.getOutputStream());
                    out.writeInt(rowIndex);
                    out.writeInt(colIndex);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
