package logintest;

import maintest.Login;
import maintest.User;
import maintest.ui.MainFrame;
import maintest.ui.MemberGui;
import maintest.ui.Member_List;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends JFrame implements ActionListener {
    private JTextField loginField;
    private JPasswordField passwordField;
    private User user = User.getInstance(); // 유저 인스턴스에 저장을 한다.

    //	서버 체크하기
    public LoginGui() {

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

        JButton signInButton = new JButton("Sign in");
        signInButton.setBounds(316, 53, 85, 21);
        signInButton.addActionListener(this);
        getContentPane().add(signInButton);

        JButton signUpButton = new JButton("Sign up");
        signUpButton.addActionListener(e -> new MemberGui());
        signUpButton.setBounds(316, 83, 85, 21);
        getContentPane().add(signUpButton);
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoginGui m = new LoginGui();
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
            if (existLogin) { // 로그인시 데이터 베이스에서 승리, 포인트, 레벨을 불러온다.
                // 로그인 성공일 경우
                user.setID(id);

                user.setGameMoney(Login.getMoney(id));

                user.setWin(Login.getWin(id));

                user.setLevel(Login.getLevel(id));
                if (id.equals("GM")) {
                    setVisible(false);
                    new Member_List();
                } else {
                    setVisible(false);
                    new MainFrame();
                }

            } else {
                // 로그인 실패일 경우
                JOptionPane.showMessageDialog(null, "로그인 실패");
                loginField.setText(""); // 로그인 실패시 --> 모든 칸 빈칸으로
                passwordField.setText("");
            }
        }
    }

}
