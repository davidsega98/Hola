package view;


import controller.Controller;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class BackgroundImageJFrame extends JPanel {

    private JLabel l1;
    private Timer t;
    private Clip clip;
    private Image bg = new ImageIcon("data/display/giphy.gif").getImage();

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
    public void registerController(Controller controller){
      this.addKeyListener(controller);
  }

    public Image getBg() {
        return bg;
    }

    public void setBg(int actualLayout) {
        if(actualLayout>4) {
            this.bg = new ImageIcon("data/display/TronerBueno.gif").getImage();
        }else{
            this.bg = new ImageIcon("data/display/giphy.gif").getImage();
        }
        }
}

