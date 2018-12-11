package MainTest;

import javax.swing.*;

public class Staus extends JFrame {
    private User user;

    private static Client client = new Client();

    public Staus() { // Frame 상태에서는 쓰레드를 호환을 할 수 가 없다. ? --> 버튼을 눌러서 확인을 하는 방법을 사용
        user = User.getInstance();
        setTitle("자바 스테이터스 테스트");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(1200, 300);
        getContentPane().setLayout(null);

        JButton usersequence = new JButton("레  벨");
        usersequence.setBounds(153, 21, 119, 38);

        usersequence.addActionListener(e -> {
            System.out.println(user.getID());
            String id = user.getID();
            client.resultComm = client.level(id);
            JOptionPane.showMessageDialog(null, "레벨을 확인 합니다. "); //핸들러를 통하여 데이터를 받아야 한다.
            JOptionPane.showMessageDialog(null, "당신의 레벨은 " + client.resultComm.getLevel());

        });
        getContentPane().add(usersequence);

        JButton open_user = new JButton("포 인 트");
        open_user.setBounds(153, 80, 119, 38);

        open_user.addActionListener(e -> {
            String id = user.getID();
            client.resultComm = client.point(id);
            JOptionPane.showMessageDialog(null, "포인트를 확인 합니다. ");
            JOptionPane.showMessageDialog(null, "당신의 포인트는 " + client.resultComm.getPoint());

        });
        getContentPane().add(open_user);


        JButton exitbutton = new JButton("접속 종료");
        exitbutton.setBounds(153, 198, 119, 38);

        exitbutton.addActionListener(e -> {
            System.out.println("프로그램 종료"); // 프로그램 종료 버튼을 누르면 프로그램을 종료 합니다.
            JOptionPane.showMessageDialog(null, "프로그램을 종료 합니다. ");
            client.close();
            System.exit(1);
        });
        getContentPane().add(exitbutton);

        JLabel idlabel = new JLabel(user.getID());
        idlabel.setBounds(35, 22, 57, 15);
        getContentPane().add(idlabel);


        JButton button = new JButton("승리 횟수");
        button.addActionListener(e -> {
            System.out.println(user.getID());
            String id = user.getID();
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