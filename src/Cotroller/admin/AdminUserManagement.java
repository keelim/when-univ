package Cotroller.admin;

import javax.swing.*;
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
        뒤로가기Button.addActionListener(e -> {
            AdminActivity.getInstance().setVisible(true);
            dispose();

        });
        pack();
        setVisible(true);
    }
}
