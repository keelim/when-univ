package MainTest; // 관리자용 건들지 말 것

public class MemberSave {
    private String ID;
    private String PW;
    private int GameMoney;
    private int level;
    private int win;

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getPW() {
        return PW;
    }
    public void setPW(String PW) {
        this.PW = PW;
    }
    public int getGameMoney() {
        return GameMoney;
    }
    public void setGameMoney(int gameMoney) {
        this.GameMoney = gameMoney;
    }
    public void setLevel(int level){this.level = level;}
    public void setWin(int win){this.win = win;}

    @Override
    public String toString() {
        return "ServerMemberSave [ID=" + ID + ", PW=" + PW + ", GameMoney=" + GameMoney
                + ", level=" + level + ", win= "+ win+ "]";
    }
    public int getLevel() {
        return level;
    }
}