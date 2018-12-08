package BangBang.src.Command;

import BangBang.src.bank.Bank;

import java.io.Serializable;

//�����͵��� �����ؼ� ��ũ��ũ�� ���ؼ� �̵� �� ��ü 
public class Command implements Serializable {
    // Command list
    public static final int DEPOSIT = 10; // �Ա�
    public static final int WITHDRAW = 20; // ���
    public static final int TRANSFER = 30; // ������ü
    public static final int GetBankInfo = 99; // ���� ���� ��ȸ
    private static final long serialVersionUID = 1L;
    private Bank mBank = null;
    // ���¹�ȣ, �ݾ� ���� ��Ʈ���� ������ �����ϴ� ����
    private String[] args = null;
    // ������ ����(�Ա�, ���, ������ü, �ܾ���ȸ)
    private int commandValue;
    // �������� ����� � ���� ���� ���θ� status�� ����
    // ���� : 1
    // ���� : 0
    private int status;

    public Command(int comm) {
        commandValue = comm;
        status = -1;
    }

    public int getCommandValue() {
        return commandValue;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] params) {
        args = params;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int setStatus) {
        status = setStatus;
    }

    public Bank getBank() {
        return mBank;
    }

    // �ǽ��� ���Ͽ� ��ü��°�� �̵�
    public void setBank(Bank b) {
        mBank = b;
    }
}
