package command;

import java.io.Serializable;

public class Command implements Serializable { // 공통적으로 서버와 클라이언트가 통신을 하기 위한 클래스\
    private static final long serialVersionUID = 1L;

    public static final int WIN = 7777;  // win 을 작용시킨다.
    public static final int POINT = 3333;  // 서버 상태를 확인한다.
    public static final int LEVEL = 2222; //레벨을 확인을 한다.
    public static final int PLUS_WIN = 8888; // 윷놀이 하고 연관을 시키면 된다.
    public static final int PLUS_ID = 4444;

    private int commandValue; //어떤 한 명령이 들어오는지를 판단한다.
    private int status = 0;
    private String[] args = null;
    private int win;
    private int point;
    private int level;

    public Command(int comm) {
        commandValue = comm;
        status = -1; // 이러한 결과를 나타내는 변수
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

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
