package MainTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AssetTest.DBConnectionMgr;

public class Login {
//    public static void main(String[] args) {
//         
//        boolean test = loginTest("test", "1234");
//         
//        System.out.println("로그인 결과 :"+test);
//    }

	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private static String sql = null;

	public static boolean loginTest(String ID, String PW) {
		boolean flag = false;
		String getPass = null;

		DBConnectionMgr pool = DBConnectionMgr.getInstance();

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
					System.out.println("받아온 비밀번호 :" + getPass);
					flag = true;
				}
			}

		} catch (Exception e) {
			// 원래 예외처리는 크게 잡으면 안되고, 따로 처리가 되어야 합니다.
			e.printStackTrace();

		} finally {

			// 자원반납
			pool.freeConnection(con, pstmt, rs);
		}

		// 결과값 반납
		return flag;
	}

	public static int getMoney(String ID) {
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
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
}