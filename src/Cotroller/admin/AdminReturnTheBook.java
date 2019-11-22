package Cotroller.admin;

import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class AdminReturnTheBook extends JFrame {
    private JPanel return_panel;
    private JTable table1;
    private JButton 반납승인Button;
    private JButton 뒤로가기Button;

    public AdminReturnTheBook() {
        setTitle("도서 반납 관리");
        setContentPane(return_panel);
        setLocationRelativeTo(null);
        initTable();
        pack();
        setVisible(true);
        뒤로가기Button.addActionListener(e -> {
            setVisible(false);
            AdminActivity activity = AdminActivity.getInstance();
            activity.setVisible(true);
        });
        반납승인Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "책을 반납 합니다.", "반납", JOptionPane.WARNING_MESSAGE);
        });
    }

    private void initTable() {
        String[] a = {"회원아이디", "회원이름", "반납 책 ISBN", "반납 책 이름"};
//        String[][] b = DbCall.getReturnBookList();


        String[][] b = {{"a1", "a2", "a3", "sd"},
                {"b1", "b2", "b3", "sd"},
                {"c1", "c2", "c3", "sd"}};
        DefaultTableModel model = new DefaultTableModel(b, a){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(model);

        table1.updateUI();
    }


    public static void main(String[] args) {
        new AdminReturnTheBook();
    }
}
