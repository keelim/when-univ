package Cotroller.admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminReturnTheBook extends JFrame{
    private JPanel return_panel;
    private JTable table1;
    private JButton 반납승인Button;
    private JButton 뒤로가기Button;

    public AdminReturnTheBook() {
        setTitle("도서 반납 관리");
        setContentPane(return_panel);
        setLocationRelativeTo(null);

        pack();
        setVisible(true);
        뒤로가기Button.addActionListener(e -> {
            setVisible(false);
            AdminActivity activity = AdminActivity.getInstance();
            activity.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new AdminReturnTheBook();
    }
}
