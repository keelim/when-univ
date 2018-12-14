package ServerTest;


import MainTest.Command;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class MulticlientServer {
    static int requestcommand;
    static String[] requestcommandArgs;
    Set<String> id_list = Collections.synchronizedSet(new HashSet<>());
    // 각각의 유저들에게 소켓과 일을 부여를 해야 한다. 데이터를 받고 구분을 하는 것으로 하자
    // 멀티 룸을 가지는 서버는 무리이다.
    private ObjectInputStream readStream;
    private ObjectOutputStream writeStream;
    private Command readComm;
    private Command writeComm;


    public MulticlientServer() {
        try {
            ServerSocket s = new ServerSocket(18069); // 서버 모니터링을 구현을 한다.
            JFrame frame = new JFrame();
            frame.add(new JLabel(" Server Monitoring"), BorderLayout.NORTH);


            JTextArea ta = new JTextArea();
            TextAreaOutputStream taos = new TextAreaOutputStream(ta, 60);
            PrintStream ps = new PrintStream(taos);
            System.setOut(ps);
            System.setErr(ps);


            frame.add(new JScrollPane(ta));
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }
            frame.pack();
            frame.setVisible(true);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(3);


            while (true) {
                System.out.println("멀티 서버 구성입니다. ");
                System.out.println("서버를 시작을 합니다. ");
                System.out.println("접속을 기다리고 있습니다.");
                Socket incoming = s.accept(); // 접속을 기다린다.
                // 서버가 그냥 살아있는지 확인 하는 것 이후 쓰레드 부터 진짜할일을 구성 하는 것이다.
                readStream = new ObjectInputStream(incoming.getInputStream());
                writeStream = new ObjectOutputStream(incoming.getOutputStream());
                System.out.println("스트림 셋팅을 완료하였습니다. ");

                Handling h = new Handling();
                new Thread(h).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("소켓 연결이 끊어졌습니다. ");
        }
    }

    public static void main(String[] args) {
        new MulticlientServer();
    }

    public synchronized void handling(Command read) {
        System.out.println("커맨드를 실행을 합니다. ");
        writeComm = new Command(0);
        requestcommand = read.getCommandValue();
        requestcommandArgs = read.getArgs();

        switch (requestcommand) {
            case 3333:
                System.out.println("코드 3333"); //point를 확인을 한다.
                DBload m = new DBload();
                System.out.println(requestcommandArgs[0]);
                System.out.println(m.point(requestcommandArgs[0]));
                writeComm.setPoint(m.point(requestcommandArgs[0]));
                break;

            case 7777:
                System.out.println("코드 7777"); //win을 받으러 온다.
                DBload m1 = new DBload();
                System.out.println(requestcommandArgs[0]);
                System.out.println(m1.win(requestcommandArgs[0]));
                writeComm.setWin(m1.win(requestcommandArgs[0]));
                break;

            case 2222:
                System.out.println("코드 2222"); //레벨을 확인을 한다.
                DBload m2 = new DBload();
                System.out.println(requestcommandArgs[0]);
                System.out.println(m2.level(requestcommandArgs[0]));
                writeComm.setLevel(m2.level(requestcommandArgs[0]));
                break;
            case 8888:
                System.out.println("코드 8888"); //pluswin을 실행한다.
                DBload m3 = new DBload();
                m3.pluswin(requestcommandArgs[0]);

            case 4444:
                System.out.println("코드 4444"); // 서버의 아이디 추가 실행 중복 아이디 방지
                if (id_list.contains(requestcommandArgs[0]) == false) {
                    System.out.println("코드 4444 실행");
                    writeComm.setStatus(1);
                } else {
                    System.out.println("코드 4444 실행");
                    writeComm.setStatus(-1);
                }

                id_list.add(requestcommandArgs[0]);
                System.out.println("현재 접속되어 있는  아이디 입니다. " + id_list);

        }
        try {
            writeStream.reset();
            writeStream.writeObject(writeComm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Handling implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("handling 을 시작합니다. ");
                try {
                    readComm = (Command) readStream.readObject();
                    System.out.println(readComm.getCommandValue() + "를 받았습니다. ");
                    handling(readComm);
                } catch (IOException e) {

                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }

        }
    }
}

