package view;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class LabelClass extends JPanel {
    private JLabel l1;
    private JLabel label2;
    private Clip clip;

    public LabelClass(){
        try {
            this.setOpaque(true);
            GridBagLayout gridbag = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            this.setLayout(gridbag);
            this.setOpaque(false);
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("data/fonts/outriderchromeital.ttf"));
            l1 = new JLabel(" TRONER ");
            label2 = new JLabel("1 CREDIT PRESS ENTER BUTTON ");
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(142f);
            l1.setFont(font);
            c.fill = GridBagConstraints.NORTH;
            c.weighty = 3;
            c.gridx = 0;
            c.weightx = 0;
            gridbag.setConstraints(l1,c);
            this.add(l1);
            c.fill = GridBagConstraints.SOUTH;
            c.weighty = 4;
            c.gridx = 0;
            c.weightx = 0;
            label2.setFont(font.deriveFont(30f));
            gridbag.setConstraints(label2,c);
            this.add(label2);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e1) {
            e1.printStackTrace();

        }


    }


    public void setFade(int r, int g, int b, int x) {
        l1.setForeground(new Color(157, 207,222, x));
        label2.setForeground(new Color(157, 207,222,x));
        this.repaint();
    }
}
