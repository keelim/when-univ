package MainTest;

import Command.Command;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    public Command resultComm;
    public Command readComm;
    public Command writeComm;
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return readComm;
    }

    public void sendValue(int commandValue, String args[]) { // 값을 보낸다.
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

    public Command win(String id) {
        String[] args = {id};
        sendValue(Command.WIN, args);
        return getResponse();
    }

    public Command level(String id) {
        String[] args = {id};
        sendValue(Command.LEVEL, args);
        return getResponse();
    }

    public Command point(String id) {
        String[] args = {id};
        sendValue(Command.POINT, args);
        return getResponse();
    }

    public Command idplus(String id) {
        String[] args = {id};
        sendValue(Command.PLUSID, args);
        return getResponse();
    }


    public Command pluswin(String id) {
        String[] args = {id};
        sendValue(Command.PLUSWIN, args);
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