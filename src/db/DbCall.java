package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import static java.lang.String.valueOf;

public final class DbCall {
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    private static String sql = null;
    private static DBConnectionMgr pool = DBConnectionMgr.getInstance();


    public ArrayList<Object> dbConnection() {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            con = pool.getConnection();
            sql = "select * from book";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 패스워드를 읽어온다.
                arrayList.add(rs.getInt("book_isbn"));
                arrayList.add(rs.getString("book_title"));
                arrayList.add(rs.getString("book_author"));
                arrayList.add(rs.getString("book_publisher"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return arrayList; //결과값 리터
    }

    public static boolean findId(String pId) {
        boolean flag = false;
        Vector<String> id = new Vector<>();
        System.out.println(pId);

        try {
            con = pool.getConnection();
            sql = "select id from user";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                // 패스워드를 읽어온다.
                id.add(rs.getString("id"));
            }
            System.out.println(pId);
            System.out.println(id);
            for (int i = 0; i < id.size(); i++) {
                flag = pId.equals(id.get(i));
                if (flag)
                    break;
            }
            System.out.println("결과" + flag);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return flag; //결과값 리터

    }

    public static int adminChecking(String text) {
        int status = -1;
        try {
            con = pool.getConnection();
            sql = "select library.user.user_grant from user where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, text);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 패스워드를 읽어온다.
                status = rs.getInt("user_grant");
            }
            System.out.println(status);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return status;
    }


    public static String[][] getReturnBookList() {
        String[][] string = null;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            con = pool.getConnection();
            sql = "select * from library.return";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                temp.add(new String[]{valueOf(rs.getInt(2)), rs.getString(3)});
            }
            string = new String[temp.size()][2];
            for (int j = 0; j < temp.size(); j++) {
                System.arraycopy(temp.get(j), 0, string[j], 0, 2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return string;
    }

    public static String[][] getUserList() {
        String[][] string = null;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            con = pool.getConnection();
            sql = "select * from library.user";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                temp.add(new String[]{rs.getString(1), convertI(rs.getInt(3)), rs.getString(4), rs.getString(5), convertI(rs.getInt(6)), convertI(rs.getInt(8))});
            }
            string = new String[temp.size()][6];
            for (int j = 0; j < temp.size(); j++) {
                for (int k = 0; k < 6; k++) {
                    string[j][k] = temp.get(j)[k];
                }
                System.arraycopy(temp.get(j), 0, string[j], 0, 2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return string;

    }

    public static String[][] getBookList() {
        String[][] string = null;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            con = pool.getConnection();
            sql = "select * from library.book";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                temp.add(new String[]{convertI(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), convertI(rs.getInt(6))});
            }
            string = new String[temp.size()][5];
            for (int j = 0; j < temp.size(); j++) {
                for (int k = 0; k < 5; k++) {
                    string[j][k] = temp.get(j)[k];
                }
                System.arraycopy(temp.get(j), 0, string[j], 0, 2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return string;

    }

    public static String[][] getUserBookList(String ing_id) {
        String[][] string = null;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            con = pool.getConnection();
            sql = "select book_num, book_title, book_author, book_publisher, book_isbn from library.book, library.user where library.user.id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ing_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                temp.add(new String[]{convertI(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), convertI(rs.getInt(5))});
            }
            System.out.println(temp);
            string = new String[temp.size()][5];
            for (int j = 0; j < temp.size(); j++) {
                for (int k = 0; k < 5; k++) {
                    string[j][k] = temp.get(j)[k];
                }
                System.arraycopy(temp.get(j), 0, string[j], 0, 2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return string;

    }

    public static String[][] getBorrowBookList() {
        String[][] string = null;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            con = pool.getConnection();
            sql = "select * from library.borrow";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                temp.add(new String[]{convertI(rs.getInt(1)), convertI(rs.getInt(2)), rs.getString(3), convertD(rs.getDate(4)), convertD(rs.getDate(5))});
            }
            string = new String[temp.size()][5];
            for (int j = 0; j < temp.size(); j++) {
                for (int k = 0; k < 5; k++) {
                    string[j][k] = temp.get(j)[k];
                }
                System.arraycopy(temp.get(j), 0, string[j], 0, 2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return string;

    }

    public static boolean insertBookInformation(ArrayList<String> arrayList) {

        try {
            con = pool.getConnection();
            sql = "insert into library.book values (default , ?, ?, ?, 0, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, arrayList.get(0));
            pstmt.setString(2, arrayList.get(1));
            pstmt.setString(3, arrayList.get(2));
            pstmt.setInt(4, Integer.parseInt(arrayList.get(3)));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static boolean userWithdrawal() {
        return false;

    }

    public static boolean signUpUser(ArrayList<String> information) {
        String id = information.get(0);
        String pw = information.get(1);
        String status = information.get(2);
        int status_handler;
        String name = information.get(3);
        String email = information.get(4);
        String tel = information.get(5);

        if (status.equals("학부")) {
            status_handler = 0;
        } else if (status.equals("대학원")) {
            status_handler = 1;
        } else {
            status_handler = 2;
        }

        try {
            con = pool.getConnection();
            sql = "insert into library.user values (?, ?, ?, ?, ?, ?, ?, ? )";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            pstmt.setInt(3, status_handler);
            pstmt.setString(4, name);
            pstmt.setString(5, email);
            pstmt.setInt(6, Integer.parseInt(tel));
            pstmt.setInt(7, 0);
            pstmt.setInt(8, 0);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static boolean deleteReturnBookList(ArrayList<String> arrayList) {
        int book_num = Integer.parseInt(arrayList.get(0));
        String user_id = arrayList.get(1);
        System.out.println("삭제를 하는게 맞나?" + arrayList);
        try {
            con = pool.getConnection();
            sql = "delete from library.return where return_book_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, book_num);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    private static String convertI(int s) {
        return valueOf(s);
    }

    private static String convertD(Date d) {
        return d.toString();
    }

}
