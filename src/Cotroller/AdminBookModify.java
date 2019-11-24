package Cotroller;

import Cotroller.admin.AdminBookManagement;

import javax.swing.*;

public class AdminBookModify extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton 뒤로가기Button;
    private JButton 정보수정Button;

    public AdminBookModify() {
        setContentPane(panel);
        setTitle("도서 정보 수정");

        뒤로가기Button.addActionListener(e -> {
            dispose();
            AdminBookManagement.getInstance().setVisible(true);
        });
        pack();
        setVisible(true);
        정보수정Button.addActionListener(e -> {
            String[] information = getInformation();
        });
    }

    private String[] getInformation() {
        String[] info = new String[4];
        info[0] = textField1.getText();
        info[1] = textField2.getText();
        info[2] = textField3.getText();
        info[3] = textField4.getText()
    }
}
