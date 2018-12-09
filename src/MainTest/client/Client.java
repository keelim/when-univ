package MainTest.client;

import MainTest.CommandTest.Command;
import MainTest.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable {
    private Socket socket;
    Command readComm;
    Command writeComm;
    public Command resultComm;
    private ObjectInputStream readStream;
    private ObjectOutputStream writeStream;
    private User user = User.getInstance();

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 18069);
            writeStream = new ObjectOutputStream((socket.getOutputStream()));
            readStream = new ObjectInputStream((socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Command getResponse(){ //서버의 반응을 살핀다.
        try {
            readComm = (Command) readStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return readComm;
    }

    public void sendValue(int commandValue, String args[]){ // 값을 보낸다.
        writeComm = new Command(commandValue);
        writeComm.setArgs(args);
    }

    public Command win(String id){
        String[] args = {id};
        sendValue(Command.WIN, args);
        return getResponse();
    }

    public Command level(String id){
        String[] args = {id};
        sendValue(Command.LEVEL, args);
        return getResponse();
    }

    public Command point(String id){
        String[] args = {id};
        sendValue(Command.POINT, args);
        return getResponse();
    }



    public void close(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}