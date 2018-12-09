package MainTest.CommandTest;

public class Command { // 공통적으로 서버와 클라이언트가 통신을 하기 위한 클래스\
    public static final int WIN = 7777;  // win을 작용시킨다.
    public static final int POINT = 3333;  // 서버 상태를 확인한다.
    public static final int LEVEL = 2222; //레벨을 확인을 한다.
    public static final int PLUSWIN = 1111;


    private int commandValue; //어떤 한 명령이 들어오는지를 판단한다.
    private int status;
    private String[] args = null;


    private int win;
    private int point;
    private int level;

    // 명령 상수들
    // 1. 현재 접속 자 수를 확인을 하는 명령
    // 2. 승리를 추가하는 명령
    // 3. 특별하게 떠오르는 명령이 없다. --> 후에 추가를 하는 것이 현명할 것으로 판단

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


    public void setLevel(int level) {
        this.level = level;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getWin() {
        return win;
    }

    public int getPoint() {
        return point;
    }

    public int getLevel() {
        return level;
    }
}
