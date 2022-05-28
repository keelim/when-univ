package controller.main;

import controller.View;
import controller.login.Login;
import db.DbCall;

import javax.swing.*;

public class MyConfiguration extends JFrame {
    private static MyConfiguration instance;
    private JPanel panel;
    private JButton 회원정보수정Button;
    private JButton 회원탈퇴Button;
    private JButton 뒤로가기Button;
    private String ing_id;

    private String getIng_id() {
        return ing_id;
    }

    private void setIng_id(String ing_id) {
        this.ing_id = ing_id;
    }

    private MyConfiguration() {
        setContentPane(panel);
        setTitle("설정 화면");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        뒤로가기Button.addActionListener(e -> {
            dispose();
            MainActivity.getInstance(getIng_id()).setVisible(true);
        });
        회원탈퇴Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "회원 탈퇴 신청을 합니다.", "회원 탈퇴", JOptionPane.WARNING_MESSAGE);
            //회원 탈퇴를 신청을 합니다.
            boolean flag = DbCall.userWithdrawal(getIng_id());
            if (flag) {
                dispose();
                MainActivity.getInstance(getIng_id()).dispose();
                Login.getInstance().setVisible(true);
                View.alert("탈퇴가 완료되었습니다. ");
            } else {
                View.alert("대출 중이거나 예약되어 있는 책이 있습니다. 확인 부탁드립니다.");
            }
        });
        회원정보수정Button.addActionListener(e -> new UserModify(getIng_id()));
    }

    public MyConfiguration(String ing_id) {
        this();
        setIng_id(ing_id);
    }

    public static MyConfiguration getInstance(String id) {
        if (instance == null) {
            instance = new MyConfiguration(id);
        }
        return instance;
    }

}
