package MainTest3;

import MainTest.Client;
import MainTest.User;

import javax.swing.*;
import java.awt.*;

public class Win extends JFrame {
    private Client client;
    private User user;
    public Win() {
        client.resultComm = client.pluswin(user.getID());

        JLabel label = new JLabel("WIN!");
        label.setFont(new Font("Serif", Font.BOLD, 100));
        setTitle("승리화면");
        setSize(300, 300);
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Win();
    }

}
