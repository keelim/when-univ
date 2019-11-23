package Cotroller.admin;

import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminReturnTheBook extends JFrame {
    private JPanel return_panel;
    private JTable table1;
    private JButton 반납승인Button;
    private JButton 뒤로가기Button;
    ArrayList<String> arrayList;

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
            boolean flag = DbCall.deleteReturnBookList(arrayList);
            if (flag) {
                JOptionPane.showMessageDialog(null, "도서 반납을 승인합니다.");
                initTable();
                table1.updateUI();
            } else {
                JOptionPane.showMessageDialog(null, "도서 반납이 실패되었습니다.");
                JOptionPane.showMessageDialog(null, "다시 시도를 해주세요");
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭한 행을 통하여 DB 삭제를 한다.
                arrayList = new ArrayList<>();

                for (int i = 0; i < 2; i++) {
                    arrayList.add((String) table1.getValueAt(table1.getSelectedRow(), i));
                }
                System.out.println(arrayList);
            }
        });
    }

    private void initTable() {
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        String[] a = {"반납 도서 번호", "회원 아이디"};
        String[][] b = DbCall.getReturnBookList();
        DefaultTableModel model = new DefaultTableModel(b, a) {
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
