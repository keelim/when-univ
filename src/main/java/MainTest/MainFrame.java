package MainTest;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private User user = User.getInstance();
    private String id = user.getID();
    private Client client = new Client();
    private int yutchecknum = 0;
    private int i = 0; // 가상의 적이 이동하는 말
    private int t = 0;
    private int t_1 = 0; // 가상의 적의 말이 6번에 왔을 때
    private int t_2 = 0;  // 가상의 적의 말이 11번에 왔을 때
    private int t_3 = 0; // 가성의 적의 말이 *에 왔을 때
    private int tk = 0;
    private int tk_1 = 0; // 가상의 적의 말이 6번에 왔을 때 이전말 색 삭제
    private int tk_2 = 0;  // 가상의 적의 말이 11번에 왔을 때 이전말 색 삭제
    private int tk_3 = 0; // 가성의 적의 말이 *에 왔을 때 이전말 색 삭제
    private int uu = 0;
    private int uk = 0;
    private int uu_2 = 0; // 6번에서 대각선버튼
    private int uu_3 = 0; // *버튼에서 오른쪽
    private int uu_5 = 0; // 11번에서 대각선버튼
    private int uk_2 = 0; // 6번에서 대각선버튼의 이전말 색 삭제
    private int uk_3 = 0; // *번에서 대각선버튼의 이전말 색 삭제
    private int uk_5 = 0; // 11번에서 대각선버튼의 이전말 색 삭제
    private int s; // 방향전환버튼을 선택하였을 경우 바뀌는 윷의 추가숫자
    private int s2; // 가상의 적
    private int win = 0; // 승패를 확인하는 용도, 승리시:1 패:0

    public MainFrame() {

        JOptionPane.showMessageDialog(null, "서버 이중 로그인 방지 ");

        client.resultComm = client.idplus(id); // 서버 이중 로그인 방지 하는 것을 만들기
        if (client.resultComm.getStatus() == -1) {
            JOptionPane.showMessageDialog(null, "접속 되어진 아이디가 있습니다. ");
            JOptionPane.showMessageDialog(null, "프로그램을 종료 합니다. ");
            System.exit(1);

        }

        setTitle("메인화면");
        setSize(770, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton state_button = new JButton("상 태");
        state_button.setBounds(637, 185, 105, 49);
        state_button.addActionListener(e -> {
            new Staus();
        });
        getContentPane().add(state_button);


        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 625, 342);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("윷을 던지세요");
        label.setBounds(250, 310, 400, 23);
        panel.add(label);

        JButton btnNewButton = new JButton("11");
        btnNewButton.setEnabled(false);
        btnNewButton.setBounds(29, 22, 53, 23);
        panel.add(btnNewButton);

        JButton button = new JButton("10");
        button.setEnabled(false);
        button.setBounds(126, 22, 53, 23);
        panel.add(button);

        JButton button_1 = new JButton("9");
        button_1.setEnabled(false);
        button_1.setBounds(222, 22, 53, 23);
        panel.add(button_1);

        JButton button_2 = new JButton("8");
        button_2.setEnabled(false);
        button_2.setBounds(318, 22, 53, 23);
        panel.add(button_2);

        JButton button_3 = new JButton("7");
        button_3.setEnabled(false);
        button_3.setBounds(414, 22, 53, 23);
        panel.add(button_3);

        JButton button_4 = new JButton("6");
        button_4.setEnabled(false);
        button_4.setBounds(510, 22, 53, 23);
        panel.add(button_4);

        JButton button_5 = new JButton("12");
        button_5.setEnabled(false);
        button_5.setBounds(29, 74, 53, 23);
        panel.add(button_5);

        JButton button_6 = new JButton("13");
        button_6.setEnabled(false);
        button_6.setBounds(29, 126, 53, 23);
        panel.add(button_6);

        JButton button_7 = new JButton("14");
        button_7.setEnabled(false);
        button_7.setBounds(29, 178, 53, 23);
        panel.add(button_7);

        JButton button_8 = new JButton("15");
        button_8.setEnabled(false);
        button_8.setBounds(29, 230, 53, 23);
        panel.add(button_8);

        JButton button_9 = new JButton("16");
        button_9.setEnabled(false);
        button_9.setBounds(29, 282, 53, 23);
        panel.add(button_9);

        JButton button_10 = new JButton("17");
        button_10.setEnabled(false);
        button_10.setBounds(126, 282, 53, 23);
        panel.add(button_10);

        JButton button_11 = new JButton("18");
        button_11.setEnabled(false);
        button_11.setBounds(222, 282, 53, 23);
        panel.add(button_11);

        JButton button_12 = new JButton("19");
        button_12.setEnabled(false);
        button_12.setBounds(318, 282, 53, 23);
        panel.add(button_12);

        JButton button_13 = new JButton("20");
        button_13.setEnabled(false);
        button_13.setBounds(414, 282, 53, 23);
        panel.add(button_13);

        JButton button_14 = new JButton("1");
        button_14.setEnabled(false);
        button_14.setBounds(510, 282, 53, 23);
        panel.add(button_14);

        JButton button_15 = new JButton("5");
        button_15.setEnabled(false);
        button_15.setBounds(510, 74, 53, 23);
        panel.add(button_15);

        JButton button_16 = new JButton("4");
        button_16.setEnabled(false);
        button_16.setBounds(510, 126, 53, 23);
        panel.add(button_16);

        JButton button_17 = new JButton("3");
        button_17.setEnabled(false);
        button_17.setBounds(510, 178, 53, 23);
        panel.add(button_17);

        JButton button_18 = new JButton("2");
        button_18.setEnabled(false);
        button_18.setBounds(510, 230, 53, 23);
        panel.add(button_18);

        JButton button_19 = new JButton("7*");
        button_19.setEnabled(false);
        button_19.setBounds(414, 74, 53, 23);
        panel.add(button_19);

        JButton button_20 = new JButton("8*");
        button_20.setEnabled(false);
        button_20.setBounds(318, 126, 53, 23);
        panel.add(button_20);

        JButton button_21 = new JButton("9*");
        button_21.setEnabled(false);
        button_21.setBounds(222, 178, 53, 23);
        panel.add(button_21);

        JButton button_22 = new JButton("10*");
        button_22.setEnabled(false);
        button_22.setBounds(126, 230, 53, 23);
        panel.add(button_22);

        JButton button_23 = new JButton("25");
        button_23.setEnabled(false);
        button_23.setBounds(126, 74, 53, 23);
        panel.add(button_23);

        JButton button_24 = new JButton("26");
        button_24.setEnabled(false);
        button_24.setBounds(222, 126, 53, 23);
        panel.add(button_24);

        JButton button_25 = new JButton("27");
        button_25.setEnabled(false);
        button_25.setBounds(318, 178, 53, 23);
        panel.add(button_25);

        JButton button_26 = new JButton("28");
        button_26.setEnabled(false);
        button_26.setBounds(414, 230, 53, 23);
        panel.add(button_26);

        JButton button_27 = new JButton("*");
        button_27.setEnabled(false);
        button_27.setBounds(278, 152, 33, 23);
        panel.add(button_27);

        JButton button_l = new JButton("왼쪽");//6번의 왼쪽버튼
        button_l.setBounds(505, 1, 60, 20);
        panel.add(button_l);

        button_l.addActionListener(e -> {
            if (e.getSource() == button_l && uu == 6) {
                s = 0;
            }
        });

        JButton button_l2 = new JButton("대각선");//6번의 대각선버튼
        button_l2.setBounds(455, 50, 80, 20);
        panel.add(button_l2);
        button_l2.addActionListener(e -> {
            if (e.getSource() == button_l2 && uu == 6) {
                uu_2 = uu;
                uk_2 = uu;
                uu = 0;
                s = 1;
            }
        });

        JButton button_l3 = new JButton("왼쪽");// *의 왼쪽대각선버튼
        button_l3.setBounds(215, 160, 60, 20);
        panel.add(button_l3);
        button_l3.addActionListener(e -> {
            if (e.getSource() == button_l3 && uu_2 == 9) {
                s = 2;
            }
        });

        JButton button_l4 = new JButton("오른쪽");// *의 오른쪽대각선버튼
        button_l4.setBounds(310, 160, 80, 20);
        panel.add(button_l4);
        button_l4.addActionListener(e -> {
            if (e.getSource() == button_l4 && uu_2 == 9) {
                uu_3 = uu;
                uk_3 = uu;
                uu = 0;
                s = 3;
            }
        });

        JButton button_l5 = new JButton("아래");// 11번의 아래버튼
        button_l5.setBounds(29, 1, 60, 20);
        panel.add(button_l5);
        button_l5.addActionListener(e -> {
            if (e.getSource() == button_l5 && uu == 11) {
                s = 4;
            }
        });

        JButton button_l6 = new JButton("대각선");// 11번의 대각선버튼
        button_l6.setBounds(50, 50, 80, 20);
        panel.add(button_l6);
        button_l6.addActionListener(e -> {
            if (e.getSource() == button_l6 && uu == 11) {
                uu_5 = uu;
                uk_5 = uu;
                uu = 0;
                s = 5;
            }
        });


        JButton NextTurnButton = new JButton("턴 넘기기");
        NextTurnButton.addActionListener(e -> {
            if (e.getSource() == NextTurnButton) {
                i = 1 + (int) (Math.random() * 4);

                label.setText("윷을 던지세요");

                if (t > 21 - i || t_1 > 17 - i || t_2 > 17 - i || t_3 > 12 - i) {
                    label.setText("졌습니다");
                    Lose l = new Lose();
                    set_win(l.get_win());
                    System.out.println("win " + win);
                }

                if (s2 == 1) {
                    t_1 = t_1 + i;
                    tk_1 = t_1 - i;
                } else if (s2 == 2) {
                    t_2 = t_2 + i;
                    tk_2 = t_2 - i;
                } else if (s2 == 3) {
                    t_3 = t_3 + i;
                    tk_3 = t_3 - i;
                } else {
                    t = t + i;
                    tk = t - i;
                }

                if (t == 1) {
                    button_14.setBackground(Color.yellow);
                } else if (t == 2) {
                    button_18.setBackground(Color.yellow);
                } else if (t == 3) {
                    button_17.setBackground(Color.yellow);
                } else if (t == 4) {
                    button_16.setBackground(Color.yellow);
                } else if (t == 5) {
                    button_15.setBackground(Color.yellow);
                } else if (t == 6) {
                    button_4.setBackground(Color.yellow);
                    t_1 = t;
                    tk_1 = tk;
                    t = 0;
                    s2 = 1;

                } else if (t == 7) {
                    button_3.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 8) {
                    button_2.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 9) {
                    button_1.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 10) {
                    button.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 11) {
                    btnNewButton.setBackground(Color.yellow);
                    t_2 = t;
                    tk_2 = tk;
                    t = 0;
                    s2 = 2;
                } else if (t == 12) {
                    button_5.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 13) {
                    button_6.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 14) {
                    button_7.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 15) {
                    button_8.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 16) {
                    button_9.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 17) {
                    button_10.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 18) {
                    button_11.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 19) {
                    button_12.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 20) {
                    button_13.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t == 21) {
                    button_14.setBackground(Color.yellow);
                    System.out.println(uu);
                }

                //이전 말 색 삭제
                if (tk == 1) {
                    button_14.setBackground(null);
                } else if (tk == 2) {
                    button_18.setBackground(null);
                } else if (tk == 3) {
                    button_17.setBackground(null);
                } else if (tk == 4) {
                    button_16.setBackground(null);
                } else if (tk == 5) {
                    button_15.setBackground(null);
                } else if (tk == 6) {
                    button_4.setBackground(null);
                } else if (tk == 7) {
                    button_3.setBackground(null);
                } else if (tk == 8) {
                    button_2.setBackground(null);
                } else if (tk == 9) {
                    button_1.setBackground(null);
                } else if (tk == 10) {
                    button.setBackground(null);
                } else if (tk == 11) {
                    btnNewButton.setBackground(null);
                } else if (tk == 12) {
                    button_5.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 13) {
                    button_6.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 14) {
                    button_7.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 15) {
                    button_8.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 16) {
                    button_9.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 17) {
                    button_10.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 18) {
                    button_11.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 19) {
                    button_12.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 20) {
                    button_13.setBackground(null);
                    System.out.println(uu);
                } else if (tk == 21) {
                    button_14.setBackground(null);
                    System.out.println(uu);
                }

                //6번에 왔을 때
                if (t_1 == 7) {
                    button_19.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_1 == 8) {
                    button_20.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_1 == 9) {
                    button_27.setBackground(Color.yellow);
                    t_3 = t_1;
                    t_1 = 0;
                    tk_3 = tk_1;
                    s2 = 3;
                    System.out.println(uu);
                } else if (t_1 == 10) {
                    button_21.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_1 == 11) {
                    button_22.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_1 == 12) {
                    button_9.setBackground(Color.yellow);
                } else if (t_1 == 13) {
                    button_10.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_1 == 14) {
                    button_11.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_1 == 15) {
                    button_12.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_1 == 16) {
                    button_13.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_1 == 17) {
                    button_14.setBackground(Color.yellow);
                    System.out.println(uu);
                }


                //6번에서 이전 말의 색 삭제
                if (tk_1 == 7) {
                    button_19.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 8) {
                    button_20.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 9) {
                    button_27.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 10) {
                    button_21.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 11) {
                    button_22.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 12) {
                    button_9.setBackground(null);
                } else if (tk_1 == 13) {
                    button_10.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 14) {
                    button_11.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 15) {
                    button_12.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 16) {
                    button_13.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 17) {
                    button_14.setBackground(null);
                    System.out.println(uu);
                } else if (tk_1 == 6) {
                    button_4.setBackground(null);
                }

                //11번에 왔을 때,
                if (t_2 == 15) {
                    button_25.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_2 == 16) {
                    button_26.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_2 == 17) {
                    button_14.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_2 == 12) {
                    button_23.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_2 == 13) {
                    button_24.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_2 == 14) {
                    button_27.setBackground(Color.yellow);
                    System.out.println(uu);
                }

                //11번버튼에서 이전말 색 삭제
                if (tk_2 == 15) {
                    button_25.setBackground(null);
                    System.out.println(uu);
                } else if (tk_2 == 16) {
                    button_26.setBackground(null);
                    System.out.println(uu);
                } else if (tk_2 == 17) {
                    button_14.setBackground(null);
                    System.out.println(uu);
                } else if (tk_2 == 12) {
                    button_23.setBackground(null);
                    System.out.println(uu);
                } else if (tk_2 == 13) {
                    button_24.setBackground(null);
                    System.out.println(uu);
                } else if (tk_2 == 14) {
                    button_27.setBackground(null);
                    System.out.println(uu);
                } else if (tk_2 == 11) {
                    btnNewButton.setBackground(null);
                }

                //*에 왔을 때
                if (t_3 == 10) {
                    button_25.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_3 == 11) {
                    button_26.setBackground(Color.yellow);
                    System.out.println(uu);
                } else if (t_3 == 12) {
                    button_14.setBackground(Color.yellow);
                    System.out.println(uu);
                }

                //*버튼에서 이전말 색 삭제
                if (tk_3 == 10) {
                    button_25.setBackground(null);
                    System.out.println(uu);
                } else if (tk_3 == 11) {
                    button_26.setBackground(null);
                    System.out.println(uu);
                } else if (tk_3 == 12) {
                    button_14.setBackground(null);
                    System.out.println(uu);
                } else if (tk_3 == 9) {
                    button_27.setBackground(null);
                    System.out.println(uu);
                }
            }
        });

        NextTurnButton.setBounds(637, 244, 105, 49);
        getContentPane().add(NextTurnButton);

        JButton button_31 = new JButton("윷던지기");
        button_31.setBounds(637, 303, 105, 49);
        getContentPane().add(button_31);
        button_31.addActionListener(e -> {

            if (yutchecknum == 0) {

                Yut u = new Yut();

                if (uu > 21 - u.getI() || uu_2 > 17 - u.getI() || uu_3 > 13 - u.getI() || uu_5 > 18 - u.getI()) {
                    label.setText("승리하였습니다");
                    Win w = new Win();
                    set_win(w.get_win()); // 승리하였으므로 win = 0대입
                }

                if (u.getI() == 4 || u.getI() == 5) {
                    label.setText("윷을 한번 더 던지세요");
                } else {
                    label.setText("턴을 넘기세요");
                }

                if (s == 1) { // 6번의 대갹선
                    uu_2 = uu_2 + u.getI();
                    uk_2 = uu_2 - u.getI();
                } else if (s == 0) { // 6번의 왼쪽
                    uu = uu + u.getI();
                    uk = uu - u.getI();
                } else if (s == 2) { // *의 왼쪽
                    uu_2 = uu_2 + u.getI();
                    uk_2 = uu_2 - u.getI();
                } else if (s == 3) { // *의 오른쪽
                    uu_3 = uu_3 + u.getI();
                    uk_3 = uu_3 - u.getI();
                } else if (s == 4) { // 11번의 아래
                    uu = uu + u.getI();
                    uk = uu - u.getI();
                } else if (s == 5) { // 11번의 대각선
                    uu_5 = uu_5 + u.getI();
                    uk_5 = uu_5 - u.getI();
                } else {
                    uu = uu + u.getI();
                    uk = uu - u.getI();
                }

                //다음 말로 넘어갈 때, 이전 말의 좌표의 색을 없애기
                if (uk == 1) {
                    button_14.setBackground(null);
                } else if (uk == 2) {
                    button_18.setBackground(null);
                } else if (uk == 3) {
                    button_17.setBackground(null);
                } else if (uk == 4) {
                    button_16.setBackground(null);
                } else if (uk == 5) {
                    button_15.setBackground(null);
                } else if (uk == 6) {
                    button_4.setBackground(null);
                } else if (uk == 7) {
                    button_3.setBackground(null);
                } else if (uk == 8) {
                    button_2.setBackground(null);
                } else if (uk == 9) {
                    button_1.setBackground(null);
                } else if (uk == 10) {
                    button.setBackground(null);
                } else if (uk == 11) {
                    btnNewButton.setBackground(null);
                } else if (uk == 12) {
                    button_5.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 13) {
                    button_6.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 14) {
                    button_7.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 15) {
                    button_8.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 16) {
                    button_9.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 17) {
                    button_10.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 18) {
                    button_11.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 19) {
                    button_12.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 20) {
                    button_13.setBackground(null);
                    System.out.println(uu);
                } else if (uk == 21) {
                    button_14.setBackground(null);
                    System.out.println(uu);
                }

                if (uu == 1) {
                    button_14.setBackground(Color.red);
                } else if (uu == 2) {
                    button_18.setBackground(Color.red);
                } else if (uu == 3) {
                    button_17.setBackground(Color.red);
                } else if (uu == 4) {
                    button_16.setBackground(Color.red);
                } else if (uu == 5) {
                    button_15.setBackground(Color.red);
                } else if (uu == 6) {
                    button_4.setBackground(Color.red);
                    label.setText("진행방향 버튼을 누른후 턴을 넘기세요");
                } else if (uu == 7) {
                    button_3.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 8) {
                    button_2.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 9) {
                    button_1.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 10) {
                    button.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 11) {
                    btnNewButton.setBackground(Color.red);
                    label.setText("진행방향 버튼을 누른후 턴을 넘기세요");
                } else if (uu == 12) {
                    button_5.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 13) {
                    button_6.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 14) {
                    button_7.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 15) {
                    button_8.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 16) {
                    button_9.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 17) {
                    button_10.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 18) {
                    button_11.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 19) {
                    button_12.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 20) {
                    button_13.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu == 21) {
                    button_14.setBackground(Color.red);
                    System.out.println(uu);
                }

                // 6번에서 대각선 버튼을 눌렀을 경우
                if (uu_2 == 7) {
                    button_19.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_2 == 8) {
                    button_20.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_2 == 9) {
                    button_27.setBackground(Color.red);
                    System.out.println(uu);
                    label.setText("진행방향 버튼을 누른후 턴을 넘기세요");
                } else if (uu_2 == 10) {
                    button_21.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_2 == 11) {
                    button_22.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_2 == 12) {
                    button_9.setBackground(Color.red);
                } else if (uu_2 == 13) {
                    button_10.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_2 == 14) {
                    button_11.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_2 == 15) {
                    button_12.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_2 == 16) {
                    button_13.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_2 == 17) {
                    button_14.setBackground(Color.red);
                    System.out.println(uu);
                }

                //6번에서 대각선 버튼을 눌렀을 때, 이전 말의 색 삭제
                if (uk_2 == 7) {
                    button_19.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 8) {
                    button_20.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 9) {
                    button_27.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 10) {
                    button_21.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 11) {
                    button_22.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 12) {
                    button_9.setBackground(null);
                } else if (uk_2 == 13) {
                    button_10.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 14) {
                    button_11.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 15) {
                    button_12.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 16) {
                    button_13.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 17) {
                    button_14.setBackground(null);
                    System.out.println(uu);
                } else if (uk_2 == 6) {
                    button_4.setBackground(null);
                }

                //*에서 오른쪽을 눌렀을 경우
                if (uu_3 == 10) {
                    button_25.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_3 == 11) {
                    button_26.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_3 == 12) {
                    button_14.setBackground(Color.red);
                    System.out.println(uu);
                }

                //*에서 오른쪽을 눌렀을 경우의 이전 말 삭제
                if (uk_3 == 10) {
                    button_25.setBackground(null);
                    System.out.println(uu);
                } else if (uk_3 == 11) {
                    button_26.setBackground(null);
                    System.out.println(uu);
                } else if (uk_3 == 12) {
                    button_14.setBackground(null);
                    System.out.println(uu);
                } else if (uk_3 == 9) {
                    button_27.setBackground(null);
                    System.out.println(uu);
                }


                //11번버튼에서 대각선을 눌렀을 경우
                if (uu_5 == 15) {
                    button_25.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_5 == 16) {
                    button_26.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_5 == 17) {
                    button_14.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_5 == 12) {
                    button_23.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_5 == 13) {
                    button_24.setBackground(Color.red);
                    System.out.println(uu);
                } else if (uu_5 == 14) {
                    button_27.setBackground(Color.red);
                    System.out.println(uu);
                    label.setText("진행방향 버튼을 누른후 턴을 넘기세요");
                }

                //11번버튼에서 대각선을 눌렀을 경우의 이전말 색 삭제
                if (uk_5 == 15) {
                    button_25.setBackground(null);
                    System.out.println(uu);
                } else if (uk_5 == 16) {
                    button_26.setBackground(null);
                    System.out.println(uu);
                } else if (uk_5 == 17) {
                    button_14.setBackground(null);
                    System.out.println(uu);
                } else if (uk_5 == 12) {
                    button_23.setBackground(null);
                    System.out.println(uu);
                } else if (uk_5 == 13) {
                    button_24.setBackground(null);
                    System.out.println(uu);
                } else if (uk_5 == 14) {
                    button_27.setBackground(null);
                    System.out.println(uu);
                } else if (uk_5 == 11) {
                    btnNewButton.setBackground(null);
                }


                yutchecknum = 0;
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);

    }


    public void set_win(int w) {
        this.win = w;
    }

    class Win extends JFrame {
        private int win = 1;

        public Win() {
            client.resultComm = client.pluswin(user.getID());
            JLabel label = new JLabel("WIN!");
            label.setFont(new Font("Serif", Font.BOLD, 100));

            setTitle("승");
            setSize(300, 300);
            add(label);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

        }


        int get_win() {
            return win;
        }

    }

    class Lose extends JFrame {
        private int win = 0;

        public Lose() {

            JLabel label = new JLabel("LOSE");
            label.setFont(new Font("Serif", Font.BOLD, 100));

            setTitle("패");
            setSize(300, 300);
            add(label);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

        }


        int get_win() {
            return win;
        }

    }

    class Staus extends JFrame {

        public Staus() { // Frame 상태에서는 쓰레드를 호환을 할 수 가 없다. ? --> 버튼을 눌러서 확인을 하는 방법을 사용

            setTitle("자바 스테이터스 테스트");
            setSize(300, 300);
            setDefaultCloseOperation(3);
            setLocation(1200, 300);
            getContentPane().setLayout(null);

            JButton usersequence = new JButton("레  벨");
            usersequence.setBounds(153, 21, 119, 38);

            usersequence.addActionListener(e -> {
                System.out.println(id);
                client.resultComm = client.level(id);
                JOptionPane.showMessageDialog(null, "레벨을 확인 합니다. "); //핸들러로 보낸다.

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



