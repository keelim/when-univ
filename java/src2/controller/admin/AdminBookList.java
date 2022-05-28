package controller.admin;

import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class AdminBookList extends JFrame{
    private JTable table1;
    private JButton 뒤로가기Button;
    private JButton 새로고침Button;
    private JPanel panel;


    public AdminBookList() { //todo 대출한 회원과 대출 날짜 반납 날짜를 표시를 한다.
        setContentPane(panel);
        setLocationRelativeTo(null);
        initTable();
        새로고침Button.addActionListener(e -> initTable());

        뒤로가기Button.addActionListener(e -> {
            dispose();
            AdminUserManagement.getInstance().setVisible(true);
        });
        pack();
        setVisible(true);
    }

    private void initTable() { //초기 테이블을 작성을 한다.
        String[] a = {"id", "도서번호", "대출날짜", "반납날짜"};
        String[][] b = DbCall.borrowUser();
        DefaultTableModel model = new DefaultTableModel(b, a) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        table1.updateUI();
    }

}
