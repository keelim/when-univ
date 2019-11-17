package Cotroller.login;

import Cotroller.admin.AdminActivity;
import Cotroller.main.MainActivity;

import javax.swing.*;

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
            JOptionPane.showMessageDialog(null, "로그안에 실패하였습니다. 다시 시도 하시기 바랍니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
            setVisible(true);
            new MainActivity();
            new AdminActivity();
        });
        signOut.addActionListener(e -> {
            new SignUpActivity();
            setVisible(false);
        });
        pack(); //반드시 있어야 한다.
        setVisible(true); // 반드시 있어야 한다.
    }

    public static Login getInstance(){
        if (instance==null){
            return new Login();
        } else{
            return instance;
        }
    }
}
