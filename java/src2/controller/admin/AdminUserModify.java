package controller.admin;

import db.DbCall;

import javax.swing.*;
import java.util.ArrayList;

class AdminUserModify extends JFrame {
    private JButton 뒤로가기Button;
    private JPanel panel1;
    private JTextField user_status_field;
    private JTextField user_name_field;
    private JTextField user_email_field;
    private JTextField user_tel_field;
    private JButton 회원정보수정Button;
    private ArrayList<String> setList;

    public AdminUserModify(ArrayList<String> arrayList) {
        setContentPane(panel1);
        setLocationRelativeTo(null);
        setInformation(arrayList);
        pack();
        setVisible(true);
        뒤로가기Button.addActionListener(e -> {
            dispose();
            AdminUserManagement.getInstance().setVisible(true);
        });
        회원정보수정Button.addActionListener(e -> {
            setList = getInformation();
            boolean flag = DbCall.modifyUser(setList, arrayList.get(0));
            if (flag){
                JOptionPane.showMessageDialog(null, "수정이 성공하였습니다.");
                dispose();
                AdminUserManagement.getInstance().initTable();
                AdminUserManagement.getInstance().setVisible(true);

            } else{
                JOptionPane.showMessageDialog(null, "수정이 실패하였습니다..");
            }

        });
    }


    private void setInformation(ArrayList<String> list) {
        user_status_field.setText(list.get(1));
        user_name_field.setText(list.get(2));
        user_email_field.setText(list.get(3));
        user_tel_field.setText(list.get(4));
    }

    private ArrayList<String> getInformation() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(user_status_field.getText());
        temp.add(user_name_field.getText());
        temp.add(user_email_field.getText());
        temp.add(user_tel_field.getText());
        return temp;
    }
}
