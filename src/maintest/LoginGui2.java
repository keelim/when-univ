package maintest;
// 기보 로그인 관련

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginGui2 extends JFrame implements ActionListener {
    private JTextField loginField;
    private JPasswordField passwordField;
    private User user = User.getInstance(); // 유저 인스턴스에 저장을 한다.

    //	서버 체크하기
    public LoginGui2() {

        setTitle("로그인 화면");
        setSize(450, 200);
        getContentPane().setLayout(null);

        loginField = new JTextField();
        loginField.setBounds(188, 53, 116, 21);
        getContentPane().add(loginField);
        loginField.setColumns(10);
        passwordField = new JPasswordField();
        passwordField.setBounds(188, 84, 116, 21);
        passwordField.addActionListener(this);
        getContentPane().add(passwordField);

        JLabel labelID = new JLabel("ID");
        labelID.setBounds(68, 56, 57, 15);
        getContentPane().add(labelID);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds(68, 87, 57, 15);
        getContentPane().add(labelPassword);

        JButton SigninButton = new JButton("Sign in");
        SigninButton.setBounds(316, 53, 85, 21);
        SigninButton.addActionListener(this);
        getContentPane().add(SigninButton);

        JButton Signupbutton = new JButton("Sign up");
        Signupbutton.addActionListener(e -> new MemberGui());
        Signupbutton.setBounds(316, 83, 85, 21);
        getContentPane().add(Signupbutton);
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws IOException {
        LoginGui2 m = new LoginGui2();
    }


    @Override
    public void actionPerformed(ActionEvent e) { // 유저 객체에 저장을 한다.
        String id = loginField.getText();
        char[] pass = passwordField.getPassword();
        String password = new String(pass);

        if (id.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "비어있습니다.");

        } else {

            boolean existLogin = Login.loginTest(id, password);
            if (existLogin) {

                user.setID(id);
                user.setGameMoney(Login.getMoney(id));
                user.setWin(Login.getWin(id));
                user.setLevel(Login.getlevel(id));

                setVisible(false);
                new MainFrame();

            } else {
                // 로그인 실패일 경우
                JOptionPane.showMessageDialog(null, "로그인 실패");
                loginField.setText(""); // 로그인 실패시 --> 모든 칸 빈칸으로
                passwordField.setText("");
            }
        }
    }

}
