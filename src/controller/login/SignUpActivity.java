package controller.login;

import db.DbCall;

import javax.swing.*;
import java.util.ArrayList;

public class SignUpActivity extends JFrame {

    private JPanel panel1;
    private JTextField signup_id;
    private JTextField signup_passwd;
    private JTextField signup_name;
    private JTextField signup_email;
    private JTextField signup_tel;
    private JButton signUpButton;
    private JButton ic_check;
    private JButton 뒤로가기Button;
    private JComboBox comboBox1;


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


    public SignUpActivity() {
        setTitle("회원 가입");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        signUpButton.addActionListener(e -> {
            boolean flag = DbCall.signUpUser(getInformation());
            if (flag) {
                dispose();
                JOptionPane.showMessageDialog(null, "회원 가입이 완료되었습니다.", "회원가입 완료", JOptionPane.WARNING_MESSAGE);
                Login.getInstance().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "회원 가입이 실패되었습니다.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
            }
        });
        pack();
        setVisible(true);

        ic_check.addActionListener(e -> {
            String id = id_checking();
            id = id.trim();
            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "아이디확인", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null, "아이디 확인 작업을 실행 합니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
            boolean flag = DbCall.findId(id);

            System.out.println(flag);
            if (!flag) {
                JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다. ");
            } else {
                JOptionPane.showMessageDialog(null, "기존의 아이디가 존재를 합니다.  새로운 아이디를 입력을 해주세요");
                signup_id.setText("");
            }

        });
        뒤로가기Button.addActionListener(e -> {
            dispose();
            Login.getInstance().setVisible(true);
        });
    }

    private ArrayList<String> getInformation() { //db 하나의 아이템으로 처리를 할 것
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getSignup_id().getText());
        arrayList.add(getSignup_passwd().getText());
        arrayList.add((String) comboBox1.getSelectedItem());
        arrayList.add(getSignup_name().getText());
        arrayList.add(getSignup_email().getText());
        arrayList.add(getSignup_tel().getText());
        return arrayList;
    }

    private String id_checking() { //id checking 작업을 실행 합니다.
        //sql 관련 함수를 콜 하는 것이 좋을 것 같다.
        // 있으면 있다고 표시를 할 것
        String id = signup_id.getText();
        System.out.println(id);
        return id;
    }
}
