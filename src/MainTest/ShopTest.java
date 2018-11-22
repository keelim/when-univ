package MainTest;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShopTest extends JFrame {
	private int Middle_Money;
	private JTextField textField;

	public ShopTest() {
		setTitle("ShopTest");
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 10, 178, 341);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(202, 330, 170, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		// 상점 메뉴는 멀티 쓰레드를 위한 공간

	}
}
