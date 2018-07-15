package view;

import model.User;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class LogInPanel extends JPanel {
    private JButton jbBack;
    private JTextField jtfUsername;
    private JLabel jlUsername;
    private JPasswordField jtfPassword;
    private JLabel jlPassword;
    private JButton jbLogin;
    private Font font;
    private Image img;
    private Image icon;
    private Image muteImg;
    private Image muteIcon;


    private JButton jbMute;
    private JFrame jfBackground;
    private boolean activateU;
    private boolean activateP;

    public LogInPanel() {
        this.setOpaque(false);
        //this.setLayout(new GridBagLayout());
        this.setOpaque(false);

        createButtons();
        createTextField();
        addComponents();
    }

    public void registerControllerButton(ActionListener controller) {
        jbLogin.addActionListener(controller);
        jbLogin.setActionCommand("Login");
        jbBack.addActionListener(controller);
        jbBack.setActionCommand("Return");
        jbMute.addActionListener(controller);
        jbMute.setActionCommand("Mute");
        jtfUsername.addActionListener(controller);
        jtfPassword.addActionListener(controller);
    }

    public void registerControllerFocus(FocusListener controller){
        jtfUsername.addFocusListener(controller);
        jtfPassword.addFocusListener(controller);
    }

    public void registerControllerMouse(MouseListener controller) {
        jbLogin.addMouseListener(controller);
        jbMute.addMouseListener(controller);
        jbBack.addMouseListener(controller);
        jtfPassword.addMouseListener(controller);
        jtfUsername.addMouseListener(controller);

    }

    public void augmentButtons(String button, float x) {
        if(button.equals("Back")){
            icon = img.getScaledInstance((int)x, (int)x, Image.SCALE_DEFAULT);
            jbBack.setIcon(new ImageIcon(icon));

        }else if(button.equals("Mute")){
            muteIcon = muteImg.getScaledInstance((int)x,(int)x, Image.SCALE_DEFAULT);
            jbMute.setIcon(new ImageIcon(muteIcon));

        }else if(button.equals("Log")){
            font = font.deriveFont(x);
            jbLogin.setOpaque(false);
            jbLogin.setFont(font);
        }

    }

    public void createTextField() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("data/font2.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(25f);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jtfPassword = new JPasswordField("Minimum 8 carachters");
        jtfUsername = new JTextField("Please input User Name");
        jtfUsername.setFont(jtfUsername.getFont().deriveFont(Font.PLAIN, 15f));
        jtfPassword.setFont(jtfPassword.getFont().deriveFont(Font.PLAIN, 15));
        jtfUsername.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));
        jtfPassword.setForeground(Color.gray.brighter());
        jtfUsername.setForeground(Color.gray.brighter());

        jtfPassword.setPreferredSize(new Dimension(200,10));
        jtfUsername.setPreferredSize(new Dimension(200,10));


        jtfPassword.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));



        jlPassword = new JLabel("  Password: ");
        jlPassword.setFont(font);
        jlPassword.setForeground(new Color(157, 207, 222));
        jlUsername = new JLabel("  Username: ");
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

            font = Font.createFont(Font.TRUETYPE_FONT, new File("data/font2.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(30f);

            jbLogin = new JButton("LOG IN");
            jbLogin.setFont(font);
            jbLogin.setContentAreaFilled(false);
            jbLogin.setFocusPainted(false);
            jbLogin.setBorder(BorderFactory.createEmptyBorder());
            jbLogin.setOpaque(false);//enable this to create a button border
            jbLogin.setForeground(new Color(157, 207, 222));

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
        jpButtons.add(jbMute,BorderLayout.LINE_END);

        JPanel jpNorth = new JPanel();
        jpNorth.setLayout(new GridLayout(2,1));
        jpNorth.add(jpButtons);
        JPanel empty = new JPanel();
        empty.setOpaque(false);
        empty.setPreferredSize(new Dimension(20,110));
        jpNorth.add(empty);
        jpNorth.setOpaque(false);


        JPanel jpaux2 = new JPanel();
        JPanel empty2 = new JPanel();
        JPanel empty3 = new JPanel();


        JPanel jpAux=new JPanel();
        jpAux.setOpaque(false);
        jpAux.setLayout(new GridLayout(4,2,1,10));
        jpAux.add(jlUsername);
        jpAux.add(jtfUsername);
        empty2.setPreferredSize(new Dimension(40,90));
        empty2.setOpaque(false);
        empty3.setPreferredSize(new Dimension(40,90));
        empty3.setOpaque(false);
        jpAux.add(empty2);
        jpAux.add(empty3);

        jpAux.add(jlPassword);
        jpAux.add(jtfPassword);
        jpAux.add(jpaux2);
        jpAux.add(jbLogin);

        JPanel jpEmpty = new JPanel();
        JPanel jpEmpty1 = new JPanel();
        JPanel jpEmpty2 = new JPanel();

        jpEmpty.setPreferredSize(new Dimension(200,50));
        jpEmpty1.setPreferredSize(new Dimension(170,50));
        jpEmpty2.setPreferredSize(new Dimension(100,120));

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

        c.weighty = 10;
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 1;
        jpaux2.setPreferredSize(new Dimension(30, 10));
        jpaux2.setOpaque(false);

        this.add(jpNorth,BorderLayout.NORTH);
        this.add(jpAux,BorderLayout.CENTER);


    }
    public void disaugmentButton(String button, float x) {
        if (button.equals("Log")) {
            font = font.deriveFont(x);
            jbLogin.setFont(font);
            jbLogin.setOpaque(false);
        }
    }

    public void changeTextField(String name){
        if(name.equals("UsernameL")){
            jtfUsername.setText("");
            jtfUsername.setForeground(Color.black);
        }
        if(name.equals("PasswordL")){
            jtfPassword.setText("");
            jtfPassword.setForeground(Color.black);
        }
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
        g.setColor(new Color(45, 25, 63, 150));
        int x = (this.getWidth() / 2) - 300;
        int y = (this.getHeight() / 2) - 100;
        g.fillRoundRect(x, y, 660 - 1, 275 - 1, 25, 25);

    }

    public String getUsername(){
        return jtfUsername.getText();
    }
    public String getPassword(){
        String password = new String(jtfPassword.getPassword());
        return password;
    }

    public void changeTextFieldEmpty(String name){
        if(name.equals("UsernameL")){
            if (jtfUsername.getText().equals("")) {
                jtfUsername.setText("Please input User Name");
                jtfUsername.setForeground(Color.LIGHT_GRAY);
            }

        }
        if(name.equals("PasswordL")){
            if(getPassword().equals("")) {
                jtfPassword.setText("Minimum 8 carachters");
                jtfPassword.setForeground(Color.lightGray);
            }
        }
    }

     public User getUserLogin(){
        String username = jtfUsername.getText();
        String password = getPassword();
        User u = new User(username, password, " ", " ", " ");
        return u;
     }


    public JTextField getJtfUsername() {
        return jtfUsername;
    }

    public JPasswordField getJtfPassword() {
        return jtfPassword;
    }
}