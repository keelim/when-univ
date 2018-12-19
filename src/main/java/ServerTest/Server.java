package ServerTest;


import Command.Command;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;


public class Server implements Serializable {
    private static final long serialVersionUID = 1L;
    static int requestcommand;
    static String[] requestcommandArgs;
    List<String> id_list;
    private Command readComm;
    private Command writeComm;


    public Server() {
        id_list = new LinkedList<>();
        try (ServerSocket socket = new ServerSocket(8080)) {
            JFrame frame = new JFrame();
            frame.add(new JLabel(" Server Monitoring"), BorderLayout.CENTER);
            JTextArea textArea = new JTextArea();
            TextAreaOutputStream toutputStream = new TextAreaOutputStream(textArea, 60);
            PrintStream outputStream = new PrintStream(toutputStream);
            System.setOut(outputStream);
            System.setErr(outputStream);

            frame.add(new JScrollPane(textArea));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Server Monitoring");
            frame.pack();
            frame.setSize(600, 400);
            frame.setVisible(true);
            while (true) {
                System.out.println("멀티 서버 구성입니다. ");
                System.out.println("서버를 시작을 합니다. ");
                System.out.println("접속을 기다리고 있습니다.");

                Socket incoming = socket.accept(); // 소켓을 듣는다.
                Handling h = new Handling(incoming); // --> 접속 커넥션 마다 쓰레드를 부여를 한다.
                new Thread(h).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Server();
    }

    public synchronized void handling(Command read, ObjectOutputStream writeStream) {

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
                System.out.println("코드 2222"); //레벨을 확인을 한다. level를 확인을 한다.
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
                if (id_list.indexOf(requestcommandArgs[0]) == -1) {
                    System.out.println("코드 4444 1 실행 중복 아이디 없음");
                    writeComm.setStatus(1);
                } else {
                    System.out.println("코드 4444 2 실행 중복 아이디 있음");
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
        private Socket socket;
        private ObjectInputStream readStream; // 공유된 스트림이라 전송이 되지 않았던 것 --> 선언 부분을 쓰레드 차원으로 내리는 것
        private ObjectOutputStream writeStream;
        private String user_id;

        public Handling(Socket socket) throws IOException {
            this.socket = socket;
            readStream = new ObjectInputStream(socket.getInputStream()); // 이 스트림은 소켓에 들어가야 한다.
            writeStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("스트림 셋팅을 완료하였습니다. ");
        }


        @Override
        public synchronized void run() {
            while (true) {
                System.out.println("handling 을 시작합니다. ");
                try {
                    readComm = (Command) readStream.readObject();
                    String[] user = readComm.getArgs();
                    this.user_id = user[0];
                    System.out.println(readComm.getCommandValue() + "를 받았습니다. ");
                    handling(readComm, writeStream);
                } catch (IOException e) {
                    e.getMessage();
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
            try {
                System.out.println("커넥션이 끊어진 id 입니다. " + user_id);
                id_list.remove(user_id);
                System.out.println(id_list);
                socket.close();
            } catch (IOException e) {
                e.getMessage();
            }

        }

    }
}
