package maintest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    private static String sql = null;

    public static boolean loginTest(String ID, String PW) {
        boolean flag = false;
        String getPass;
        MainTest.DBConnectionMgr pool = MainTest.DBConnectionMgr.getInstance();

        try {
            con = pool.getConnection();
            sql = "select PW from user where ID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 패스워드를 읽어온다.
                getPass = rs.getString("PW");
                // 데이터베이스에서 읽어온 문자열과 사용자가 입력한 비밀번호가 같을 경우에는
                if (getPass.equals(PW)) {
//					System.out.println("받아온 비밀번호 :" + getPass); --> 비밀 번호를 확인을 하는 핸들러
                    flag = true;
                }
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return flag; //결과값 리터
    }

    public static int getMoney(String ID) {
        MainTest.DBConnectionMgr pool = MainTest.DBConnectionMgr.getInstance();
        int gMoney = 0;

        try {
            con = pool.getConnection();
            sql = "select GameMoney from user where ID=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                gMoney = rs.getInt("GameMoney");
            }
        } catch (Exception e) {
            // 원래 예외처리는 크게 잡으면 안되고, 따로 처리가 되어야 합니다.
            e.printStackTrace();

        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        // 결과값 반납
        return gMoney;
    }

    public static int getWin(String id) {
        MainTest.DBConnectionMgr pool = MainTest.DBConnectionMgr.getInstance();
        int win = 0;

        try {
            con = pool.getConnection();
            sql = "select win from user where ID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next())
                win = rs.getInt("win");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return win;
    }

    public static int getlevel(String id) {
        MainTest.DBConnectionMgr pool = MainTest.DBConnectionMgr.getInstance();
        int level = 0;

        try {
            con = pool.getConnection();
            sql = "select level from user where ID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next())
                level = rs.getInt("level");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return level;
    }
}