package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class ConnexionView extends JPanel{

    private JButton jbBack;
    private JTextField jtfDirection;
    private JLabel jlUsername;
    private JTextField jtfIp;
    private JLabel jlPort;
    private JButton jbConnect;
    private Font font;
    private Image img;
    private Image icon;
    private Image muteImg;
    private Image muteIcon;
   // private JButton jbMute;
    private JFrame jfBackground;
    private boolean activateU;
    private boolean activateP;

    public ConnexionView() {
        this.setOpaque(false);
        //this.setLayout(new GridBagLayout());
        this.setOpaque(false);

        createButtons();
        createTextField();
        addComponents();
    }

    public void registerControllerConnexionView(Controller controller) {
        jbConnect.addActionListener(controller);
        jbConnect.setActionCommand("StartConnexion");
        jbBack.addActionListener(controller);
        jtfIp.setActionCommand("Port");
        jbBack.setActionCommand("Exit");
        jtfDirection.addActionListener(controller);
        jtfDirection.setActionCommand("DirectionIP");
        jtfIp.addActionListener(controller);
        registerControllerFocus(controller);


    }
    public void registerControllerFocus(FocusListener controller){
        jtfDirection.addFocusListener(controller);
        jtfIp.addFocusListener(controller);
    }
        public void registerControllerMouse(MouseListener controller) {
        jbConnect.addMouseListener(controller);
    //    jbMute.addMouseListener(controller);
        jbBack.addMouseListener(controller);
        jtfIp.addMouseListener(controller);
        jtfDirection.addMouseListener(controller);

    }

    public void augmentButtons(String button, float x) {
        if(button.equals("Back")){
            icon = img.getScaledInstance((int)x, (int)x, Image.SCALE_DEFAULT);
            jbBack.setIcon(new ImageIcon(icon));
            /*
        }else if(button.equals("Mute")){
            muteIcon = muteImg.getScaledInstance((int)x,(int)x, Image.SCALE_DEFAULT);
            jbMute.setIcon(new ImageIcon(muteIcon));
            */
        }else if(button.equals("Log")){
            font = font.deriveFont(x);
            jbConnect.setOpaque(false);
            jbConnect.setFont(font);
        }

    }

    public void createTextField() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("data/fonts/GearsOfPeace.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(25f);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jtfIp = new JTextField("Set Port");
        jtfDirection = new JTextField("Set Direction IP");
        jtfDirection.setFont(jtfDirection.getFont().deriveFont(Font.PLAIN, 15f));
        jtfIp.setFont(jtfIp.getFont().deriveFont(Font.PLAIN, 15));
        jtfDirection.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));
        jtfIp.setForeground(Color.gray.brighter());
        jtfDirection.setForeground(Color.gray.brighter());

        jtfIp.setPreferredSize(new Dimension(200,10));
        jtfDirection.setPreferredSize(new Dimension(200,10));


        jtfIp.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));



        jlPort = new JLabel("  PORT: ");
        jlPort.setFont(font);
        jlPort.setForeground(new Color(157, 207, 222));
        jlUsername = new JLabel("  DIRECTION IP: ");
        jlUsername.setFont(font);
        jlUsername.setForeground(new Color(157, 207, 222));

    }


    public void createButtons() {
        jbBack = new JButton();
        try {
            img = new ImageIcon("data/display/neon.png").getImage();
            icon = img.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
            //img.getScaledInstance(2,2,Image.SCALE_FAST);
            jbBack.setIcon(new ImageIcon(icon));
            jbBack.setOpaque(false);
            jbBack.setContentAreaFilled(false);
            jbBack.setBorderPainted(false);
            jbBack.setFocusPainted(false);
            jbBack.setFocusPainted(false);
            jbBack.setSize(new Dimension(40, 40));

            font = Font.createFont(Font.TRUETYPE_FONT, new File("data/fonts/GearsOfPeace.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(30f);

            jbConnect = new JButton("ENTER GAME");
            jbConnect.setFont(font);
            jbConnect.setContentAreaFilled(false);
            jbConnect.setFocusPainted(false);
            jbConnect.setBorder(BorderFactory.createEmptyBorder());
            jbConnect.setOpaque(false);//enable this to create a button border
            jbConnect.setForeground(new Color(157, 207, 222));
            /*
            muteImg = new ImageIcon("data/display/neonmute.png").getImage();
            muteIcon = muteImg.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
            jbMute = new JButton();
            jbMute.setIcon(new ImageIcon(muteIcon));
            jbMute.setOpaque(false);
            jbMute.setContentAreaFilled(false);
            jbMute.setBorderPainted(false);
            jbMute.setFocusPainted(false);
            jbMute.setFocusPainted(false);
            jbMute.setSize(new Dimension(40, 40));
            */
        } catch (Exception ex) {
            System.out.println(ex);

        }

    }



    public void addComponents() {
        this.setLayout(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();
        // c.weighty = 5;


        JPanel jpButtons = new JPanel();
        jpButtons.setOpaque(false);
        jpButtons.setLayout(new BorderLayout());
        jpButtons.add(jbBack,BorderLayout.LINE_START);
       // jpButtons.add(jbMute,BorderLayout.LINE_END);

        JPanel jpNorth = new JPanel();
        jpNorth.setLayout(new GridLayout(2,1));
        jpNorth.add(jpButtons);
        JPanel empty = new JPanel();
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("data/fonts/GearsOfPeace.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(40f);

        }catch (Exception e){

        }

        JLabel jLabel = new JLabel(" ");
        jLabel.setForeground(new Color(250,100,250));
        jLabel.setFont(font);

        empty.add(jLabel);
        empty.setOpaque(false);
        empty.setPreferredSize(new Dimension(20,120));
        jpNorth.add(empty);
        jpNorth.setOpaque(false);


        JPanel jpaux2 = new JPanel();
        JPanel empty2 = new JPanel();
        JPanel empty3 = new JPanel();


        JPanel jpAux=new JPanel();
        jpAux.setOpaque(false);
        jpAux.setLayout(new GridLayout(4,2,1,10));
        jpAux.add(jlUsername);
        jpAux.add(jtfDirection);
        empty2.setPreferredSize(new Dimension(40,20));
        empty2.setOpaque(false);
        empty3.setPreferredSize(new Dimension(40,90));
        empty3.setOpaque(false);
        jpAux.add(empty2);
        jpAux.add(empty3);

        jpAux.add(jlPort);
        jpAux.add(jtfIp);
        jpAux.add(jpaux2);
        jpAux.add(jbConnect);

        JPanel jpEmpty = new JPanel();
        JPanel jpEmpty1 = new JPanel();
        JPanel jpEmpty2 = new JPanel();

        jpEmpty.setPreferredSize(new Dimension(160,20));
        jpEmpty1.setPreferredSize(new Dimension(150,50));
        jpEmpty2.setPreferredSize(new Dimension(100,130));

        jpEmpty.setOpaque(false);
        jpEmpty2.setOpaque(false);
        jpEmpty1.setOpaque(false);

        this.add(jpEmpty,BorderLayout.LINE_START);
        this.add(jpEmpty1,BorderLayout.LINE_END);
        this.add(jpEmpty2,BorderLayout.SOUTH);


        c.weighty = 10;
        c.gridx = 5;
        c.gridy = 3;
        c.ipadx = 1;
        JPanel jpaux = new JPanel();
        jpaux.setPreferredSize(new Dimension(50, 50));
        jpaux.setOpaque(false);
        // add(jpaux, c);

        c.weighty = 10;
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 1;
        jpaux2.setPreferredSize(new Dimension(40, 10));
        jpaux2.setOpaque(false);
        //add(jpaux2, c);

        this.add(jpNorth,BorderLayout.NORTH);
        this.add(jpAux,BorderLayout.CENTER);


    }
    public void disaugmentButton(String button, float x) {
        if (button.equals("Log")) {
            font = font.deriveFont(x);
            jbConnect.setFont(font);
            jbConnect.setOpaque(false);

        }

    }

    public void changeTextField(String name){
        if(name.equals("DirectionIP")){
            System.out.println("hola");
            jtfDirection.setText("");
            jtfDirection.setForeground(Color.black);
        }else if(name.equals("Port")){
            jtfIp.setText("");
            jtfIp.setForeground(Color.black);
        }
    }

    public void changeTextFields(String directionIP) {
    }


    class CustomeBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            // TODO Auto-generated method stubs
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint paint = new GradientPaint( x, y, new Color(157, 207, 222), x , y +height, Color.WHITE, false );
            g2d.setPaint(paint);
            g2d.setStroke(new BasicStroke(12));
            //g2d.setColor(new Color(157, 207, 222));
            g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
            g2d.setStroke( new BasicStroke() );

        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 220));
        int x = (int)(this.getWidth() / 18) ;
        int y = (int)((float)(this.getHeight() / 5.4));
        g.fillRoundRect(x, y, (int)((float)(this.getWidth()*0.9)), (int)((float)this.getHeight()/3)+((int)((float)this.getHeight()/3)), 25, 25);

    }

    public String getUsername(){
        return jtfDirection.getText();
    }
    public String getContent(){
        String password = new String(jtfIp.getText());
        return password;
    }
    public void changeTextFieldEmpty(String name){
        if(name.equals("DirectionIP")){
            if (jtfDirection.getText().equals("")) {
                jtfDirection.setText("Set Direction IP");
                jtfDirection.setForeground(Color.LIGHT_GRAY);
            }

        }
        if(name.equals("Port")){
            if(jtfIp.getText().equals("")) {
                jtfIp.setText("Set Port");
                jtfIp.setForeground(Color.lightGray);
            }
        }
    }


    public JTextField getjtfIp() {
        return jtfIp;
    }

    public void setjtfIp(JTextField jtfIp) {
        this.jtfIp = jtfIp;
    }

    public JTextField getJtfDirection() {
        return jtfDirection;
    }

    public void setJtfDirection(JTextField jtfDirection) {
        this.jtfDirection = jtfDirection;
    }

}
