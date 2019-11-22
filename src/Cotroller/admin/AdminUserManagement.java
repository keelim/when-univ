package Cotroller.admin;

import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserManagement extends JFrame {
    private static AdminUserManagement instance;
    private JButton 회원정보수정Button;
    private JButton 회원탈퇴Button;
    private JButton 회원대출목록관리Button;
    private JTable table1;
    private JButton 뒤로가기Button;
    private JPanel userManagement_panel;


    public AdminUserManagement() {
        setContentPane(userManagement_panel);
        setTitle("회원 정보 관리");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initTable();

        뒤로가기Button.addActionListener(e -> {
            AdminActivity.getInstance().setVisible(true);
            dispose();

        });


        pack();
        setVisible(true);
        회원탈퇴Button.addActionListener(e -> {
            //확인이면 0 취소는 1
            int answer = JOptionPane.showConfirmDialog(null, "선택하신 회원을 삭제를 하시겠습니까?");
            if (answer == 0) {
                JOptionPane.showMessageDialog(null, "선택하신 회원을 삭제하겠습니다.");
            } else {

            }

        });
        회원정보수정Button.addActionListener(e -> {
            //회원 정보를 수정을 하는 이벤트 -> 새로운 창을 여는 것이 좋을 것 같다.
            setVisible(false);
            new AdminModifyUser();
        });
        회원대출목록관리Button.addActionListener(e -> {
            setVisible(false);
            new AdminBookList();
        });
    }

    private void initTable() { //초기 테이블을 작성을 한다.
        String[] a = {"회원아이디", "회원구분", "회원이름", "회원이메일", "회원전화번호", "월 책 대출 수"};
//        String[][] b = {{"a1", "a2", "a3", "sd"},
//                {"b1", "b2", "b3", "sd"},
//                {"c1", "c2", "c3", "sd"}};

        String b[][] = DbCall.getUserList();
        DefaultTableModel model = new DefaultTableModel(b, a) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        table1.updateUI();
    }

    public static AdminUserManagement getInstance() {
        if (instance == null) {
            return new AdminUserManagement();
        } else {
            return instance;
        }
    }
}
