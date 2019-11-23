package Cotroller.admin;

import db.DbCall;

import javax.swing.*;
import java.util.ArrayList;

public class AdminBookRegister extends JFrame {
    private JTextField book_title;
    private JTextField book_author;
    private JTextField book_publisher;
    private JTextField book_isbn;
    private JButton 뒤로가기Button;
    private JButton 도서등록Button;
    private JPanel panel;

    public AdminBookRegister() {
        setContentPane(panel);
        setLocationRelativeTo(null);
        뒤로가기Button.addActionListener(e -> {
            dispose();
            AdminBookManagement.getInstance().setVisible(true);
        });
        도서등록Button.addActionListener(e -> {
            ArrayList<String> arrayList = getInformation();
            if (arrayList == null) {
                JOptionPane.showMessageDialog(null, "비어 있는 칸은 필수 칸 입니다.");
                return;
            }
            boolean flag = DbCall.insertBookInformation(arrayList);
            if (flag) {
                JOptionPane.showMessageDialog(null, "도서를 등록을 합니다.");
                dispose();
                AdminBookManagement book = AdminBookManagement.getInstance();
                book.getTable1().updateUI();
                book.setVisible(true);
            } else
                JOptionPane.showMessageDialog(null, "도서를 등록 실패하였습니다.");
        });
        pack();
        setVisible(true);
    }

    private ArrayList<String> getInformation() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(book_title.getText());
        arrayList.add(book_author.getText());
        arrayList.add(book_publisher.getText());
        arrayList.add(book_isbn.getText());
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(""))
                return null;
        }
        return arrayList;
    }
}
