package Cotroller.login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpActivity extends JFrame {

    private JPanel panel1;
    private JTextField signup_id;
    private JTextField signup_passwd;
    private JTextField signup_name;
    private JTextField signup_email;
    private JTextField signup_tel;
    private JTextField signup_status;
    private JButton sugnup_upButton;
    private JButton ic_check;


    public JTextField getSignup_id() {
        return signup_id;
    }

    public JTextField getSignup_passwd() {
        return signup_passwd;
    }

    public JTextField getSignup_name() {
        return signup_name;
    }

    public JTextField getSignup_email() {
        return signup_email;
    }

    public JTextField getSignup_tel() {
        return signup_tel;
    }

    public JTextField getSignup_status() {
        return signup_status;
    }

    public SignUpActivity() {
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        sugnup_upButton.addActionListener(e -> {
            getInformation();
            dispose();
            Login.getInstance().setVisible(true);
        });
        pack();
        setVisible(true);
        ic_check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id_checking();
                JOptionPane.showMessageDialog(null, "아이디 확인 작업을 실행 합니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void getInformation() { //db 하나의 아이템으로 처리를 할 것
        getSignup_email();
        getSignup_id();
        getSignup_name();
        getSignup_passwd();
        getSignup_status();
        getSignup_tel();
    }

    private void id_checking() { //id checking 작업을 실행 합니다.
    }
}
