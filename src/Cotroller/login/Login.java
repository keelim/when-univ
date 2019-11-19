package Cotroller.login;

import Cotroller.admin.AdminActivity;
import Cotroller.main.MainActivity;

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
            setVisible(false);
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
    }

    private void login() {
        int status = loginChecking();
        if (status == 0) {
            JOptionPane.showMessageDialog(null, "사용자로 로그인을 합니다.", "로그인", JOptionPane.WARNING_MESSAGE);
            new MainActivity();
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "관리자로 로그인을 합니다.", "로그인", JOptionPane.WARNING_MESSAGE);
            new AdminActivity();
            setVisible(false);
        }
    }

    private int loginChecking() { // 0이면 일반 사용자 1이면 관리자 모드
        sql_id_checking();
        if (id_field.getText().equals("1")) {
            return 1;
        }
        return 0;
    }

    private void sql_id_checking() { //0 user, 1 admin
        //관리자 인지 일반 사용자인지 확인을 하는 메소드

    }

    public static Login getInstance() {
        if (instance == null) {
            return new Login();
        } else {
            return instance;
        }
    }
}
