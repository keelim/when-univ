package Cotroller.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookSearch extends JFrame {
    private JPanel panel;
    private JTextField searchfield;
    private JButton 검색Button;
    private JTable table1;
    private JButton 도서대출Button;
    private JButton 뒤로가기Button;
    private JButton 도서예약Button;

    public BookSearch() {
        setContentPane(panel);
        setTitle("메인 화면");
        initTable();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        뒤로가기Button.addActionListener(e -> {
            dispose();
            MainActivity.getInstance().setVisible(true);
        });
        검색Button.addActionListener(e -> {
            search();
        });
        searchfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    search();
                }
            }
        });
        도서대출Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "도서를 대출을 합니다.");
        });
        도서예약Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "도서를 예약을 합니다.");
        });
    }

    private void search() {
        String keyword = searchfield.getText();
        JOptionPane.showMessageDialog(null, keyword + " 검색합니다.", "도서 검색", JOptionPane.WARNING_MESSAGE);
    }

    private void initTable() {
        //초기 테이블을 작성을 한다.
        //현재 가지고 있는 것을 콜을 한다.
        String[] a = {"a", "b", "c", "d"};
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

    public static void main(String[] args) {
        new BookSearch();
    }
}
