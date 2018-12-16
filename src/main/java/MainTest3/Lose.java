package MainTest3;

import javax.swing.*;
import java.awt.*;

public class Lose extends JFrame {

    public Lose() {

        JLabel label = new JLabel("LOSE");
        label.setFont(new Font("Serif", Font.BOLD, 100));

        setTitle("패");
        setSize(300, 300);
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Lose();
    }

}
