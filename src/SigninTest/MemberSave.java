package SigninTest;

public class MemberSave {
   
   
    private String ID;
    private String PW;
    private int GameMoney;
    private int level;

    //이클립스팁 : Getter/Setter 만들기
    //             우클릭 -> source->Generate Getters And Setters-> [Select AlL] -> [OK]
   
   
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

    //DTO 객체 확인
    //이클립스팁 : toString() 자동생성: 우클릭 -> source -> Generate toString->[OK]
    @Override
    public String toString() {
        return "MemberSave [ID=" + ID + ", PW=" + PW + ", GameMoney=" + GameMoney
                + ", level=" + level + "]";
    }

    public int getLevel() {
        return level;
    }
}