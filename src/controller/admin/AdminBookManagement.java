package controller.admin;

import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminBookManagement extends JFrame {

    private static AdminBookManagement instance;
    private JTable table1;
    private JButton 뒤로가기Button;
    private JPanel user_panel;
    private JButton 도서등록Button;
    private JButton 도서정보수정Button;
    private JButton 도서삭제Button;
    private ArrayList<String> arrayList;

    public JTable getTable1() {
        return table1;
    }

    public AdminBookManagement() {
        setContentPane(user_panel);
        pack();
        setTitle("도서 정보 관리");
        setVisible(true);
        initTable();
        setLocationRelativeTo(null);
        뒤로가기Button.addActionListener(e -> {
            AdminActivity activity = AdminActivity.getInstance();
            setVisible(false);
            activity.setVisible(true);
        });
        도서삭제Button.addActionListener(e -> {
            JOptionPane.showConfirmDialog(null, "도서를 삭제 하겠습니까?");
            boolean flag = DbCall.deleteBook(arrayList);
            if (flag) {
                View.alert("삭제 완료하였습니다.");
                initTable();
            } else {
                View.alert("삭제를 실패하였습니다. 대출하고 있는 사용자가 있습니다.");
            }
        });
        도서등록Button.addActionListener(e -> {
            View.alert("도서를 등록을 합니다.");
            setVisible(false);
            new AdminBookRegister();
        });
        도서정보수정Button.addActionListener(e -> {
            View.alert("도서 정보를 수정을 합니다.");
            //새로운 창을 띄어서 정보를 수정을 합니다. --> 기존에 있는 정보를 라벨로 불러와서 사용을 하는 것이 좋을 것 같다.
            // 창을 띄어서 값이 반영이면 테이블을 업데이트를 함.
            new AdminBookModify(arrayList);
            setVisible(false);
            table1.updateUI();
        });
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

    public static void main(String[] args) {
        new AdminBookManagement();
    }

    public static AdminBookManagement getInstance() {
        if (instance == null) {
            return new AdminBookManagement();
        } else {
            return instance;
        }
    }

    public void initTable() {
        String[] a = {"도서번호", "도서이름", "도서저자", "도서출판사", "도서 isbn"};
        String[][] b = DbCall.getBookList();
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
