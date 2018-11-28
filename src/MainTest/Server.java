package MainTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private DataOutputStream dataOutputStream1;
	private List<Integer> client1;
	private List<Integer> client2;
	private int servernum = 0;

	// 1. 데이터를 계속 전송 쓰레드 // 서버 1개 클라이언트 2개 접속 ?? --> 메시자>
	// 2. 데이터를 계속 수신 쓰레드
	public void GameSetting() {
		client1 = new ArrayList<Integer>();
		client2 = new ArrayList<Integer>();
		for(int i=0; i<28; i++) { //윷판의 개수 만큼 0을 대입을 한다.
			client1.add(0);
			client2.add(0);
		}
	}

	public void serverSetting() { // 포트 넘버 10002 번을 사용을 할 것
		try {
			 //localhost, 10002
			serverSocket = new ServerSocket(10002); // 바인드
			System.out.println("서버 생성");
			clientSocket = serverSocket.accept(); // 어셉트.
			// 소켓이 접속 완료 된 부분
			System.out.println("클라이언트 소켓 연결");
			
			synchronized(this) {
				this.servernum = servernum + 1;	
			}
			
		} catch (Exception e) {
		}
	}

	public void closeAll() {
		try {
			serverSocket.close();
			clientSocket.close();
			dataInputStream.close();
			dataOutputStream.close();
		} catch (Exception e) {
		}
	}

	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			dataOutputStream1 = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
		}
	}

	public void dataRecv() {
		Thread t2 = new Thread(new Runnable() {
			boolean isThread = true;

			@Override
			public void run() {
				while (isThread) {
					try {
						String recvData = dataInputStream.readUTF();
						if (recvData.equals("/quit"))
							isThread = false;
						else
							System.out.println("상대방 : " + recvData);
					} catch (Exception e) {
					}
				}
			}
		});
		t2.start();
	}

	public void dataSend() {
		Thread t1 = new Thread(new Runnable() {
			Scanner in = new Scanner(System.in);
			boolean isThread = true;

			@Override
			public void run() {
				while (isThread) {
					try {
						String sendData = in.nextLine();
						if (sendData.equals("/quit"))
							isThread = false;
						else
							dataOutputStream.writeUTF(sendData);
					} catch (Exception e) {
					}
				}
			}
		});
		t1.start();
	}

	public Server() {
		serverSetting();
		streamSetting();
		dataRecv();
		dataSend();
		sendServernum();
	}

	public void sendServernum() {
		Thread servernum = new Thread(() -> {
			boolean isThread = true;
			while (isThread) {
				try {
					int sendData = this.servernum;
					dataOutputStream1.write(sendData);
				} catch (IOException e) {
					// TODO 자동 생성된 catch 블록
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		new Server();
	}
}
