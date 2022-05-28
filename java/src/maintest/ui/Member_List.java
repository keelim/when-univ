package maintest.ui;

import maintest.db.MemberDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class Member_List extends JFrame implements MouseListener, ActionListener {
    private Vector v, cols;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane pane;
    private JPanel panel;
    private JButton button;

    public Member_List() {
        super("GM 회원 관리 창");
        setLocationRelativeTo(null);
        MemberDB db = new MemberDB();
        v = db.getMemberList();
        System.out.println("v=" + v);
        cols = getColumn();
        model = new DefaultTableModel(v, cols);
        table = new JTable(model);
        pane = new JScrollPane(table);
        add(pane);

        panel = new JPanel();
        button = new JButton("회원가입");
        panel.add(button);
        add(panel, BorderLayout.NORTH);

        table.addMouseListener(this); //리스너 등록
        button.addActionListener(this); //회원가입버튼 리스너 등록

        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //JTable 의 컬럼
    public Vector<String> getColumn() {
        Vector<String> col = new Vector<>();
        col.add("아이디");
        col.add("비밀번호");
        col.add("GameMoney");
        col.add("level");
        col.add("win");

        return col;
    }//getColumn


    // JTable 내용 갱신 메서드
    public void jTableRefresh() {
        MemberDB db = new MemberDB();
        DefaultTableModel model = new DefaultTableModel(db.getMemberList(), getColumn());
        table.setModel(model);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // mouseClicked 만 사용
        int r = table.getSelectedRow();
        String id = (String) table.getValueAt(r, 0);
        //System.out.println("id="+id);
        MemberGui mem = new MemberGui(id, this); //아이디를 인자로 수정창 생성
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //버튼을 클릭하면
        if (e.getSource() == button) {
            new MemberGui(this);
        }

    }

}
   
