package MainTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private List<Intefer> 

	// 1. 데이터를 계속 전송 쓰레드 // 서버 1개 클라이언트 2개 접속 ?? --> 메시자>
	// 2. 데이터를 계속 수신 쓰레드

	public void serverSetting() {
		try {
			// localhost, 10002
			serverSocket = new ServerSocket(10002); // 바인드
			System.out.println("서버 생성");
			clientSocket = serverSocket.accept(); // 어셉트.
			// 소켓이 접속 완료 된 부분
			System.out.println("클라이언트 소켓 연결");
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
	}

	public static void main(String[] args) {
		new Server();
	}
}
