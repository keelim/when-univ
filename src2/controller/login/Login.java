package controller.login;

import controller.admin.AdminActivity;
import controller.View;
import controller.main.MainActivity;
import db.DbCall;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
    private static Login instance;
    private JPanel main_panel;
    private JTextField id_field;
    private JPasswordField pw_field;
    private JButton signIn;
    private JButton signOut;

    public Login() {
        setTitle("로그인 화면");
        setContentPane(main_panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        signIn.addActionListener(e -> {
            setVisible(true);
            login();
        });

        signOut.addActionListener(e -> {
            new SignUpActivity();
            setVisible(false);
        });

        pack(); //반드시 있어야 한다.
        setVisible(true); // 반드시 있어야 한다.
        id_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
        pw_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
    }

    private void login() {
        int status = loginChecking();
        boolean flag = passwdChecking();
        if (status == 0 && flag) {
            View.alert("사용자로 로그인을 합니다.");
            new MainActivity(id_field.getText());
            setVisible(false);
        } else if (status == 1 && flag) {
            View.alert("관리자로 로그인을 합니다.");
            new AdminActivity();
            setVisible(false);
        } else {
            View.alert("로그인에 실패하였습니다. 아이디 및 비밀번호를 다시 확인 해주세요!");
        }
    }

    private boolean passwdChecking() {
        return DbCall.passwdChecking(pw_field.getText());
    }

    private int loginChecking() { // 0이면 일반 사용자 1이면 관리자 모드
        return DbCall.adminChecking(id_field.getText());
    }

    public static Login getInstance() {
        if (instance == null) {
            return new Login();
        } else {
            return instance;
        }
    }
}
