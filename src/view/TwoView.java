package view;

import javax.swing.*;
import java.awt.*;
//AQUESTA ES LA VISTA BONA PER TOTS ES NUMEROS DEL COUNTDOWN
public class TwoView extends JPanel {
    private Image bg = new ImageIcon("data/display/giphy.gif").getImage();
    private JLabel jLabel = new JLabel("     2");

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
    public TwoView(){
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        Font fuente = new Font("data/fonts/font3.ttf", Font.BOLD, 250);
        jLabel.setFont(fuente);
        jLabel.setForeground(new Color(255,255,255));
        this.add(jLabel, BorderLayout.CENTER);

    }
}
