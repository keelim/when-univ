package ServerTest;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MulticlientServersub { // 각각의 유저들에게 소켓과 일을 부여를 해야 한다. 데이터를 받고 구분을 하는 것으로 하자
    // 멀티 룸을 가지는 서버는 무리이다.
    private static int input_data;
    private static int room_num;

    public static void main(String[] args) {
        input_data = 0;
        try {
            ServerSocket s = new ServerSocket(18070);

            while (true) {
                System.out.println("멀티 서버 구성입니다. ");
                System.out.println("서버를 시작을 합니다. ");
                System.out.println("접속을 기다리고 있습니다.");
                Socket incoming = s.accept();
                Runnable r = new ThreadedEchoHandler(incoming); // 새로운 쓰레드를 만들고 실행을 시키는 것이 안전하지 않는가?
                // 서버가 그냥 살아있는지 확인 하는 것 이후 쓰레드 부터 진짜할일을 구성 하는 것이다.
                Thread t = new Thread(r);
                t.start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void streamSetting(){
        try (OutputStream outStream = incoming.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
            InputStream inStream = incoming.getInputStream();){

    }

    static class ThreadedEchoHandler implements Runnable { // 데이터를 판단하는 쓰레드
        // 1. 사람의 접속을 확인하는 쓰레드
        // 2. 승리를 데이터베이스의 추가를 하는 쓰레드

        private Socket incoming;

        public synchronized void input_check(int setNum){
            input_data = setNum;
        }

        public ThreadedEchoHandler(Socket i) {
            incoming = i;
        }

        public void run() {
            try {


                    boolean isThread = true;
                    while (isThread) {
                        System.out.println("값을 판단 합니다. '");
                        input_check(inStream.read());

                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


