package ServerTest;

import MainTest.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;


public class ConsoleServer {
    private Set<String> id_list;
    private ServerSocket s;
    private Socket incoming;


    public ConsoleServer() {
        try {
            s = new ServerSocket(18069); // 서버 모니터링을 구현을 한다.
            id_list = new HashSet<>();

            while (true) {
                System.out.println("멀티 서버 구성입니다. ");
                System.out.println("서버를 시작을 합니다. ");
                System.out.println("접속을 기다리고 있습니다.");
                incoming = s.accept(); // 접속을 기다린다.
                // 서버가 그냥 살아있는지 확인 하는 것 이후 쓰레드 부터 진짜할일을 구성 하는 것이다.
                Handling h = new Handling(incoming, id_list);
                new Thread(h).start();
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("소켓 연결이 끊어졌습니다. ");
        }
    }

    public static void main(String[] args) {
        new ConsoleServer();
    }


    class Handling extends Thread {
        private Socket socket;
        private Set<String> id_list;
        private int requestcommand;
        private String[] requestcommandArgs;

        // 각각의 유저들에게 소켓과 일을 부여를 해야 한다. 데이터를 받고 구분을 하는 것으로 하자
        // 멀티 룸을 가지는 서버는 무리이다.
        private ObjectInputStream readStream;
        private ObjectOutputStream writeStream;
        private Command readComm;
        private Command writeComm;

        public Handling(Socket socket, Set id_list) {
            this.socket = socket;
            this.id_list = id_list;
            try {
                readStream = new ObjectInputStream(socket.getInputStream());
                writeStream = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("스트림 셋팅을 완료하였습니다. ");
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("handling 을 시작합니다. ");
                try {
                    readComm = (Command) readStream.readObject();
                    System.out.println(readComm.getCommandValue() + "를 받았습니다. ");
                    handling(readComm, socket);

                    Thread.sleep(100);
                } catch (IOException e) {

                    e.printStackTrace();
                } catch (ClassNotFoundException e) {


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


        }

        public synchronized void handling(Command read, Socket socket) { //커넥션 종료 구현
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
                    writeComm.setStatus(0);
                    id_list.add(requestcommandArgs[0]);
                    System.out.println("현재 접속되어 있는  아이디 입니다. " + id_list);
                    System.out.println("현재 접속자 수는 " + id_list.size());


                case 1212:

                    System.out.println("코드 1212");
                    id_list.remove(requestcommandArgs[0]);
                    System.out.println("접속 멤버 " + id_list);
                    writeComm.setExit_point(1);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("해당 소켓 종료");
                    }


            }
            try {
                writeStream.reset();
                writeStream.writeObject(writeComm);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


