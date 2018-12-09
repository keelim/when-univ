package ServerTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class DBload {
    private final String DRIVER = "org.gjt.mm.mysql.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/comp2";
    private final String USER = "root"; //DB ID
    private final String PASS = "kimjaehyun"; //DB 패스워드

    //237 레포윈 //1111 winplus




    public Connection getConnnection() { //DB 접속
        Connection con = null;

        try {
            Class.forName(DRIVER); //1. 드라이버 로딩
            con = DriverManager.getConnection(URL, USER, PASS); //2. 드라이버 연결

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }



    public boolean pluswin(String id) { /*회원 정보를 수정을 하는 메소드*/ // id를 가치 보내야 한다.
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnnection();
            String sql = "update  user set win=win+1 where ID=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            int r = ps.executeUpdate(); //실행 -> 수정
            // 1~n: 성공 , 0 : 실패
            if (r > 0) ok = true; //수정이 성공되면 ok값을 true로 변경
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public int win(String id) { /*회원 정보를 수정을 하는 메소드*/ // id를 가치 보내야 한다.
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int win = 0;
        try {
            con = getConnnection();
            String sql = "select * from user where ID = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            win = rs.getInt("win");
            int r = ps.executeUpdate(); //실행 -> 수정
            // 1~n: 성공 , 0 : 실패
            if (r > 0) ok = true; //수정이 성공되면 ok값을 true로 변경
        } catch (Exception e) {
            e.printStackTrace();
        }

        return win;
    }

    public int point(String id) { /*회원 정보를 수정을 하는 메소드*/ // id를 가치 보내야 한다.
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int point = 0;
        try {
            con = getConnnection();
            String sql = "select * from user where ID = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);

            int r = ps.executeUpdate(); //실행 -> 수정
            point = rs.getInt("GameMoney");
            // 1~n: 성공 , 0 : 실패
            if (r > 0) ok = true; //수정이 성공되면 ok값을 true로 변경
        } catch (Exception e) {
            e.printStackTrace();
        }

        return point;
    }

    public int level(String id) { /*회원 정보를 수정을 하는 메소드*/ // id를 가치 보내야 한다.
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int level = 0;
        try {
            con = getConnnection();
            String sql = "select * from user where ID = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            int r = ps.executeUpdate(); //실행 -> 수정
            // 1~n: 성공 , 0 : 실패
            level = rs.getInt("level");
            if (r > 0) ok = true; //수정이 성공되면 ok값을 true로 변경
        } catch (Exception e) {
            e.printStackTrace();
        }

        return level;
    }


}






