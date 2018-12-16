package MainTest;

import javax.swing.*;
import java.awt.*;

public class MainGUIsub extends JFrame {    /// 서버 멀티 태크스 구성을 살리는 것이 중요 최소 기능 만을 구현을 하자  커넥션 까지 관리를 하기에는 무리가 있을 것으로 예상
    private Yut u;
    private User user = User.getInstance();
    private String id = user.getID();
    private Client client = new Client();

    public MainGUIsub() {
        JOptionPane.showMessageDialog(null, "서버 이중 로그인 방지 ");

        client.resultComm = client.idplus(id); // 서버 이중 로그인 방지 하는 것을 만들기
        if(client.resultComm.getStatus() == -1){
            JOptionPane.showMessageDialog(null, "접속 되어진 아이디가 있습니다. ");
            JOptionPane.showMessageDialog(null, "프로그램을 종료 합니다. ");
            System.exit(1);

        }
        // 커넥션 관리 서버

        setTitle("메인화면");
        new Staus();
        setSize(770, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 625, 342);
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton button10 = new JButton("10");
        button10.setEnabled(false);
        button10.setBounds(29, 22, 53, 23);
        panel.add(button10);

        JButton button9 = new JButton("9");
        button9.setEnabled(false);
        button9.setBounds(126, 22, 53, 23);
        panel.add(button9);

        JButton button8 = new JButton("8");
        button8.setEnabled(false);
        button8.setBounds(222, 22, 53, 23);
        panel.add(button8);

        JButton button7 = new JButton("7");
        button7.setEnabled(false);
        button7.setBounds(318, 22, 53, 23);
        panel.add(button7);

        JButton button6 = new JButton("6");
        button6.setEnabled(false);
        button6.setBounds(414, 22, 53, 23);
        panel.add(button6);

        JButton button5 = new JButton("5");
        button5.setEnabled(false);
        button5.setBounds(510, 22, 53, 23);
        panel.add(button5);

        JButton button11 = new JButton("11");
        button11.setEnabled(false);
        button11.setBounds(29, 74, 53, 23);
        panel.add(button11);

        JButton button12 = new JButton("12");
        button12.setEnabled(false);
        button12.setBounds(29, 126, 53, 23);
        panel.add(button12);

        JButton button13 = new JButton("13");
        button13.setEnabled(false);
        button13.setBounds(29, 178, 53, 23);
        panel.add(button13);

        JButton button14 = new JButton("14");
        button14.setEnabled(false);
        button14.setBounds(29, 230, 53, 23);
        panel.add(button14);

        JButton button15 = new JButton("15");
        button15.setEnabled(false);
        button15.setBounds(29, 282, 53, 23);
        panel.add(button15);

        JButton button16 = new JButton("16");
        button16.setEnabled(false);
        button16.setBounds(126, 282, 53, 23);
        panel.add(button16);

        JButton button17 = new JButton("17");
        button17.setEnabled(false);
        button17.setBounds(222, 282, 53, 23);
        panel.add(button17);

        JButton button18 = new JButton("18");
        button18.setEnabled(false);
        button18.setBounds(318, 282, 53, 23);
        panel.add(button18);

        JButton button19 = new JButton("19");
        button19.setEnabled(false);
        button19.setBounds(414, 282, 53, 23);
        panel.add(button19);

        JButton button0 = new JButton("0");
        button0.setEnabled(false);
        button0.setBounds(510, 282, 53, 23);
        panel.add(button0);

        JButton button4 = new JButton("4");
        button4.setEnabled(false);
        button4.setBounds(510, 74, 53, 23);
        panel.add(button4);

        JButton button3 = new JButton("3");
        button3.setEnabled(false);
        button3.setBounds(510, 126, 53, 23);
        panel.add(button3);

        JButton button2 = new JButton("2");
        button2.setEnabled(false);
        button2.setBounds(510, 178, 53, 23);
        panel.add(button2);

        JButton button1 = new JButton("1");
        button1.setEnabled(false);
        button1.setBounds(510, 230, 53, 23);
        panel.add(button1);

        JButton button20 = new JButton("20");
        button20.setEnabled(false);
        button20.setBounds(414, 74, 53, 23);
        panel.add(button20);

        JButton button21 = new JButton("21");
        button21.setEnabled(false);
        button21.setBounds(318, 126, 53, 23);
        panel.add(button21);

        JButton button22 = new JButton("22");
        button22.setEnabled(false);
        button22.setBounds(222, 178, 53, 23);
        panel.add(button22);

        JButton button23 = new JButton("23");
        button23.setEnabled(false);
        button23.setBounds(126, 230, 53, 23);
        panel.add(button23);

        JButton button24 = new JButton("24");
        button24.setEnabled(false);
        button24.setBounds(126, 74, 53, 23);
        panel.add(button24);

        JButton button25 = new JButton("25");
        button25.setEnabled(false);
        button25.setBounds(222, 126, 53, 23);
        panel.add(button25);

        JButton button27 = new JButton("27");
        button27.setEnabled(false);
        button27.setBounds(318, 178, 53, 23);
        panel.add(button27);

        JButton button28 = new JButton("28");
        button28.setEnabled(false);
        button28.setBounds(414, 230, 53, 23);
        panel.add(button28);

        JButton button26 = new JButton("26");
        button26.setEnabled(false);
        button26.setBounds(278, 152, 33, 23);
        panel.add(button26);

        JButton YutButton = new JButton("윷 던지기");
        YutButton.setBounds(637, 303, 105, 49);
        getContentPane().add(YutButton);

        JButton NextTurnButton = new JButton("턴 넘기기");
        NextTurnButton.addActionListener(e -> u.dispose());

        NextTurnButton.setBounds(637, 244, 105, 49);
        getContentPane().add(NextTurnButton);

        JButton state_button = new JButton("상 태");
        state_button.setBounds(637, 185, 105, 49);
        state_button.addActionListener(e -> {
            new Staus();
        });
        getContentPane().add(state_button);

        YutButton.addActionListener(e -> { //u에 대한 정보를 클라이언트로 전송을 해야 합니다.
            u = new Yut();

        });

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }


