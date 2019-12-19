package controller.admin;

import db.DbCall;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminUserManagement extends JFrame {
    private static AdminUserManagement instance;
    private JButton 회원정보수정Button;
    private JButton 회원탈퇴Button;
    private JButton 회원대출목록관리Button;
    private JTable table1;
    private JButton 뒤로가기Button;
    private JPanel userManagement_panel;
    private ArrayList<String> arrayList;

    public AdminUserManagement() {
        setContentPane(userManagement_panel);
        setTitle("회원 정보 관리");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initTable();
        뒤로가기Button.addActionListener(e -> {
            AdminActivity.getInstance().setVisible(true);
            dispose();
        });
        pack();
        setVisible(true);
        회원탈퇴Button.addActionListener(e -> {
            //확인이면 0 취소는 1
            int answer = JOptionPane.showConfirmDialog(null, "선택하신 회원을 삭제를 하시겠습니까?");
            if (answer == 0) {
                boolean flag = DbCall.deleteUser(arrayList);
                if (flag) {
                    JOptionPane.showMessageDialog(null, "선택하신 회원을 삭제했습니다.");
                    initTable();
                }
            }
        });
        회원정보수정Button.addActionListener(e -> {
            //회원 정보를 수정을 하는 이벤트 -> 새로운 창을 여는 것이 좋을 것 같다.
            if (arrayList == null) {
                JOptionPane.showMessageDialog(null, "선택을 해주세요");
            } else {
                setVisible(false);
                new AdminUserModify(arrayList);
            }
        });
        회원대출목록관리Button.addActionListener(e -> {
            setVisible(false);
            new AdminBookList();
        });
        회원탈퇴Button.addMouseListener(new MouseAdapter() {
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

    public void initTable() { //초기 테이블을 작성을 한다.
        String[] a = {"회원아이디", "회원구분", "회원이름", "회원이메일", "회원전화번호", "월 책 대출 수"};
        String[][] b = DbCall.getUserList();
        for (int i = 0; i < b.length; i++) {
            b[i][4] = "0" + b[i][4];
        }
        DefaultTableModel model = new DefaultTableModel(b, a) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(model);
        table1.updateUI();
    }

    public static AdminUserManagement getInstance() {
        if (instance == null) {
            return new AdminUserManagement();
        } else {
            return instance;
        }
    }
}
