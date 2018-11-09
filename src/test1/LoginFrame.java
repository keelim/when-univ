package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	public LoginFrame() {
		setTitle("로그인 화면");
		setSize(450, 200);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(188, 53, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(188, 84, 116, 21);
		getContentPane().add(passwordField);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(68, 56, 57, 15);
		getContentPane().add(lblId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(68, 87, 57, 15);
		getContentPane().add(lblPassword);

		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setBounds(316, 53, 85, 52);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 자동 생성된 메소드 스텁
				MainFrame m = new MainFrame();
				setVisible(false);
			}
			
		});
		getContentPane().add(btnNewButton);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
