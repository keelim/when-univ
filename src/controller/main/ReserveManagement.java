package controller.main;

import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ReserveManagement extends JFrame {
    private String ing_id;
    private JPanel panel;
    private JTable table1;
    private JButton 뒤로가기Button;
    private JButton 예약취소Button;
    private ArrayList<String> arrayList;

    private String getIng_id() {
        return ing_id;
    }

    private void setIng_id(String ing_id) {
        this.ing_id = ing_id;
    }


    public ReserveManagement() {
        setTitle("예약관리");
        setContentPane(panel);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        initTable();
        뒤로가기Button.addActionListener(e -> {
            dispose();
            MainActivity.getInstance(getIng_id()).setVisible(true);
        });

        예약취소Button.addActionListener(e -> {

        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                arrayList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    arrayList.add((String) table1.getValueAt(table1.getSelectedRow(), i));
                }
                System.out.println(arrayList);
            }

        });
    }

    public void initTable() { //초기 테이블을 작성을 한다.
        //현재 가지고 있는 것을 콜을 한다.
        String[] a = {"예약 도서번호", "예약 날짜"};
        System.out.println(getIng_id());
        String[][] b = DbCall.getUserBookList(getIng_id()); //todo 예약 테이블 작성을 할 것4

        DefaultTableModel model = new DefaultTableModel(b, a) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        table1.updateUI();
    }

    public ReserveManagement(String text) {
        this();
        setIng_id(text);
        initTable();
    }

}
