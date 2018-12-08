package ServerTest;


import MainTest.Command;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class MulticlientServer {
    static int requestcommand;
    static String[] requestcommandArgs;
    // 각각의 유저들에게 소켓과 일을 부여를 해야 한다. 데이터를 받고 구분을 하는 것으로 하자
    // 멀티 룸을 가지는 서버는 무리이다.
    private PrintWriter out;
    private InputStream inStream;
    private ObjectInputStream readStream;
    private ObjectOutputStream writeStream;
    private Command readComm;
    private Command writeComm;


    public MulticlientServer() {
        try {
            ServerSocket s = new ServerSocket(18069);

            while (true) {
                System.out.println("멀티 서버 구성입니다. ");
                System.out.println("서버를 시작을 합니다. ");
                System.out.println("접속을 기다리고 있습니다.");
                Socket incoming = s.accept();

                StreamSetting(incoming); // 새로운 쓰레드를 만들고 실행을 시키는 것이 안전하지 않는가?
                // 서버가 그냥 살아있는지 확인 하는 것 이후 쓰레드 부터 진짜할일을 구성 하는 것이다.

                while (true) {
                    readComm = (Command) readStream.readObject();
                    handling(readComm);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MulticlientServer();
    }

    public void StreamSetting(Socket incoming) {
        try {
            readStream = new ObjectInputStream(incoming.getInputStream());
            writeStream = new ObjectOutputStream(incoming.getOutputStream());
            System.out.println("스트림 셋팅을 완료하였습니다. ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void handling(Command read) {
        System.out.println("커맨드를 실행을 합니다. ");
        writeComm = new Command(0);
        requestcommand = read.getCommandValue();
        requestcommandArgs = read.getArgs();

        switch (requestcommand) {
            case 100:
                //
                //
                System.out.println("코드 100");
                break;

            case 7777:

                //
                //
                //
                System.out.println("코드 7777");
                new Win("test");
                break;
        }
        try {
            writeStream.reset();
            writeStream.writeObject(writeComm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

