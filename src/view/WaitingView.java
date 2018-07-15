package view;
import javax.swing.*;
import java.awt.*;






public class WaitingView extends JPanel {
    private Image bg = new ImageIcon("data/display/giphy.gif").getImage();
    private JLabel jLabel = new JLabel("                                                                WAITING FOR OTHER PLAYERS :)");




    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
    public WaitingView(){
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        Font fuente = new Font("data/fonts/font3.ttf", Font.BOLD, 15);
        jLabel.setFont(fuente);
        jLabel.setForeground(new Color(255,255,255));
        this.add(jLabel, BorderLayout.CENTER);
    }
}