package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class LogSignPanel extends JPanel{
    private JButton jbLogin = new JButton(" LOG IN ");
    private JButton jbSingin;
    private  Font font;

    public LogSignPanel(){
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("data/fonts/font2.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(30f);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        jbSingin = new JButton("SIGN IN");
        this.setLayout(new GridLayout(11,2));


        jbLogin.setFont(font);
        jbSingin.setFont(font);

        jbLogin.setContentAreaFilled(false);
        jbSingin.setContentAreaFilled(false);

        jbLogin.setFocusPainted(false);
        jbSingin.setFocusPainted(false);

        jbLogin.setBorder(BorderFactory.createEmptyBorder());
        jbSingin.setBorder(BorderFactory.createEmptyBorder());

        jbLogin.setOpaque(false);//enable this to create a button border
        jbSingin.setOpaque(false);//enable this to create a button border

        jbLogin.setForeground(new Color(157, 207, 222));
        jbSingin.setForeground(new Color(157, 207, 222));


        int i = 11;
        int j = 2;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i,j));

        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setOpaque(false);
                add(panelHolder[m][n]);
            }
        }
        setOpaque(false);
        panelHolder[5][0].add(jbSingin);
        panelHolder[5][1].add(jbLogin);







    }

    public void registerControllerMouse(MouseListener controller){
        jbSingin.addMouseListener(controller);
        jbLogin.addMouseListener(controller);

    }
    public void registerControllerButtons(ActionListener controller){
        jbSingin.addActionListener(controller);
        jbSingin.setActionCommand("S");
        jbLogin.addActionListener(controller);
        jbLogin.setActionCommand("L");
    }



    public void augmentButtons(String button, float x){
        if(button.equals("S")){
            font = font.deriveFont(x);
            //jbSingin.setBackground(new Color(70, 207, 222, 50));
            jbSingin.setOpaque(false);
            jbSingin.setFont(font);
        }
        if(button.equals("L")){
            font = font.deriveFont(x);
            jbLogin.setOpaque(false);
            //jbLogin.setBackground(new Color(70, 207, 222, 50));
            jbLogin.setFont(font);
        }
    }

    public void disaugmentButton(String button, float x){
        if(button.equals("S")){
            font = font.deriveFont(x);
            jbSingin.setFont(font);
            jbSingin.setOpaque(false);

        }
        if(button.equals("L")){
            font = font.deriveFont(x);
            jbLogin.setFont(font);
            jbLogin.setOpaque(false);

        }

    }



}


