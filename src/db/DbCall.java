package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class DbCall { // static 으로 작성을 해야 하나?
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    private static String sql = null;
    private static DBConnectionMgr pool;

    public DbCall() {
        pool = DBConnectionMgr.getInstance();
    }

//    public boolean call() {
//        boolean flag = false;
//        String getPass;
//
//
//        try {
//            con = pool.getConnection();
//            sql = "select PW from user where ID=?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, ID);
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//                // 패스워드를 읽어온다.
//                getPass = rs.getString("PW");
//                // 데이터베이스에서 읽어온 문자열과 사용자가 입력한 비밀번호가 같을 경우에는
//                if (getPass.equals(PW)) {
////					System.out.println("받아온 비밀번호 :" + getPass); --> 비밀 번호를 확인을 하는 핸들러
//                    flag = true;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 자원반납
//            pool.freeConnection(con, pstmt, rs);
//        }
//        return flag; //결과값 리터
//    }

    public static boolean loginValidate() {
        return false;
    }

    public static String[][] getUser() { //null은 절대 나오면 안된다.

        return null;
    }

    public static String[][] getBookList() {
        return null;
    }

    public static String[][] getBookList23() {
        return null;
    }

    public static void deleteBook() {

    }

    public static String[][] bookReturningList() {
        return null;
    }

    public static String[][] getUserList(){
        return null;
    }

    public static void modifyUserInformation(){

    }

    public static boolean userWithdrawal(){
        return false;
    }

    public static String[][] monthBookList(){
        return null;
    }

    public static boolean signUpUser(){
        return false;
    }

    public static boolean findId(){
        return false;
    }

}
