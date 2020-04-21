package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import static java.lang.String.valueOf;

public final class DbCall {
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    private static String sql = null;
    private static final DBConnectionMgr pool = DBConnectionMgr.getInstance();


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
            for (String s : id) {
                flag = pId.equals(s);
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
                System.arraycopy(temp.get(j), 0, string[j], 0, 6);
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
                System.arraycopy(temp.get(j), 0, string[j], 0, 5);
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
//            String[] a = {"도서번호", "도서이름", "도서저자", "도서출판사", "도서 isbn"}; 대출일자와 반납 일자 도 있어야 한다.
            sql = "select * from library.borrow inner join library.book on borrow.borrow_book_num = book.book_num where borrow_user_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ing_id);
            System.out.println("쿼리에 들어가는 아이디" + ing_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                temp.add(new String[]{convertI(rs.getInt("book_num")), rs.getString("book_title"), rs.getString("book_author"), rs.getString("book_publisher"), convertI(rs.getInt("book_isbn")), convertD(rs.getDate("borrow_date")), convertD(rs.getDate("borrow_return_date"))});
            }
            System.out.println(temp);
            string = new String[temp.size()][7];
            for (int j = 0; j < temp.size(); j++) {
                System.arraycopy(temp.get(j), 0, string[j], 0, 7);
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
//        {"id", "회원이름", "회원 대출 건수"}
        String[][] string;
        ArrayList<String[]> temp = new ArrayList<>();
        try {
            con = pool.getConnection();
            sql = "select * from library.user order by booknumbermonth desc";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                temp.add(new String[]{rs.getString("id"), rs.getString("user_name"), convertI(rs.getInt("booknumbermonth"))});
            }
            string = new String[temp.size()][3];
            for (int j = 0; j < temp.size(); j++) {
                System.arraycopy(temp.get(j), 0, string[j], 0, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

    public static boolean userWithdrawal(String ing_id) {
        boolean flag = false;
        try {
            con = pool.getConnection();
            sql = "delete from library.user where library.user.id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ing_id);
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static boolean signUpUser(ArrayList<String> information) {
        String id = information.get(0);
        String pw = information.get(1);
        String status = information.get(2);
        String name = information.get(3);
        String email = information.get(4);
        String tel = information.get(5);

        System.out.println("학부? 대학원? " +status);
        int status_handler;
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

    public static boolean deleteBook(ArrayList<String> arrayList) {
        int book_num = Integer.parseInt(arrayList.get(0));
        System.out.println("책을 삭제 합니다." + arrayList);
        try {
            con = pool.getConnection();
            sql = "delete from library.book where book_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, book_num);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static boolean deleteUser(ArrayList<String> arrayList) {
        String user_id = arrayList.get(0);
        System.out.println("회원을 삭제 합니다. " + arrayList);
//        if() //관리자 인지 체크를 할 것
        try {
            con = pool.getConnection();
            sql = "delete from library.user where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;

    }

    public static boolean returnBooKRequest(ArrayList<String> arrayList, String ing_id) {
        try {
            con = pool.getConnection();
            sql = "insert into library.return values (default ,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(arrayList.get(0)));
            pstmt.setString(2, ing_id);
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

    public static boolean modifyBook(ArrayList<String> arrayList, String book_id) {
        String book_title = arrayList.get(0);
        String book_author = arrayList.get(1);
        String book_publisher = arrayList.get(2);
        String book_isbn = arrayList.get(3);
        System.out.println("도서 정보를 업데이트 합니다." + arrayList);
        try {
            con = pool.getConnection();
            sql = "update library.book set book_title=?, book_author=?, book_publisher=?, book_isbn=? where book_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, book_title);
            pstmt.setString(2, book_author);
            pstmt.setString(3, book_publisher);
            pstmt.setInt(4, Integer.parseInt(book_isbn));
            pstmt.setInt(5, Integer.parseInt(book_id));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static boolean modifyUser(ArrayList<String> arrayList, String user_id) {
        int user_status = Integer.parseInt(arrayList.get(0));
        String user_name = arrayList.get(1);
        String user_email = arrayList.get(2);
        int user_tel = Integer.parseInt(arrayList.get(3));
        System.out.println("도서 정보를 업데이트 합니다." + arrayList);
        try {
            con = pool.getConnection();
            sql = "update library.user set user_status=?, user_name=?, email=?, tel=? where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_status);
            pstmt.setString(2, user_name);
            pstmt.setString(3, user_email);
            pstmt.setInt(4, user_tel);
            pstmt.setString(5, user_id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;

    }

    public static boolean passwdChecking(String password) {
        boolean flag = false;
        try {
            con = pool.getConnection();
            sql = "select library.user.user_pw from user where library.user.user_pw=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                flag = password.equals(rs.getString("user_pw"));
            }
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return flag;

    }

    public static ArrayList<String> getUserInfo(String id) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            con = pool.getConnection();
            sql = "select user_name, email, tel from library.user where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                arrayList.add(rs.getString("user_name"));
                arrayList.add(rs.getString("email"));
                arrayList.add(String.valueOf(rs.getInt("tel")));
            }
            System.out.println("아무것도 안들어 있는 건가?" + arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return arrayList; //결과값 리터
    }

    public static boolean modifyUserInformation(ArrayList<String> arrayList, String id) {
        String user_name = arrayList.get(0);
        String email = arrayList.get(1);
        int tel = Integer.parseInt(arrayList.get(2));
        try {
            con = pool.getConnection();
            sql = "update library.user set user_name=?, email=?, tel=? where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_name);
            pstmt.setString(2, email);
            pstmt.setInt(3, tel);
            pstmt.setString(4, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static String[][] titleSearch(String keyword) {
        String[][] title;
        ArrayList<String[]> temp = new ArrayList<>();
        keyword = "%" + keyword + "%";
        try {
            con = pool.getConnection();
            sql = "select * from library.book where book_title like ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, keyword);
            rs = pstmt.executeQuery();
//          "도서번호"  "도서제목", "도서저자", "도서출판사", "도서ISBN", "도서 상태_book_grant
            while (rs.next()) {
                temp.add(new String[]{String.valueOf(rs.getInt("book_num")), rs.getString("book_title"), rs.getString("book_author"), rs.getString("book_publisher"), convertI(rs.getInt("book_isbn")), convertBookGrant(rs.getInt("book_grant"))});
            }
            title = new String[temp.size()][6];
            for (int j = 0; j < temp.size(); j++) {
                System.arraycopy(temp.get(j), 0, title[j], 0, 6);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        System.out.println(Arrays.toString(title[0]));
        return title;
    }

    public static String[][] isbnSearch(String keyword) {
        String[][] isbn;
        ArrayList<String[]> temp = new ArrayList<>();
        keyword = "%" + keyword + "%";
        try {
            con = pool.getConnection();
            sql = "select * from library.book where book_isbn like ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, keyword);
            rs = pstmt.executeQuery();
//           "도서번호" "도서제목", "도서저자", "도서출판사", "도서ISBN"
            while (rs.next()) {
                temp.add(new String[]{String.valueOf(rs.getInt("book_num")), rs.getString("book_title"), rs.getString("book_author"), rs.getString("book_publisher"), convertI(rs.getInt("book_isbn")), convertBookGrant(rs.getInt("book_grant"))});
            }
            isbn = new String[temp.size()][6];
            for (int j = 0; j < temp.size(); j++) {
                System.arraycopy(temp.get(j), 0, isbn[j], 0, 6);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        System.out.println(Arrays.toString(isbn[0]));
        return isbn;

    }

    public static boolean borrowChecking(ArrayList<String> arrayList) {
        boolean flag = false;
        try {
            con = pool.getConnection();
            sql = "select * from library.book where book_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(arrayList.get(0)));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt("book_grant") == 0)
                    flag = true; // 대출이 가능하다. 1이면 대출 불가
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return flag;

    }

    public static boolean reserve(ArrayList<String> arrayList, String ing_id) {
        //"도서번호", "도서제목", "도서저자", "도서출판사", "도서ISBN"
        // num id num  date line // 예약 순서 --> default
        try {
            con = pool.getConnection();
            sql = "insert into library.reserve values (default, ?, ?, ?, default)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ing_id);
            pstmt.setInt(2, Integer.parseInt(arrayList.get(0)));
            pstmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static boolean borrowBook(ArrayList<String> arrayList, String ing_id) {
//        "도서번호", "도서제목", "도서저자", "도서출판사", "도서ISBN"
        try {
            con = pool.getConnection();
            sql = "insert into library.borrow values (default , ?,?,?,default)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(arrayList.get(0)));
            pstmt.setString(2, ing_id);
            LocalDate today = java.time.LocalDate.now();
            pstmt.setDate(3, java.sql.Date.valueOf(today));
//            pstmt.setDate(4, null); todo 회원 구분을 통하여 반납 날짜 확인 하기
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static boolean bookStateChange(ArrayList<String> arrayList) {
//        "도서번호", "도서제목", "도서저자", "도서출판사", "도서ISBN"
        try {
            con = pool.getConnection();
            sql = "update library.book set book_grant=? where book_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(2, arrayList.get(0));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;

    }

    public static boolean deleteBorrow(ArrayList<String> arrayList, String ing_id) {
        boolean flag = false;
        try {
            con = pool.getConnection();
            //"도서번호", "도서이름", "도서저자", "도서출판사", "도서 isbn"};
            sql = "delete from library.borrow where library.borrow.borrow_user_id=? and library.borrow.borrow_book_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ing_id);
            pstmt.setInt(2, Integer.parseInt(arrayList.get(0)));
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;

    }

    public static boolean grantZero(ArrayList<String> arrayList) {
        try {
            con = pool.getConnection();
            //"도서번호", "도서이름", "도서저자", "도서출판사", "도서 isbn"};
            sql = "update library.book set book_grant = 0 where book_num=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(arrayList.get(0)));
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


    public static int getUserStatus(String ing_id) {
        int status = 0; //1 학부, 2. 대학원 3. 교직원
        try {
            con = pool.getConnection();
            sql = "select library.user.user_status from library.user where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ing_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 패스워드를 읽어온다.
                status = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return status;
    }

    public static boolean bookReturnDate(int status, ArrayList<String> arrayList) {
        //        "도서번호", "도서제목", "도서저자", "도서출판사", "도서ISBN"
        try {
            con = pool.getConnection();
            sql = "update library.borrow set borrow_return_date = ? where borrow_book_num=?";
            pstmt = con.prepareStatement(sql);
            LocalDate day = java.time.LocalDate.now();
            switch (status) {
                case 1:
                    day = day.plusDays(10);
                    break;
                case 2:
                    day = day.plusDays(30);
                    break;
                case 3:
                    day = day.plusDays(60);
                    break;
            }
            pstmt.setDate(1, Date.valueOf(day));
            pstmt.setString(2, arrayList.get(0));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        return true;
    }

    public static String[][] borrowUser() {
        String[][] borrowUserInformation;
        ArrayList<String[]> temp = new ArrayList<>();
//        String[] a = {"id", "도서번호", "대출날짜", "반납날짜"};
        try {
            con = pool.getConnection();
            sql = "select * from library.borrow inner join library.user on borrow.borrow_user_id = id";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                temp.add(new String[]{rs.getString("borrow_user_id"), convertI(rs.getInt("borrow_book_num")), convertD(rs.getDate("borrow_date")), convertD(rs.getDate("borrow_return_date"))});
            }
            borrowUserInformation = new String[temp.size()][4];
            for (int j = 0; j < temp.size(); j++) {
                System.arraycopy(temp.get(j), 0, borrowUserInformation[j], 0, 4);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        System.out.println("잘 설정됨");
        return borrowUserInformation;
    }

    public static boolean reserveCancel(ArrayList<String> arrayList) {
//        "예약 도서번호", "예약 날짜"
        try {
            con = pool.getConnection();
            sql = "delete from library.reserve where reserve_book_num = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(arrayList.get(0))); //선택을 하면 삭제를 한다.
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

    public static String[][] getReserveBookList() {
        String[][] reserveBookList;
        ArrayList<String[]> temp = new ArrayList<>();
// {"예약 도서번호", "예약 날짜"};
        try {
            con = pool.getConnection();
            sql = "select * from library.reserve";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                temp.add(new String[]{rs.getString("reserve_book_num"), convertD(rs.getDate("reserve_date"))});
            }
            reserveBookList = new String[temp.size()][2];
            for (int j = 0; j < temp.size(); j++) {
                System.arraycopy(temp.get(j), 0, reserveBookList[j], 0, 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 자원반납
            pool.freeConnection(con, pstmt, rs);
        }
        System.out.println("잘 설정됨");
        return reserveBookList;
    }

    private static String convertI(int s) {
        return valueOf(s);
    }

    private static String convertBookGrant(int s) {
        if (s == 1) {
            return "대출중";
        } else
            return "대출 가능";
    }

    private static String convertD(Date d) {
        if (d == null) {
            return "";
        }
        return d.toString();
    }

}
