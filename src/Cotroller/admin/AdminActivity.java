package Cotroller.admin;

import javax.swing.*;

public class AdminActivity extends JFrame {
    private static AdminActivity instance;
    private JPanel admin_panel;
    private JButton BookInformationManagement;
    private JButton BookReturnManagement;
    private JButton UserInformationManagement;

    public AdminActivity() {
        setContentPane(admin_panel);
        setTitle("관리자 업무");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        BookInformationManagement.addActionListener(e -> {
            new AdminRankanagement();
            setVisible(false);
        });
        BookReturnManagement.addActionListener(e -> {
            new AdminReturnTheBook();
            setVisible(false);
        });

        UserInformationManagement.addActionListener(e -> {
            setVisible(false);
        });
    }

    public static AdminActivity getInstance(){
        if(instance==null){
            return new AdminActivity();
        } else{
            return instance;
        }
    }

    public static void main(String[] args) {
        new AdminActivity();
    }
}
