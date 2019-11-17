package Cotroller.admin;

import Cotroller.login.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminActivity extends JFrame {
    private static AdminActivity instance;
    private JPanel admin_panel;
    private JButton BookInformationManagement;
    private JButton BookReturnManagement;
    private JButton UserInformationManagement;
    private JButton 로그아웃Button;

    public AdminActivity() {
        setContentPane(admin_panel);
        setTitle("관리자 업무");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        BookInformationManagement.addActionListener(e -> {
            new AdminRankanagement();
            setVisible(false);
        });
        BookReturnManagement.addActionListener(e -> {
            new AdminReturnTheBook();
            setVisible(false);
        });

        UserInformationManagement.addActionListener(e -> {
            new AdminUserManagement();
            setVisible(false);
        });
        로그아웃Button.addActionListener(e -> {
            dispose();
            JOptionPane.showMessageDialog(null, "로그 아웃을 실행 합니다.", "로그 아웃", JOptionPane.WARNING_MESSAGE);
            Login.getInstance().setVisible(true);
        });
    }

    static AdminActivity getInstance(){
        if(instance==null){
            return new AdminActivity();
        } else{
            return instance;
        }
    }

    public static void main(String[] args) {
        new AdminActivity();
    }
}
