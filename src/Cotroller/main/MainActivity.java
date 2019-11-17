package Cotroller.main;

import Cotroller.login.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainActivity extends JFrame {
    private JPanel main_panel;
    private JButton 회원정보Button;
    private JButton 도서예약Button;
    private JTable table1;
    private JButton 로그아웃Button;
    private JButton 도서반납Button;
    private JButton 도서검색Button;

    public MainActivity() {
        setContentPane(main_panel);
        setTitle("메인 화면");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        로그아웃Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "로그 아웃을 실행 합니다.", "로그 아웃", JOptionPane.WARNING_MESSAGE);
            dispose();
            Login.getInstance().setVisible(true);
        });
    }

}
