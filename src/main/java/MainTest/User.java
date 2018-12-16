package MainTest;

public class User {
    private static User instance = null;
    private String ID;
    private int GameMoney;
    private int level;
    private int win;

    public static User getInstance() {   //메모리에 있는 객체를 다른 클래스에서도 사용을 할 수 있게 하는 것
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    instance = new User();
                }
            }
        }
        return instance;
    }

    public int getGameMoney() {
        return GameMoney;
    }

    public void setGameMoney(int gameMoney) {
        GameMoney = gameMoney;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
