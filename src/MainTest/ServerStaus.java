package MainTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerStaus extends JFrame {
	private static Socket clientSocket;
	private DataInputStream dataInputStream = null;

	public static void connect() {

		// 로컬호스트 (127.0.0.1) 서버로 접속한다. 직접 적으로 label을 실시간으로 정해주는 것은 없다.
		// 버튼을 눌러서 해당 상황이 해당이 되는 것을 label을 넣어 주는 것이 좋을 것 같다.
		try {
			clientSocket = new Socket("127.0.0.1", 18069);
			System.out.println("서버에 접속 합니다. ");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch(ConnectException e){
            e.printStackTrace();
            System.out.println("서버가 열리지 않는 것 같습니다. ");
            JOptionPane.showMessageDialog(null, "서버를 실행을 시켜주세요"); // 클라언트에서 서버의 접속을 확인을 한다.
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	public void dataRecv() { // 쓰레드 안에 핸들러를 넣어야 한다. datarecv 안에 핸들러를 넣는다.
		// 유저가 지금 접속하고 있는 순서를 보내준다. 그러면 id
		new Thread(() -> {
			boolean isThread = true;
			while (isThread) {
				String recvData;
				try {
					System.out.println("값을 받을 준비를 합니다. ");
					recvData = dataInputStream.readUTF();
					System.out.println(recvData);
					//label 을 바꾸려고 하는 순간 에러가 발생한다. --> label 를 사용하지 않는다.
					Thread.sleep(30000);
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void streamSetting() {
		// 데이터 인풋, 아웃풋 스트림을 소켓 스트림과 연결
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ServerStaus() { // Frame 상태에서는 쓰레드를 호환을 할 수 가 없다. ? --> 버튼을 눌러서 확인을 하는 방법을 사용
		connect();
		streamSetting();
		dataRecv();
		setTitle("자바 스테이터스 테스트");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton usersequence = new JButton("접속 순서");
		usersequence.setBounds(153, 10, 119, 38);
		usersequence.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "접속 순서를 확인 합니다.  " ); //핸들러를 통하여 데이터를 받아야 한다.
			}
		});
		getContentPane().add(usersequence);
		
		JButton open_user = new JButton("접속자 수");
		open_user.setBounds(153, 61, 119, 38);
		open_user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("접속자 수를 확인 합니다. ");
                JOptionPane.showMessageDialog(null, "접속자 수를 확인 합니다. ");
            }
        });
		getContentPane().add(open_user);
		
		JButton button1 = new JButton("버튼1");
		button1.setBounds(153, 109, 119, 38);
		getContentPane().add(button1);
		
		JButton button2 = new JButton("버튼2");
		button2.setBounds(153, 157, 119, 38);
		getContentPane().add(button2);
		
		JButton exitbutton = new JButton("접속 종료");
		exitbutton.setBounds(153, 205, 119, 38);
		exitbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("프로그램 종료"); // 프로그램 종료 버튼을 누르면 프로그램을 종료 합니다.
				JOptionPane.showMessageDialog(null, "프로그램을 종료 합니다. ");
				System.exit(1);
			}
		});
		getContentPane().add(exitbutton);
		
		JLabel userid = new JLabel("유저 id");
		userid.setBounds(31, 22, 57, 15);
		getContentPane().add(userid);
		setVisible(true);
	}
}