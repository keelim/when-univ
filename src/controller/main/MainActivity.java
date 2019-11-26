package controller.main;

import controller.login.Login;
import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainActivity extends JFrame {
    private String ing_id;

    private static MainActivity instance;
    private JPanel main_panel;
    private JButton 회원정보Button;
    private JTable table1;
    private JButton 로그아웃Button;
    private JButton 도서반납Button;
    private JButton 도서검색Button;
    private ArrayList<String> arrayList;


    private String getIng_id() {
        return ing_id;
    }

    private void setIng_id(String ing_id) {
        this.ing_id = ing_id;
    }

    public MainActivity() {
        setContentPane(main_panel);
        setTitle("메인 화면");
        initTable();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        로그아웃Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "로그 아웃을 실행 합니다.", "로그 아웃", JOptionPane.WARNING_MESSAGE);
            dispose();
            Login.getInstance().setVisible(true);
        });
        도서검색Button.addActionListener(e -> {
            setVisible(false);
            JOptionPane.showMessageDialog(null, "도서 검색 창으로 이동합니다.", "도서 검색", JOptionPane.WARNING_MESSAGE);
            new BookSearch();
        });

        도서반납Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "관리자에게 도서 반납을 요청 합니다.", "도서 반납", JOptionPane.WARNING_MESSAGE);
            boolean flag = DbCall.returnBooKRequest(arrayList, getIng_id());
            if(flag){
                JOptionPane.showMessageDialog(null, "관리자에게 도서 반납을 요청 되었습니다. 잠시만 기다려주세요.", "도서 반납", JOptionPane.WARNING_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "오류 발생", "오류", JOptionPane.WARNING_MESSAGE);
            }

        });

        회원정보Button.addActionListener(e -> JOptionPane.showMessageDialog(null, "회원 정보 창으로 이동 합니다.", "회원 정보", JOptionPane.WARNING_MESSAGE));

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 클릭한 행을 통하여 DB 삭제를 한다.
                arrayList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    arrayList.add((String) table1.getValueAt(table1.getSelectedRow(), i));
                }
                System.out.println(arrayList);
            }
        });
    }

    public MainActivity(String text) {
        this();
        setIng_id(text);
        JOptionPane.showMessageDialog(null, "환영합니다." + getIng_id() + "님", "환영", JOptionPane.WARNING_MESSAGE);
        initTable();
    }

    private void initTable() { //초기 테이블을 작성을 한다.
        //현재 가지고 있는 것을 콜을 한다.
        String[] a = {"도서번호", "도서이름", "도서저자", "도서출판사", "도서 isbn"};
        System.out.println(getIng_id());
        String[][] b = DbCall.getUserBookList(getIng_id());

        DefaultTableModel model = new DefaultTableModel(b, a) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        table1.updateUI();
    }

    public static MainActivity getInstance() {
        if (instance == null) {
            instance = new MainActivity();
        }
        return instance;
    }

}
