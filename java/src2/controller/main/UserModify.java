package controller.main;

import controller.View;
import db.DbCall;

import javax.swing.*;
import java.util.ArrayList;

class UserModify extends JFrame{
    private static UserModify instance;
    private JTextField user_name_field;
    private JTextField user_email_field;
    private JTextField user_tel_field;
    private JButton 회원정보수정Button;
    private JButton 뒤로가기Button;
    private JPanel panel1;
    private String id;
    private ArrayList<String> arrayList;

    private String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public UserModify(String ing_id) {
        this();
        setId(ing_id);
        setInformation();
    }

    private UserModify() {
        setContentPane(panel1);
        setLocationRelativeTo(null);

        뒤로가기Button.addActionListener(e -> {
            dispose();
            MyConfiguration.getInstance(getId()).setVisible(true);
        });

        pack();
        setVisible(true);
        회원정보수정Button.addActionListener(e -> {
            arrayList = getInformation();
            boolean flag = DbCall.modifyUserInformation(arrayList, getId());
            if (flag){
                View.alert("회원 정보 수정이 완료 되었습니다.");
                dispose();
                MyConfiguration.getInstance(getId()).setVisible(true);
            } else {
                View.alert("정보 수정의 실패를 하였습니다. ");
            }
        });
    }

    private void setInformation() {
        ArrayList<String> list = DbCall.getUserInfo(getId());
        user_name_field.setText(list.get(0));
        user_email_field.setText(list.get(1));
        user_tel_field.setText(list.get(2));
    }

    private ArrayList<String> getInformation() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(user_name_field.getText());
        temp.add(user_email_field.getText());
        temp.add(user_tel_field.getText());
        return temp;
    }


}
