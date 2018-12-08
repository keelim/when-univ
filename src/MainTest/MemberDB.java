package MainTest; //DB로 직접적인 접근을 하는 것이다. --> 서버를 통해서 DB를 접근을 하고 인증을 하는 것이 더 낫지 않을까?

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

//DB 처리
public class MemberDB {
    private static final String USER = "root"; //DB ID
    private static final String PASS = "kimjaehyun"; //DB 패스워드
    static DBConnectionMgr pool = DBConnectionMgr.getInstance();
    private static final String DRIVER = pool._driver;//"org.gjt.mm.mysql.Driver"
    private static final String URL = pool._url;//"jdbc:mysql://localhost:3306/comp2";
    Member_List mList;

    public MemberDB(Member_List mList) {
        this.mList = mList;
        System.out.println("DB=>" + mList);
    }

    public MemberDB() {

    }

    // DB 연결
    public Connection getConn() {
        Connection con = null;

        try {
            Class.forName(DRIVER); //1. 드라이버 로딩
            con = DriverManager.getConnection(URL, USER, PASS); //2. 드라이버 연결

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }


    //회원 정보를 얻어온다.
    public MemberSave getMemberDB(String id) {
        MemberSave save = new MemberSave();
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과

        try {
            con = getConn();
            String sql = "select * from user where ID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                save.setID(rs.getString("ID"));
                save.setPW(rs.getString("PW"));
                save.setGameMoney(rs.getInt("GameMoney"));
                save.setLevel(rs.getInt("level"));
                save.setWin(rs.getInt("win"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return save;
    }

    /**
     * 멤버리스트 출력
     */
    public Vector getMemberList() {
        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
        Connection con;       //연결
        PreparedStatement ps; //명령
        ResultSet rs;         //결과
        try {
            con = getConn();
            String sql = "select * from user order by ID asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String pwd = rs.getString("PW");
                int gameMoney = rs.getInt("GameMoney");
                int level = rs.getInt("level");
                int win = rs.getInt("win");
                Vector row = new Vector();
                row.add(id);
                row.add(pwd);
                row.add(gameMoney);
                row.add(level);
                row.add(win);
                data.add(row);
            }//while
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }//getMemberList()


    /**
     * 회원 등록
     */
    public boolean insertMember(MemberSave save) {
        boolean flag = false;
        Connection con;       //연결
        PreparedStatement ps; //명령

        try {
            con = getConn();
            String sql = "insert into user(" +
                    "ID,PW,GameMoney,level, win) " +
                    "values(?,?,?,?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, save.getID());
            ps.setString(2, save.getPW());
            ps.setInt(3, 0);
            ps.setInt(4, 1);
            ps.setInt(5, 0);

            int r = ps.executeUpdate(); //실행 -> 저장

            if (r > 0) {
                System.out.println("가입 성공");
                flag = true;
            } else {
                System.out.println("가입 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }//


    // 회원 정보 수정
    public boolean updateMember(MemberSave vMem) { // 회원 승수를 올려주는 메소드
        System.out.println("dto=" + vMem.toString());
        boolean ok = false;
        Connection con;
        PreparedStatement ps;
        String id = vMem.getID();
        System.out.println(id);
        try {
            con = getConn();
            String sql = "update user set win=win+1 WHERE ID = ?";
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

    /**
     * 회원정보 삭제 :
     * tip: 실무에서는 회원정보를 Delete 하지 않고 탈퇴여부만 체크한다.
     */
    public boolean deleteMember(String id, String pwd) {
        boolean ok = false;
        Connection con;
        PreparedStatement ps;

        try {
            con = getConn();
            String sql = "delete from user where ID=? and PW=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);
            int r = ps.executeUpdate(); // 실행 -> 삭제

            if (r > 0) ok = true; //삭제됨;
        } catch (Exception e) {
            System.out.println(e + "-> 오류발생");
        }
        return ok;
    }


    /**
     * DB데이터 다시 불러오기
     */
    public void userSelectAll(DefaultTableModel model) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConn();
            String sql = "select * from user order by ID asc ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // DefaultTableModel에 있는 데이터 지우기
            for (int i = 0; i < model.getRowCount(); ) {
                model.removeRow(0);
            }
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getInt(4)};
                model.addRow(data);
            }

        } catch (SQLException e) {
            System.out.println(e + "=> userSelectAll fail");
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}