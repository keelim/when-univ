package MainTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class ServerStatus extends JFrame { // 포트 번호는 50369
	private Socket clientserverSocket;
	private ServerSocket serverclientSocket; // 소켓을 만든다.
	private DataInputStream datainput;
	private DataOutputStream outputStream;
	
	public void connectSetting() {
		
	}
}

class  ServerStatusRunnable  { // Runnable 을 구현을 하여 서버 상태 지속 체킹을 할 것
    	public void main1() {
    		new Thread(()-> {
    			
    		}).start();
    			
    		
    	}
	
        
    
}