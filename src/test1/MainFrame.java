package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private int yutchecknum = 0;

	public MainFrame() {
		setTitle("메인화면");
		setSize(770, 400);
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

		JButton button_31 = new JButton("윷던지기");
		button_31.setBounds(637, 303, 105, 49);
		getContentPane().add(button_31);
		button_31.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 자동 생성된 메소드 스텁
				
				if (yutchecknum == 0) {
					Yut u = new Yut();
				} else {
					
					yutchecknum =0;
				}

			}

		});
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
