package Cotroller.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserManagement extends JFrame {
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
    }

    private void initTable() { //초기 테이블을 작성을 한다.
        String[] a = {"a", "b", "c", "d"};
        String[][] b = {{"a1", "a2", "a3", "sd"},
                {"b1", "b2", "b3", "sd"},
                {"c1", "c2", "c3", "sd"}};
        DefaultTableModel model = new DefaultTableModel(b, a){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        table1.updateUI();
    }
}
