package controller.admin;

import db.DbCall;

import javax.swing.*;
import java.util.ArrayList;

class AdminBookModify extends JFrame {
    private JPanel panel;
    private JTextField book_title_field;
    private JTextField book_author_field;
    private JTextField book_publisher_field;
    private JTextField book_isbn_field;
    private JButton 뒤로가기Button;
    private JButton 정보수정Button;
    private ArrayList<String> arrayList;
    private ArrayList<String> setList;


    private void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public AdminBookModify(ArrayList<String> infoList) {
        setContentPane(panel);
        setTitle("도서 정보 수정");
        setLocationRelativeTo(null);
        setArrayList(infoList);
        setInformation(arrayList);
        뒤로가기Button.addActionListener(e -> {
            dispose();
            AdminBookManagement.getInstance().setVisible(true);
        });
        pack();
        setVisible(true);
        정보수정Button.addActionListener(e -> {
            setList = getInformation();
            boolean flag = DbCall.modifyBook(setList, arrayList.get(0));
            if (flag){
                JOptionPane.showMessageDialog(null, "수정이 성공하였습니다.");
                dispose();
                AdminBookManagement.getInstance().initTable();
                AdminBookManagement.getInstance().setVisible(true);

            } else{
                JOptionPane.showMessageDialog(null, "수정이 실패하였습니다..");
            }
        });
    }

    private void setInformation(ArrayList<String> list) {
        book_title_field.setText(list.get(1));
        book_author_field.setText(list.get(2));
        book_publisher_field.setText(list.get(3));
        book_isbn_field.setText(list.get(4));
    }

    private ArrayList<String> getInformation() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(book_title_field.getText());
        temp.add(book_author_field.getText());
        temp.add(book_publisher_field.getText());
        temp.add(book_isbn_field.getText());
        return temp;
    }
}
