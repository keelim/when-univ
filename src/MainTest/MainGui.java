package MainTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainGui extends JFrame {
	private Yut u;
	private ShopTest temp_shop;
	private User user = User.getInstance();
	public MainGui() {

		setTitle("메인화면");
		setSize(770, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 625, 342);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(29, 22, 53, 23);
		panel.add(btnNewButton);

		JButton button = new JButton("New button");
		button.setEnabled(false);
		button.setBounds(126, 22, 53, 23);
		panel.add(button);

		JButton button_1 = new JButton("New button");
		button_1.setEnabled(false);
		button_1.setBounds(222, 22, 53, 23);
		panel.add(button_1);

		JButton button_2 = new JButton("New button");
		button_2.setEnabled(false);
		button_2.setBounds(318, 22, 53, 23);
		panel.add(button_2);

		JButton button_3 = new JButton("New button");
		button_3.setEnabled(false);
		button_3.setBounds(414, 22, 53, 23);
		panel.add(button_3);

		JButton button_4 = new JButton("New button");
		button_4.setEnabled(false);
		button_4.setBounds(510, 22, 53, 23);
		panel.add(button_4);

		JButton button_5 = new JButton("New button");
		button_5.setEnabled(false);
		button_5.setBounds(29, 74, 53, 23);
		panel.add(button_5);

		JButton button_6 = new JButton("New button");
		button_6.setEnabled(false);
		button_6.setBounds(29, 126, 53, 23);
		panel.add(button_6);

		JButton button_7 = new JButton("New button");
		button_7.setEnabled(false);
		button_7.setBounds(29, 178, 53, 23);
		panel.add(button_7);

		JButton button_8 = new JButton("New button");
		button_8.setEnabled(false);
		button_8.setBounds(29, 230, 53, 23);
		panel.add(button_8);

		JButton button_9 = new JButton("New button");
		button_9.setEnabled(false);
		button_9.setBounds(29, 282, 53, 23);
		panel.add(button_9);

		JButton button_10 = new JButton("New button");
		button_10.setEnabled(false);
		button_10.setBounds(126, 282, 53, 23);
		panel.add(button_10);

		JButton button_11 = new JButton("New button");
		button_11.setEnabled(false);
		button_11.setBounds(222, 282, 53, 23);
		panel.add(button_11);

		JButton button_12 = new JButton("New button");
		button_12.setEnabled(false);
		button_12.setBounds(318, 282, 53, 23);
		panel.add(button_12);

		JButton button_13 = new JButton("New button");
		button_13.setEnabled(false);
		button_13.setBounds(414, 282, 53, 23);
		panel.add(button_13);

		JButton button_14 = new JButton("New button");
		button_14.setEnabled(false);
		button_14.setBounds(510, 282, 53, 23);
		panel.add(button_14);

		JButton button_15 = new JButton("New button");
		button_15.setEnabled(false);
		button_15.setBounds(510, 74, 53, 23);
		panel.add(button_15);

		JButton button_16 = new JButton("New button");
		button_16.setEnabled(false);
		button_16.setBounds(510, 126, 53, 23);
		panel.add(button_16);

		JButton button_17 = new JButton("New button");
		button_17.setEnabled(false);
		button_17.setBounds(510, 178, 53, 23);
		panel.add(button_17);

		JButton button_18 = new JButton("New button");
		button_18.setEnabled(false);
		button_18.setBounds(510, 230, 53, 23);
		panel.add(button_18);

		JButton button_19 = new JButton("New button");
		button_19.setEnabled(false);
		button_19.setBounds(414, 74, 53, 23);
		panel.add(button_19);

		JButton button_20 = new JButton("New button");
		button_20.setEnabled(false);
		button_20.setBounds(318, 126, 53, 23);
		panel.add(button_20);

		JButton button_21 = new JButton("New button");
		button_21.setEnabled(false);
		button_21.setBounds(222, 178, 53, 23);
		panel.add(button_21);

		JButton button_22 = new JButton("New button");
		button_22.setEnabled(false);
		button_22.setBounds(126, 230, 53, 23);
		panel.add(button_22);

		JButton button_23 = new JButton("New button");
		button_23.setEnabled(false);
		button_23.setBounds(126, 74, 53, 23);
		panel.add(button_23);

		JButton button_24 = new JButton("New button");
		button_24.setEnabled(false);
		button_24.setBounds(222, 126, 53, 23);
		panel.add(button_24);

		JButton button_25 = new JButton("New button");
		button_25.setEnabled(false);
		button_25.setBounds(318, 178, 53, 23);
		panel.add(button_25);

		JButton button_26 = new JButton("New button");
		button_26.setEnabled(false);
		button_26.setBounds(414, 230, 53, 23);
		panel.add(button_26);

		JButton button_27 = new JButton("New button");
		button_27.setEnabled(false);
		button_27.setBounds(278, 152, 33, 23);
		panel.add(button_27);

		JButton YutButton = new JButton("윷던지기");
		YutButton.setBounds(637, 303, 105, 49);
		getContentPane().add(YutButton);

		JButton NextTurnButton = new JButton("턴 넘기기");
		NextTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u.dispose();
			}
		});

		NextTurnButton.setBounds(637, 244, 105, 49);
		getContentPane().add(NextTurnButton);

		JButton ShopButton = new JButton("상점");
		ShopButton.setBounds(637, 185, 105, 49);
		ShopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				temp_shop = new ShopTest();
			}

		});
		getContentPane().add(ShopButton);

		JPanel StatusPanel = new JPanel();
		StatusPanel.setBounds(637, 10, 105, 165);
		getContentPane().add(StatusPanel);
		StatusPanel.setLayout(null);

		JLabel IDLabel = new JLabel("New label");
		IDLabel.setBounds(12, 60, 81, 26);
		IDLabel.setText(user.getID());
		StatusPanel.add(IDLabel);

		JLabel MoneyLabel = new JLabel("New label");
		MoneyLabel.setBounds(12, 129, 81, 26);
		StatusPanel.add(MoneyLabel);
		MoneyLabel.setText(String.valueOf(user.getGameMoney()));
		
		JLabel IDsign = new JLabel("ID");
		IDsign.setBounds(12, 24, 81, 26);
		StatusPanel.add(IDsign);
		
		JLabel GameMoneySign = new JLabel("GameMoney");
		GameMoneySign.setBounds(12, 93, 81, 26);
		StatusPanel.add(GameMoneySign);
		YutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				u = new Yut();
			}

		});

		setLocationRelativeTo(null);
		setVisible(true);

	}
}
