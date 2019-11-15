package Cotroller.admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminActivity extends JFrame {
    private static AdminActivity instance;
    private JPanel admin_panel;
    private JButton 도서정보관리Button;
    private JButton 도서반납관리Button;
    private JButton 회원정보관리Button;

    public AdminActivity() {
        setContentPane(admin_panel);
        setTitle("관리자");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        도서정보관리Button.addActionListener(e -> {
            new AdminBookManagement();
            setVisible(false);
        });
        도서반납관리Button.addActionListener(e -> {
            new AdminReturnTheBook();
            setVisible(false);
        });

        회원정보관리Button.addActionListener(e -> {
            new AdminUserManagement();
            setVisible(false);
        });
    }

    public static AdminActivity getInstance(){
        if(instance==null){
            return new AdminActivity();
        } else{
            return instance;
        }
    }
}
