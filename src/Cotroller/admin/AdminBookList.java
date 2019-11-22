package Cotroller.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminBookList extends JFrame{
    private JTable table1;
    private JButton 뒤로가기Button;
    private JButton 새로고침Button;
    private JPanel panel;


    public AdminBookList() {
        setContentPane(panel);
        setLocationRelativeTo(null);
        새로고침Button.addActionListener(e -> {
            //람다를 생성을 한다.
            //받아온 데이터베이스 쿼리를 2차원 배열로 가지고 와야 한다.
            JOptionPane.showMessageDialog(null, "목록을 새로 고침한다.");
            table1.updateUI();
        });
        뒤로가기Button.addActionListener(e -> {
            dispose();
            AdminUserManagement.getInstance().setVisible(true);
        });
        pack();
        setVisible(true);
    }

    private void initTable() { //초기 테이블을 작성을 한다.
        String[] a = {"도서번호", "도서이름", "도서저자", "도서출판사", "도서 isbn"};
        String[][] b = {{"a1", "a2", "a3", "sd"},
                {"b1", "b2", "b3", "sd"},
                {"c1", "c2", "c3", "sd"}};
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
