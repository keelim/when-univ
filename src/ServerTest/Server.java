package ServerTest; // 서버 패키지는 따로 구현을 할 것

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server { // 보내려는 데이터 마다 소켓을 생성을 해주어야 한다.
	private ServerSocket serverSocket;
	private ServerSocket serverSocket1;
	private Socket clientSocket;
	private Socket clientSocket1;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private DataOutputStream dataOutputStream1;
	private BufferedOutputStream bufferoutputstream;
	private int servernum = 0;

	// 1. 데이터를 계속 전송 쓰레드 // 서버 1개 클라이언트 2개 접속 ?? --> 메시자>
	// 2. 데이터를 계속 수신 쓰레드

	public void serverSetting() { // 포트 넘버 10002 번을 사용을 할 것

		try {
			// localhost, 10002, 10003
			serverSocket = new ServerSocket(10002); // 바인드
			serverSocket1 = new ServerSocket(10003); // 자바 스테이터스 소켓
			System.out.println("서버 생성");
			System.out.println("접속을 기다리는 중입니다. ");
			while (true) {
				clientSocket = serverSocket.accept(); // 어셉트.
				clientSocket1 = serverSocket1.accept();
				// 소켓이 접속 완료 된 부분

				++servernum;
				System.out.println("포트 연결을 완료 하였습니다.");
				System.out.println("클라이언트 소켓 연결");
				System.out.println("접속자 수" + servernum + " 입니다. ");
			}

			// connect 할 때 마다 늘어냐야 한다.
		} catch (Exception e) {
		}
	}

	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			bufferoutputstream = new BufferedOutputStream(new DataOutputStream(clientSocket1.getOutputStream()));
		} catch (Exception e) {
		}
	}

	public void serverNum() {
		new Thread(() -> {
			boolean isThread = true;
			while (isThread) {
				try {
					bufferoutputstream.write(servernum);
					Thread.sleep(50);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO 자동 생성된 catch 블록
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void dataRecv() {
		new Thread(() -> {
			boolean isThread = true;
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

		}).start();
	}

	public void dataSend() {
		new Thread(() -> {
			Scanner in = new Scanner(System.in);
			boolean isThread = true;

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

		}).start();
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

	public Server() {
		serverSetting();
		streamSetting();
		dataRecv();
		dataSend();
		serverNum();
	}

	public static void main(String[] args) {
		System.out.println("다중 접속 서버 작동");
		new Server();
	}
}
