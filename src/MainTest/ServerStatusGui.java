package MainTest;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ServerStatusGui extends JFrame {
	private DataInputStream input;
	private Socket clientSocket;
	private JLabel StringAccess, Accessnum;
	private int serverstatusNum;
	
	public ServerStatusGui() {
		startConnect();
		setTitle("서버 상태");
		setSize(500, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);

		StringAccess = new JLabel("Access num: ");
		StringAccess.setToolTipText("");
		StringAccess.setBounds(78, 26, 97, 39);
		getContentPane().add(StringAccess);

		Accessnum = new JLabel("");
		Accessnum.setBounds(210, 38, 57, 15);
		getContentPane().add(Accessnum);

	}
	public void startConnect() {
		connect();
		streamSetting();
		recvData();
	}

	public void connect() {
		try {
			clientSocket = new Socket("localhost", 10003);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void streamSetting() {
		try {
			input = new DataInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}

	public void recvData() {
		Thread status = new Thread(() -> {
			boolean isThread = true;
			while (isThread) {
				int recvData;
				try {
					recvData = input.read();
					
					Accessnum.setText(Integer.toString(recvData));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		status.start();
	}
}
