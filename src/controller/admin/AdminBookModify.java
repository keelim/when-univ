package controller.admin;

import controller.admin.AdminBookManagement;
import db.DbCall;
import org.omg.CORBA.ARG_IN;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminBookModify extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton 뒤로가기Button;
    private JButton 정보수정Button;
    private ArrayList<String> arrayList;
    private ArrayList<String> setList;


    public void setArrayList(ArrayList<String> arrayList) {
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
            JOptionPane.showMessageDialog(null, "기존의 정보하고 같습니다.");
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
        textField1.setText(list.get(1));
        textField2.setText(list.get(2));
        textField3.setText(list.get(3));
        textField4.setText(list.get(4));
    }

    private ArrayList<String> getInformation() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(textField1.getText());
        temp.add(textField2.getText());
        temp.add(textField3.getText());
        temp.add(textField4.getText());
        return arrayList;
    }
}
