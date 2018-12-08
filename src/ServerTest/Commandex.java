package ServerTest;

import java.io.Serializable;


//데이터들을 저장해서 네크워크를 통해서 이동 될 객체
public class Commandex implements Serializable {
    // Commandex list
    public static final int DEPOSIT = 10; // 입금
    public static final int WITHDRAW = 20; // 출금
    public static final int TRANSFER = 30; // 계좌이체
    public static final int GetBankInfo = 99; // 은행 정보 조회
    private static final long serialVersionUID = 1L;
    private Bank mBank = null;
    // 계좌번호, 금액 등의 스트링형 정보를 전달하는 변수
    private String[] args = null;
    // 정보의 종류(입금, 출금, 계좌이체, 잔액조회)
    private int commandValue;
    // 서버에서 입출금 등에 대한 성공 여부를 status에 저장
    // 성공 : 1
    // 실패 : 0
    private int status;

    public Commandex(int comm) {
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

    // 실습을 위하여 객체통째로 이동
    public void setBank(Bank b) {
        mBank = b;
    }
}
