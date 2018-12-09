package MainTest;

import javax.swing.*;

public class Staus extends JFrame {
    private User user;

    public Staus() { // Frame 상태에서는 쓰레드를 호환을 할 수 가 없다. ? --> 버튼을 눌러서 확인을 하는 방법을 사용
        user = User.getInstance();
        setTitle("자바 스테이터스 테스트");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(1200, 300);
        getContentPane().setLayout(null);

        JButton usersequence = new JButton("접속 순서");
        usersequence.setBounds(153, 10, 119, 38);

        usersequence.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "접속 순서를 확인 합니다.  "); //핸들러를 통하여 데이터를 받아야 한다.
        });
        getContentPane().add(usersequence);

        JButton open_user = new JButton("접속자 수");
        open_user.setBounds(153, 61, 119, 38);

        open_user.addActionListener(e -> {
            System.out.println("접속자 수를 확인 합니다. ");
            JOptionPane.showMessageDialog(null, "접속자 수를 확인 합니다. ");
        });
        getContentPane().add(open_user);


        JButton exitbutton = new JButton("접속 종료");
        exitbutton.setBounds(153, 205, 119, 38);

        exitbutton.addActionListener(e -> {
            System.out.println("프로그램 종료"); // 프로그램 종료 버튼을 누르면 프로그램을 종료 합니다.
            JOptionPane.showMessageDialog(null, "프로그램을 종료 합니다. ");
            System.exit(1);
        });
        getContentPane().add(exitbutton);

        JLabel idlabel = new JLabel(user.getID());
        idlabel.setBounds(35, 22, 57, 15);
        getContentPane().add(idlabel);

        JLabel Moneylabel = new JLabel(String.valueOf(user.getGameMoney()));
        Moneylabel.setBounds(69, 73, 57, 15);
        getContentPane().add(Moneylabel);

        JLabel Winlabel = new JLabel(String.valueOf(user.getWin()));
        Winlabel.setBounds(69, 121, 57, 15);
        getContentPane().add(Winlabel);

        JLabel Levellabel = new JLabel(String.valueOf(user.getLevel()));
        Levellabel.setBounds(69, 169, 57, 15);
        getContentPane().add(Levellabel);

        JLabel label_1 = new JLabel("포인트");
        label_1.setBounds(12, 73, 39, 15);
        getContentPane().add(label_1);

        JLabel label_2 = new JLabel("승리");
        label_2.setBounds(12, 121, 39, 15);
        getContentPane().add(label_2);

        JLabel label_3 = new JLabel("레벨");
        label_3.setBounds(12, 169, 39, 15);
        getContentPane().add(label_3);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }



}