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

		JButton button10 = new JButton("10");
		button10.setEnabled(false);
		button10.setBounds(29, 22, 53, 23);
		panel.add(button10);

		JButton button9 = new JButton("9");
		button9.setEnabled(false);
		button9.setBounds(126, 22, 53, 23);
		panel.add(button9);

		JButton button8 = new JButton("8");
		button8.setEnabled(false);
		button8.setBounds(222, 22, 53, 23);
		panel.add(button8);

		JButton button7 = new JButton("7");
		button7.setEnabled(false);
		button7.setBounds(318, 22, 53, 23);
		panel.add(button7);

		JButton button6 = new JButton("6");
		button6.setEnabled(false);
		button6.setBounds(414, 22, 53, 23);
		panel.add(button6);

		JButton button5 = new JButton("5");
		button5.setEnabled(false);
		button5.setBounds(510, 22, 53, 23);
		panel.add(button5);

		JButton button11 = new JButton("11");
		button11.setEnabled(false);
		button11.setBounds(29, 74, 53, 23);
		panel.add(button11);

		JButton button12 = new JButton("12");
		button12.setEnabled(false);
		button12.setBounds(29, 126, 53, 23);
		panel.add(button12);

		JButton button13 = new JButton("13");
		button13.setEnabled(false);
		button13.setBounds(29, 178, 53, 23);
		panel.add(button13);

		JButton button14 = new JButton("14");
		button14.setEnabled(false);
		button14.setBounds(29, 230, 53, 23);
		panel.add(button14);

		JButton button15 = new JButton("15");
		button15.setEnabled(false);
		button15.setBounds(29, 282, 53, 23);
		panel.add(button15);

		JButton button16 = new JButton("16");
		button16.setEnabled(false);
		button16.setBounds(126, 282, 53, 23);
		panel.add(button16);

		JButton button17 = new JButton("17");
		button17.setEnabled(false);
		button17.setBounds(222, 282, 53, 23);
		panel.add(button17);

		JButton button18 = new JButton("18");
		button18.setEnabled(false);
		button18.setBounds(318, 282, 53, 23);
		panel.add(button18);

		JButton button19 = new JButton("19");
		button19.setEnabled(false);
		button19.setBounds(414, 282, 53, 23);
		panel.add(button19);

		JButton button0 = new JButton("0");
		button0.setEnabled(false);
		button0.setBounds(510, 282, 53, 23);
		panel.add(button0);

		JButton button4 = new JButton("4");
		button4.setEnabled(false);
		button4.setBounds(510, 74, 53, 23);
		panel.add(button4);

		JButton button3 = new JButton("3");
		button3.setEnabled(false);
		button3.setBounds(510, 126, 53, 23);
		panel.add(button3);

		JButton button2 = new JButton("2");
		button2.setEnabled(false);
		button2.setBounds(510, 178, 53, 23);
		panel.add(button2);

		JButton button1 = new JButton("1");
		button1.setEnabled(false);
		button1.setBounds(510, 230, 53, 23);
		panel.add(button1);

		JButton button20 = new JButton("20");
		button20.setEnabled(false);
		button20.setBounds(414, 74, 53, 23);
		panel.add(button20);

		JButton button21 = new JButton("21");
		button21.setEnabled(false);
		button21.setBounds(318, 126, 53, 23);
		panel.add(button21);

		JButton button22 = new JButton("22");
		button22.setEnabled(false);
		button22.setBounds(222, 178, 53, 23);
		panel.add(button22);

		JButton button23 = new JButton("23");
		button23.setEnabled(false);
		button23.setBounds(126, 230, 53, 23);
		panel.add(button23);

		JButton button24 = new JButton("24");
		button24.setEnabled(false);
		button24.setBounds(126, 74, 53, 23);
		panel.add(button24);

		JButton button25 = new JButton("25");
		button25.setEnabled(false);
		button25.setBounds(222, 126, 53, 23);
		panel.add(button25);

		JButton button27 = new JButton("27");
		button27.setEnabled(false);
		button27.setBounds(318, 178, 53, 23);
		panel.add(button27);

		JButton button28 = new JButton("28");
		button28.setEnabled(false);
		button28.setBounds(414, 230, 53, 23);
		panel.add(button28);

		JButton button26 = new JButton("26");
		button26.setEnabled(false);
		button26.setBounds(278, 152, 33, 23);
		panel.add(button26);

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
				//서버에 u에 대한 것을 보내도록 한다.
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
