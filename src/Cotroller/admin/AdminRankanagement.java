package Cotroller.admin;

import javax.swing.*;

public class AdminRankanagement extends JFrame {

    private static AdminRankanagement instance;
    private JTable table1;
    private JButton 뒤로가기Button;
    private JPanel user_panel;
    private JButton 도서등록Button;
    private JButton 도서정보삭제Button;
    private JButton 도서삭제Button;

    public AdminRankanagement() {
        setContentPane(user_panel);
        pack();
        setTitle("도서 정보 관리");
        setVisible(true);
        setLocationRelativeTo(null);
        뒤로가기Button.addActionListener(e -> {
            AdminActivity activity = AdminActivity.getInstance();
            setVisible(false);
            activity.setVisible(true);
        });
    }


    public static void main(String[] args) {
        new AdminRankanagement();
    }

    public static AdminRankanagement getInstance() {
        if (instance == null) {
            return new AdminRankanagement();
        } else {
            return instance;
        }
    }


}
