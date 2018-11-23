package MainTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SuperClient {
	private String ID;
	private String PW;
	private int GameMoney;
	private int level;
	
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;

	// 1. 데이터를 계속 전송 쓰레드
	// 2. 데이터를 계속 수신 쓰레드

	public void connect() {
		try {
			System.out.println("접속 시도");
			clientSocket = new Socket("192.168.0.6", 10002);
			System.out.println("접속 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dataRecv() {
		Thread t1 = new Thread(new Runnable() {
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
		t1.start();
	}

	public void dataSend() {
		Thread t2 = new Thread(new Runnable() {
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
		t2.start();
	}

	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
		}
	}

	public SuperClient() {
		connect();
		streamSetting();
		dataSend();
		dataRecv();
	}

	public static void main(String[] args) {
		new SuperClient();
	}
}
