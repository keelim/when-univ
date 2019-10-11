<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>

<%@ page import="java.sql.*" %>

<% request.setCharacterEncoding("euc-kr"); %>

<%
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    try {
        String jdbcUrl = "jdbc:mysql://localhost:3306/jspdatabase";
        String dbId = "root";
        String dbPass = "1234";

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
        String sql = "select id, passwd from db_test.member where id=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, id);
        rs = psmt.executeQuery();

        if (rs.next()) {
            String rid = rs.getString("id");
            String rPasswd = rs.getString("passwd");
            if (id.equals(rid) && passwd.equals(rPasswd)) {
                sql = "delete from db_test.member where id =?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, id);
                psmt.executeUpdate();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>테이블의 레코드를 삭제했습니다.</title>
</head>
<body>

</body>
</html>

<%
            } else {
                out.println("패스워드가 틀렸습니다.");
            }
        } else {
            out.println("아이디가 틀렸습니다.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) try {
            rs.close();
        } catch (SQLException e) {
        }
        if (psmt != null) try {
            psmt.close();
        } catch (SQLException e) {
        }
        if (conn != null) try {
            conn.close();
        } catch (SQLException e) {
        }

    }
%>
