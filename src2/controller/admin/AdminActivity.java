package controller.admin;

import controller.View;
import controller.login.Login;

import javax.swing.*;

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
            new AdminBookManagement();
            setVisible(false);
        });
        BookReturnManagement.addActionListener(e -> {
            new AdminBookReturn();
            setVisible(false);
        });

        UserInformationManagement.addActionListener(e -> {
            new AdminUserManagement();
            setVisible(false);
        });
        로그아웃Button.addActionListener(e -> {
            dispose();
            View.alert("로그아웃을 실행 합니다.");
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

}
