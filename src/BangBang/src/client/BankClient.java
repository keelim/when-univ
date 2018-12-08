package BangBang.src.client;

import BangBang.src.Command.Command;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class BankClient implements Serializable {
    private static final long serialVersionUID = 1L;
    Command readComm, writeComm, resultComm;
    private Socket outGoing;
    private ObjectInputStream readStream;
    private ObjectOutputStream writeStream;

    public BankClient(String servIP, int port) {
        try {
            outGoing = new Socket(servIP, port);
            writeStream = new ObjectOutputStream(outGoing.getOutputStream());
            readStream = new ObjectInputStream(outGoing.getInputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ���������� ������
    public Command getBankInfo() {
        sendValue(Command.GetBankInfo, null);
        return getResponse();
    }

    // �Ա�
    public Command Deposit(int cusidx, int acctidx, double amount) {
        String[] args = {Integer.toString(cusidx), Integer.toString(acctidx), Double.toString(amount)};
        sendValue(Command.DEPOSIT, args);
        return getResponse();
    }

    // ���
    public Command Withdraw(int cusidx, int acctidx, double amount) {
        String[] args = {Integer.toString(cusidx), Integer.toString(acctidx), Double.toString(amount)};
        sendValue(Command.WITHDRAW, args);
        return getResponse();
    }

    // ������ü
    public Command Transfer(int fromcusidx, int fromacctidx, int tocusidx, int toacctidx, double amount) {
        String[] args = {Integer.toString(fromcusidx), Integer.toString(fromacctidx), Integer.toString(tocusidx),
                Integer.toString(toacctidx), Double.toString(amount)};
        sendValue(Command.TRANSFER, args);
        return getResponse();
    }

    // ������ �����͸� ����
    public void sendValue(int commandValue, String args[]) {
        writeComm = new Command(commandValue);
        writeComm.setArgs(args);
        try {
            writeStream.writeObject(writeComm);
        } catch (IOException e) {
            System.err.println("Send Error");
        }
    }

    // ������ ���� �����͸� �޴´�
    public Command getResponse() {
        try {
            readComm = (Command) readStream.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Protocol error: class Command not found");
            e.printStackTrace();
        } catch (InvalidClassException e) {
            System.err.println("Protocol error: the class serilized is not valid");
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            System.err.println("Protocol error: the class coming from the Socket stream was garbled");
            e.printStackTrace();
        } catch (OptionalDataException e) {
            System.err.println(
                    "Protocol error: the stream contains primitive data and not the class Command as expected");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Protocol error: there was an error in the stream communications");
            System.out.println("�������� ������ ���������ϴ�. ���α׷��� �����մϴ�");
            System.exit(1);
            // e.printStackTrace();
        }
        return readComm;
    }

    public void close() {
        try {
            outGoing.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
