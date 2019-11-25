package controller.admin;

import javax.swing.*;

public class AdminUserModify extends JFrame {
    private JButton 뒤로가기Button;
    private JPanel panel1;

    public AdminUserModify() {
        setContentPane(panel1);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        뒤로가기Button.addActionListener(e -> {
            dispose();
            AdminUserManagement.getInstance().setVisible(true);
        });
    }
}
