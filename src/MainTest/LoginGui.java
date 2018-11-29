package MainTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGui extends JFrame implements ActionListener {

	private JTextField loginField;
	private JPasswordField passwordField;
	private User user = User.getInstance();

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

		JButton SigninButton = new JButton("Sign in");
		SigninButton.setBounds(316, 53, 85, 52);
		SigninButton.addActionListener(this);
		getContentPane().add(SigninButton);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = loginField.getText();
		char[] pass = passwordField.getPassword();
		String password = new String(pass);

		if (id.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(null, "비어있습니다.");
			
		} else {
			
			boolean existLogin = Login.loginTest(id, password);
			if (existLogin) {
				// 로그인 성공일 경우
				user.setID(id);
				user.setGameMoney(Login.getMoney(id));
				JOptionPane.showMessageDialog(null, "로그인 성공");

				this.setVisible(false);
				if (id == "supertest") {
					new MainGui();
				} else {
					new Client();
					new ServerStatusGui();
					new MainGui();

				}
			} else {
				// 로그인 실패일 경우
				JOptionPane.showMessageDialog(null, "로그인 실패");
				loginField.setText(""); // 로그인 실패시 --> 모든 칸 빈칸으로
				passwordField.setText("");
			}
		}
	}

	public static void main(String[] args) {
		LoginGui m = new LoginGui();
	}

}
