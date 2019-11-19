package Cotroller.main;

import Cotroller.login.Login;
import sun.applet.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainActivity extends JFrame {
    private static MainActivity instance;
    private JPanel main_panel;
    private JButton 회원정보Button;
    private JTable table1;
    private JButton 로그아웃Button;
    private JButton 도서반납Button;
    private JButton 도서검색Button;

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
            JOptionPane.showMessageDialog(null, "도서 검색 창으로 이동합니다.", "도서 검색", JOptionPane.WARNING_MESSAGE);
            new BookSearch();
        });

        도서반납Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "관리자에게 도서 반납을 요청 합니다.", "도서 반납", JOptionPane.WARNING_MESSAGE);
        });

        회원정보Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "회원 정보 창으로 이동 합니다.", "회원 정보", JOptionPane.WARNING_MESSAGE);
        });
        도서검색Button.addActionListener(e -> {

            JOptionPane.showMessageDialog(null, "회원 정보 창으로 이동 합니다.", "회원 정보", JOptionPane.WARNING_MESSAGE);
        });;
    }

    private void initTable() { //초기 테이블을 작성을 한다.
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

    public static MainActivity getInstance(){
        if(instance==null){
            return new MainActivity();
        } else{
            return instance;
        }
    }

}
