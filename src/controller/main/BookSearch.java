package controller.main;

import controller.View;
import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookSearch extends JFrame {
    private JPanel panel;
    private JTextField search_field;
    private JButton 검색Button;
    private JTable table1;
    private JButton 도서대출Button;
    private JButton 뒤로가기Button;
    private JButton 도서예약Button;
    private JTextField isbn_field;
    private JButton ISBN검색Button;
    private JLabel ISBN검색Label;


    private String ing_id;

    public String getIng_id() {
        return ing_id;
    }

    public void setIng_id(String ing_id) {
        this.ing_id = ing_id;
    }

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
            MainActivity.getInstance(getIng_id()).initTable();
            MainActivity.getInstance(getIng_id()).setVisible(true);
        });
        검색Button.addActionListener(e -> {
            View.alert("제목 검색을 합니다.");
            titleSearch();

        });
        search_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    titleSearch();
                }
            }
        });

        ISBN검색Button.addActionListener(e -> {
            View.alert("isbn 검색을 합니다.");
            isbnSearch();
        });

        도서대출Button.addActionListener(e -> JOptionPane.showMessageDialog(null, "도서를 대출을 합니다."));
        도서예약Button.addActionListener(e -> JOptionPane.showMessageDialog(null, "도서를 예약을 합니다."));
        isbn_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    isbnSearch();
                }
            }
        });
    }


    public BookSearch(String ing_id) {
        this();
        setIng_id(ing_id);
    }

    private void titleSearch() {
        String[][] array;
        String keyword = search_field.getText();
        View.alert(keyword + "을 검색합니다.");
        array = DbCall.titleSearch(keyword);
        if (array != null) {
            View.alert("검색을 완료하였습니다. ");
            initTable(array);
        } else {
            View.alert("검색에 실패하였습니다. ");
        }
    }

    private void isbnSearch() {
        String[][] array;
        String keyword = isbn_field.getText();
        View.alert(keyword + "을 검색합니다.");
        array = DbCall.isbnSearch(keyword);
        if (array != null) {
            View.alert("검색을 완료하였습니다. ");
            initTable(array);
        } else {
            View.alert("검색에 실패하였습니다. ");
        }
    }

    private void initTable(String[][] givenArray) {
        //초기 테이블을 작성을 한다.
        //현재 가지고 있는 것을 콜을 한다.
        String[] a = {"도서제목", "도서저자", "도서출판사", "도서ISBN"};
        DefaultTableModel model = new DefaultTableModel(givenArray, a) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        table1.updateUI();
    }

    private void initTable() {
        //초기 테이블을 작성을 한다.
        //현재 가지고 있는 것을 콜을 한다.
        String[] a = {"도서제목", "도서저자", "도서출판사", "도서ISBN"};
        DefaultTableModel model = new DefaultTableModel(null, a) {
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
