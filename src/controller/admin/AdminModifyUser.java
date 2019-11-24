package controller.admin;

import javax.swing.*;

public class AdminModifyUser extends JFrame {
    private JButton 뒤로가기Button;
    private JPanel panel1;

    public AdminModifyUser() {
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
