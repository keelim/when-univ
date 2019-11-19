package Cotroller.main;

import Cotroller.login.Login;
import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyConfiguration extends JFrame {
    private JPanel panel;
    private JTable table1;
    private JButton 회원정보수정Button;
    private JButton 회원탈퇴Button;
    private JButton 뒤로가기Button;


    public MyConfiguration() {
        setContentPane(panel);
        setTitle("설정 화면");
        initTable();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        pack();
        setVisible(true);
        뒤로가기Button.addActionListener(e -> {
            dispose();
            MainActivity.getInstance().setVisible(true);
        });
        회원탈퇴Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "회원 탈퇴 신청을 합니다.", "회원 탈퇴", JOptionPane.WARNING_MESSAGE);
            //회원 탈퇴를 신청을 합니다.
            boolean flag = DbCall.userWithdrawal();
            if (flag) {
                dispose();
                MainActivity.getInstance().dispose();
                Login.getInstance().setVisible(true);
                JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
            }
        });
        회원정보수정Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "회원 정보를 수정 합니다.", "회원 정보 수정", JOptionPane.WARNING_MESSAGE);
        });
    }

    private void initTable() { //초기 테이블을 작성을 한다.
        //현재 가지고 있는 것을 콜을 한다.
        String[] a = {"a", "b", "c", "d"};
        String[][] b = {{"a1", "a2", "a3", "sd"},
                {"b1", "b2", "b3", "sd"},
                {"c1", "c2", "c3", "sd"}};
        DefaultTableModel model = new DefaultTableModel(b, a) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        table1.updateUI();
    }

    public static void main(String[] args) {
        new MyConfiguration();
    }
}
