package Cotroller.main;

import javax.swing.*;

public class MainActivity extends JFrame{
    private JPanel main_panel;
    private JButton button1;
    private JButton button2;

    public MainActivity() {
        setTitle("메인 화면");
        setContentPane(main_panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}
