package maintest;


import command.Command;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    public Command resultComm;
    private Command readComm;
    private Command writeComm;
    private Socket socket;
    private ObjectInputStream readStream;
    private ObjectOutputStream writeStream;

    public Client() { //서버에 접속한 아이디를 저장을 한다.
        try {
            socket = new Socket("127.0.0.1", 8080);
            writeStream = new ObjectOutputStream((socket.getOutputStream()));
            readStream = new ObjectInputStream((socket.getInputStream()));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "서버 오류가 났습니다. 서버를 확인해주시기 바랍니다. ");
            e.getMessage();
            System.exit(1);
        }
    }

    public Command getResponse() { //서버의 반응을 살핀다.
        try {
            readComm = (Command) readStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return readComm;
    }

    public void sendValue(int commandValue, String[] args) { // 값을 보낸다.
        try {
            writeComm = new Command(commandValue);
            writeComm.setArgs(args);
            writeStream.writeObject(writeComm);
        } catch (IOException e) {
            e.printStackTrace();
            close();
            JOptionPane.showMessageDialog(null, "스트림과 소켓을 닫고 종료 합니다. ");
            System.exit(1);
        }
    }

    public Command win(String id) { //승리
        String[] args = {id};
        sendValue(Command.WIN, args);
        return getResponse();
    }

    public Command level(String id) { //레벨
        String[] args = {id};
        sendValue(Command.LEVEL, args);
        return getResponse();
    }

    public Command point(String id) { //포인트
        String[] args = {id};
        sendValue(Command.POINT, args);
        return getResponse();
    }

    public Command idPlus(String id) { //아이디 중복 방지
        String[] args = {id};
        sendValue(Command.PLUS_ID, args);
        return getResponse();
    }

    public Command plusWin(String id) { //승리를 데이터 베이스에서 구현
        String[] args = {id};
        sendValue(Command.PLUS_WIN, args);
        return getResponse();
    }

    public void close() {
        try {
            readStream.close();
            writeStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}