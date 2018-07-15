package view;

import javax.swing.*;

public class CountDownView extends JFrame {


    private JLabel timeLeft;


    public CountDownView() {
        setSize(100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jp = new JPanel();
        timeLeft = new JLabel("10");
        jp.add(timeLeft);
        getContentPane().add(jp);
    }


    public JLabel getTimeLeft() {
        return timeLeft;
    }


}

