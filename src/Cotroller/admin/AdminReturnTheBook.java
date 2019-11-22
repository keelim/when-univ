package Cotroller.admin;

import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
            dispose();
            AdminActivity activity = AdminActivity.getInstance();
            activity.setVisible(true);
        });
        반납승인Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "책을 반납 합니다.", "반납", JOptionPane.WARNING_MESSAGE);
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 2; i++) {
                    arrayList.add(table1.getValueAt(table1.getSelectedRow(), i));
                }
                System.out.println(arrayList);
            }
        });
    }

    private void initTable() {
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        String[] a = {"반납 도서 번호", "회원 아이디"};
        String[][] b = DbCall.getReturnBookList();

//        String[][] b = {{"a1", "a2", "a3", "sd"},
//                {"b1", "b2", "b3", "sd"},
//                {"c1", "c2", "c3", "sd"}};
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