    class Staus extends JFrame {

        public Staus() { // Frame 상태에서는 쓰레드를 호환을 할 수 가 없다. ? --> 버튼을 눌러서 확인을 하는 방법을 사용

            setTitle("자바 스테이터스 테스트");
            setSize(300, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocation(1200, 300);
            getContentPane().setLayout(null);

            JButton usersequence = new JButton("레  벨");
            usersequence.setBounds(153, 21, 119, 38);

            usersequence.addActionListener(e -> {
                System.out.println(id);
                client.resultComm = client.level(id);
                JOptionPane.showMessageDialog(null, "레벨을 확인 합니다. "); //핸들러를 통하여 데이터를 받아야 한다.
                JOptionPane.showMessageDialog(null, "당신의 레벨은 " + client.resultComm.getLevel());

            });
            getContentPane().add(usersequence);

            JButton open_user = new JButton("포 인 트");
            open_user.setBounds(153, 80, 119, 38);

            open_user.addActionListener(e -> {
                client.resultComm = client.point(id);
                JOptionPane.showMessageDialog(null, "포인트를 확인 합니다. ");
                JOptionPane.showMessageDialog(null, "당신의 포인트는 " + client.resultComm.getPoint());

            });
            getContentPane().add(open_user);


            JButton exitbutton = new JButton("접속 종료");
            exitbutton.setBounds(153, 198, 119, 38);

            exitbutton.addActionListener(e -> {
                System.out.println("프로그램을 종료 합니다. "); // 프로그램 종료 버튼을 누르면 프로그램을 종료 합니다.


                JOptionPane.showMessageDialog(null, "프로그램을 종료");
                client.close();
                System.exit(1);

            });
            getContentPane().add(exitbutton);

            JLabel idlabel = new JLabel(user.getID());
            idlabel.setBounds(35, 22, 57, 15);
            getContentPane().add(idlabel);


            JButton button = new JButton("승리 횟수");
            button.addActionListener(e -> {
                client.resultComm = client.win(id);
                JOptionPane.showMessageDialog(null, "승리 횟수를 확인 합니다. ");
                JOptionPane.showMessageDialog(null, "당신의 승리 횟수는 " + client.resultComm.getWin());
            });
            button.setBounds(153, 139, 119, 38);
            getContentPane().add(button);

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }

    }
}
