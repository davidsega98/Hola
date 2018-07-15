package view;



import controller.Controller;
import controller.FunctionController;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuView extends JPanel {
    private JButton jButton;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JTable jTable;
    private TableModel model;
    private JLabel name;
    private JLabel game2;
    private JLabel game4;
    private JLabel tournament;
    private MyPanel jPanel;
    private JPanel jPanel2;
    private JList<User> userJList;
    private MainView mainView;

    private JLabel jlWaitPlayer;


    Image bg = new ImageIcon("data/display/giphy.gif").getImage();

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }


    public MenuView(MainView mainView) {
        this.setFocusable(true);
        this.setLayout(null);


       // jButton.setOpacity((float) 0.5);
       // jButton.repaint();
       // jButton.setText("1");
        //jButton.setBorder(null);
        jlWaitPlayer = new JLabel("");
        jButton = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        //Buttons size and position
        jButton.setBounds((int) (mainView.getWidth() / 120 + (0.06) * (mainView.getWidth())), (int) (mainView.getHeight() / 12), 150 + (int) (mainView.getWidth() / 8), 30 + (int) (mainView.getHeight() / 8));
        jButton2.setBounds((int) (mainView.getWidth() / 120 + (0.06) * (mainView.getWidth())), (int) (mainView.getHeight() / 12 + (0.20) * (mainView.getHeight())), 150 + (int) (mainView.getWidth() / 8), 30 + (int) (mainView.getHeight() / 8));
        jButton3.setBounds((int) (mainView.getWidth() / 120 + (0.06) * (mainView.getWidth())), (int) (mainView.getHeight() / 12 + (0.40) * (mainView.getHeight())), 150 + (int) (mainView.getWidth() / 8), 30 + (int) (mainView.getHeight() / 8));
        jButton4.setBounds((int) (mainView.getWidth() / 120 + (0.06) * (mainView.getWidth())), (int) (mainView.getHeight() / 12 + (0.60) * (mainView.getHeight())), 150 + (int) (mainView.getWidth() / 8), 30 + (int) (mainView.getHeight() / 8));
        jButton5.setBounds((int) (mainView.getWidth() / 6 + (0.66) * (mainView.getWidth())), (int) (mainView.getHeight() /6 + (0.59) * (mainView.getHeight())), 15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24));
        jButton6.setBounds((int) (mainView.getWidth() / 6 + (0.56) * (mainView.getWidth())), (int) (mainView.getHeight() /6 + (0.59) * (mainView.getHeight())), 15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24));
        jButton7.setBounds((int) (mainView.getWidth() / 6 + (0.46) * (mainView.getWidth())), (int) (mainView.getHeight() /6 + (0.59) * (mainView.getHeight())), 15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24));
        //Labels
        game2 = new JLabel("0");
        game4 = new JLabel("0");
        tournament = new JLabel("0");
        //2 players button

        Image img1 = new ImageIcon("data/display/2players.png").getImage();
        img1 = img1.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT);
        jButton.setIcon(new ImageIcon(img1));
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        //jButton.setBorderPainted(img1.getScaledInstance(1,1,1));
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        //4 players button
        Image img2 = new ImageIcon("data/display/4players.png").getImage();
        img2 = img2.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT);
        jButton2.setIcon(new ImageIcon(img2));
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        //jButton.setBorderPainted(img1.getScaledInstance(1,1,1));
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        //Tournament button
        Image img3 = new ImageIcon("data/display/Tournament.png").getImage();
        img3 = img3.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT);
        jButton3.setIcon(new ImageIcon(img3));
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        //jButton.setBorderPainted(img1.getScaledInstance(1,1,1));
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        //Settings button
        Image img4 = new ImageIcon("data/display/EXIT1.png").getImage();
        img4 = img4.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT);
        jButton4.setIcon(new ImageIcon(img4));
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        //jButton.setBorderPainted(img1.getScaledInstance(1,1,1));
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);

        //Return Button
        Image img5 = new ImageIcon("data/display/neon.png").getImage();
        img5 = img5.getScaledInstance(15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24), Image.SCALE_DEFAULT);
        jButton5.setIcon(new ImageIcon(img5));
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.setFocusPainted(false);

        //NeonMute button
        Image img6 = new ImageIcon("data/display/neonmute.png").getImage();
        img6 = img6.getScaledInstance(15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24), Image.SCALE_DEFAULT);
        jButton6.setIcon(new ImageIcon(img6));
        jButton6.setOpaque(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);
        jButton6.setFocusPainted(false);
        jButton6.setFocusPainted(false);


        //Return Button
        Image img7 = new ImageIcon("data/display/tools.png").getImage();
        img7 = img7.getScaledInstance(15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24), Image.SCALE_DEFAULT);
        jButton7.setIcon(new ImageIcon(img7));
        jButton7.setOpaque(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setBorderPainted(false);
        jButton7.setFocusPainted(false);
        jButton7.setFocusPainted(false);
        //jButton5.setSize(new Dimension(40, 40));
        // jTable
       // jTable.setModel(new AbstractTableModel());
        // jTable.setGridColor(new Color(100,0,0,20));
       // jTable.setBounds((int) (mainView.getWidth() / 5 + (0.4) * (mainView.getWidth())), (int) (mainView.getHeight() / 13), 300 + (int) (mainView.getWidth() / 8), 200 + (int) (mainView.getHeight() / 6));
        jPanel = new MyPanel();
      // jPanel.setOpaque(true);
       jPanel.setLayout(null);
       jPanel.makePanel(mainView);
       jPanel.setBounds((int) (mainView.getWidth() / 6 + (0.22) * (mainView.getWidth())), (int) ((float)    (0.09) * (mainView.getHeight())),(int)((float)mainView.getWidth()/1.80),(int)((float)mainView.getHeight()/1.5));

       //System.out.println(30+(float)(0.20)*mainView.getHeight());
      // jPanel.add(makePanel(jPanel.getHeight(),mainView.getWidth()));
        name = new JLabel("DAVID");
        try{
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("data/fonts/GearsOfPeace.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(20f);
            name.setForeground(new Color(255, 255, 255));
            name.setFont(font);
            font = font.deriveFont(13f);
            jTable.setForeground(new Color(255,255,255));
            ((DefaultTableCellRenderer)jTable.getDefaultRenderer(Object.class)).setOpaque(false);
            jTable.setFont(font);
            font = font.deriveFont(12f);
            jTable.setForeground(new Color(255,255,255));
            jTable.setShowGrid(false);
            game2.setForeground(new Color(255,255,255));
            game4.setForeground(new Color(255,255,255));
            tournament.setForeground(new Color(255,255,255));
            font = font.deriveFont(20f);
            game2.setFont(font);
            game4.setFont(font);
            tournament.setFont(font);
        }catch(Exception e){

        }
        game2.setBounds((int)((float)mainView.getWidth()/40+(mainView.getWidth()*(0.12))),-60+(int)(float)(jTable.getHeight()*1.51),200,200);

        game4.setBounds((int)((float)mainView.getWidth()/36+(mainView.getWidth()*(0.24))),-60+(int)(float)(jTable.getHeight()*1.51),200,200);


        tournament.setBounds((int)((float)mainView.getWidth()/40+(mainView.getWidth()*(0.36))),-60+(int)(float)(jTable.getHeight()*1.51),200,200);

        // System.out.println("Height"+(int)((float)mainView.getWidth()/4+(mainView.getWidth()*(0.36))));//490 ampliado //235 ampliado//211//286
      //  System.out.println("Width WWW"+jPanel.getY());
        name.setBounds((int)((float)mainView.getWidth()/12+(mainView.getWidth()*(0.28))),-86+(int)(float)(jTable.getHeight()*1.5),200,200);
        jPanel.add(game2);
        jPanel.add(game4);
        jPanel.add(tournament);
        jPanel.add(name);
       //
        // System.out.println("(int)((float)jPanel.getHeight())"+100+(int)(float)(jTable.getHeight()*1.5));
      //  (int)((float)(200-(mainView.getHeight()/(9))+(0.10) * (mainView.getHeight()))))
     //   System.out.println("Resta: "+(int)((float)(-211*((float)400/jPanel.getHeight()))));
      //  System.out.println("tamño panel "+jPanel.getHeight());
        // jLabel.setBounds(mainView.getHeight()/10, (int) ((float)    (0.17) * (mainView.getHeight())));
       // jPanel.add(jLabel);

        this.add(jButton);
        this.add(jButton2);
        this.add(jButton3);
        this.add(jButton4);
        this.add(jButton5);
        this.add(jButton6);
        this.add(jButton7);
        this.add(jPanel);

      //  this.add(jLabel);
  //      panel.add(jTable);
    //    this.add(panel);

    }


    private JTable makeTable(MainView mainView) {

        //MenuView jPanel = new MenuView();
        Object[][] data = new Object[][]{
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"},
                { "John 20", "Tato 40", "Ernesto 20"}};
        String[] columnNames = { "2 X MATCH", "4 X MATCH", "TOURNAMENT"};
        //jPanel.setBounds((int) (mainView.getWidth() / 5 + (0.4) * (mainView.getWidth())), (int) (mainView.getHeight() / 13), 300 + (int) (mainView.getWidth() / 8), 200 + (int) (mainView.getHeight() / 6));
         model = new DefaultTableModel(data,columnNames) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;

            }
        };

        jTable = new JTable(model);
        jTable.setFocusable(false);
        jTable.setColumnSelectionAllowed(false);
        jTable.setRowSelectionAllowed(false);
        jTable.setOpaque(false);
        jTable.setBounds((int)((float) (mainView.getWidth() / 95 + (0.12) * (mainView.getWidth()))), (int) ((float)    (0.17) * (mainView.getHeight())),(int)((float)mainView.getWidth()/1.80),mainView.getHeight()/3);
        jTable.setRowHeight(mainView.getHeight()/31);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jTable.getColumnModel().getColumn(i);
            if (i == 0) {
                //column.setPreferredWidth(20); //third column is bigger
                column.setMaxWidth((int) ((float)((mainView.getWidth()/8.5))));
            } else {
               // column.setPreferredWidth(20);
                column.setMaxWidth(mainView.getWidth()/9);
            }
        }

        try{
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("data/fonts/GearsOfPeace.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(13f);
            jTable.setForeground(new Color(255,255,255));
            ((DefaultTableCellRenderer)jTable.getDefaultRenderer(Object.class)).setOpaque(false);
            jTable.setFont(font);
            jTable.setForeground(new Color(255,255,255));
            jTable.setShowGrid(false);
        }catch(Exception e){

        }
        //JPanel jPanel = new JPanel();
        //jPanel.setLayout(null);
        //jTable.setBounds(height/2,width/4,20,20);

       // jPanel.setBounds(height/4,width/2,20,20);

        return jTable;
    }

    public void changeSize(MainView mainView) {
        jPanel.setBounds((int) (mainView.getWidth() / 6 + (0.22) * (mainView.getWidth())), (int) ((float)    (0.09) * (mainView.getHeight())),(int)((float)mainView.getWidth()/1.80),(int)((float)mainView.getHeight()/1.5));
        jButton.setBounds((int) (mainView.getWidth() / 120 + (0.06) * (mainView.getWidth())), (int) (mainView.getHeight() / 12), 150 + (int) (mainView.getWidth() / 8), 30 + (int) (mainView.getHeight() / 8));
        jButton2.setBounds((int) (mainView.getWidth() / 120 + (0.06) * (mainView.getWidth())), (int) (mainView.getHeight() / 12 + (0.20) * (mainView.getHeight())), 150 + (int) (mainView.getWidth() / 8), 30 + (int) (mainView.getHeight() / 8));
        jButton3.setBounds((int) (mainView.getWidth() / 120 + (0.06) * (mainView.getWidth())), (int) (mainView.getHeight() / 12 + (0.40) * (mainView.getHeight())), 150 + (int) (mainView.getWidth() / 8), 30 + (int) (mainView.getHeight() / 8));
        jButton4.setBounds((int) (mainView.getWidth() / 120 + (0.06) * (mainView.getWidth())), (int) (mainView.getHeight() / 12 + (0.60) * (mainView.getHeight())), 150 + (int) (mainView.getWidth() / 8), 30 + (int) (mainView.getHeight() / 8));
        jButton5.setBounds((int) (mainView.getWidth() / 6 + (0.66) * (mainView.getWidth())), (int) (mainView.getHeight() /6 + (0.59) * (mainView.getHeight())), 15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24));
        jButton6.setBounds((int) (mainView.getWidth() / 6 + (0.56) * (mainView.getWidth())), (int) (mainView.getHeight() /6 + (0.59) * (mainView.getHeight())), 15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24));
        Image img1 = new ImageIcon("data/display/2players.png").getImage();
        img1 = img1.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT);
        jButton.setIcon(new ImageIcon(img1));
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        //jButton.setBorderPainted(img1.getScaledInstance(1,1,1));
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        //4 players button
        Image img2 = new ImageIcon("data/display/4players.png").getImage();
        img2 = img2.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT);
        jButton2.setIcon(new ImageIcon(img2));
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        //jButton.setBorderPainted(img1.getScaledInstance(1,1,1));
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        //Tournament button
        Image img3 = new ImageIcon("data/display/Tournament.png").getImage();
        img3 = img3.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT);
        jButton3.setIcon(new ImageIcon(img3));
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        //jButton.setBorderPainted(img1.getScaledInstance(1,1,1));
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        //Settings button
        Image img4 = new ImageIcon("data/display/EXIT1.png").getImage();
        img4 = img4.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT);
        jButton4.setIcon(new ImageIcon(img4));
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        //jButton.setBorderPainted(img1.getScaledInstance(1,1,1));
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);

        //Return Button
        Image img5 = new ImageIcon("data/display/neon.png").getImage();
        img5 = img5.getScaledInstance(15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24), Image.SCALE_DEFAULT);
        jButton5.setIcon(new ImageIcon(img5));
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.setFocusPainted(false);

        //NeonMute button
        Image img6 = new ImageIcon("data/display/neonmute.png").getImage();
        img6 = img6.getScaledInstance(15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24), Image.SCALE_DEFAULT);
        jButton6.setIcon(new ImageIcon(img6));
        jButton6.setOpaque(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);
        jButton6.setFocusPainted(false);
        jButton6.setFocusPainted(false);
        MyPanel jPanel = new MyPanel();
        // jPanel.setOpaque(true);
        jPanel.setLayout(null);
        jPanel.makePanel(mainView);
        jPanel.setBounds((int) (mainView.getWidth() / 6 + (0.22) * (mainView.getWidth())), 300,(int)((float)mainView.getWidth()/1.80),(int)((float)mainView.getHeight()/1.5));
        game2.setBounds((int)((float)mainView.getWidth()/40+(mainView.getWidth()*(0.12))),-60+(int)(float)(jTable.getHeight()*1.51),200,200);

        game4.setBounds((int)((float)mainView.getWidth()/36+(mainView.getWidth()*(0.24))),-60+(int)(float)(jTable.getHeight()*1.51),200,200);


        tournament.setBounds((int)((float)mainView.getWidth()/40+(mainView.getWidth()*(0.36))),-60+(int)(float)(jTable.getHeight()*1.51),200,200);

        // System.out.println("Height"+(int)((float)mainView.getWidth()/4+(mainView.getWidth()*(0.36))));//490 ampliado //235 ampliado//211//286
        //  System.out.println("Width WWW"+jPanel.getY());
        name.setBounds((int)((float)mainView.getWidth()/12+(mainView.getWidth()*(0.28))),-86+(int)(float)(jTable.getHeight()*1.5),200,200);
        //jTable.setPreferredSize(new Dimension(150,150));
        //jTable.getModel((makeTable(mainView)));
        //jTable = new JTable(model);
        this.jPanel.makePanel(mainView);
       /*
        jTable.setBounds((int)((float) (mainView.getWidth() / 95 + (0.12) * (mainView.getWidth()))), 600,(int)((float)mainView.getWidth()/1.80),mainView.getHeight()/3);
        jTable.setRowHeight(mainView.getHeight()/31);
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jTable.getColumnModel().getColumn(i);
            if (i == 0) {
                //column.setPreferredWidth(20); //third column is bigger
                column.setPreferredWidth((int) ((float)((mainView.getWidth()/8.5))));
            } else {
                // column.setPreferredWidth(20);
                column.setPreferredWidth(mainView.getWidth()/9);
            }
        }
    */
       // this.jPanel.setOpaque(true);
        jButton7.setBounds((int) (mainView.getWidth() / 6 + (0.46) * (mainView.getWidth())), (int) (mainView.getHeight() /6 + (0.59) * (mainView.getHeight())), 15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24));

        Image img7 = new ImageIcon("data/display/tools.png").getImage();
        img7 = img7.getScaledInstance(15 + (int) (mainView.getWidth() / 24), 15 + (int) (mainView.getWidth() / 24), Image.SCALE_DEFAULT);
        jButton7.setIcon(new ImageIcon(img7));
        jButton7.setOpaque(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setBorderPainted(false);
        jButton7.setFocusPainted(false);
        jButton7.setFocusPainted(false);

    }

    private class MyPanel extends JPanel{
        private Image bg = new ImageIcon("data/display/Ranking.png").getImage();
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        }


        public void makePanel(MainView mainView) {
            this.setLayout(null);
           // JPanel jPanelTable = new JPanel();
            //jPanelTable.setBounds((int)((float) (mainView.getWidth() / 100 + (0.12) * (mainView.getWidth()))), (int) ((float)    (0.20) * (mainView.getHeight())),mainView.getWidth()/5,mainView.getHeight()/5);
           //jPanelTable.add(makePanel(jPanelTable.getWidth(),jPanelTable.getHeight()));
            Component[] componentList = this.getComponents();

//Loop through the components
            for(Component c : componentList){

                if(c instanceof JTable){

                    //Remove it
                    this.remove(c);
                }
            }
//IMPORTANT
            this.revalidate();
            this.repaint();
           this.add(makeTable(mainView));
            // this.add(jPanelTable);


        }

    }

    public void registerControllerButtons(FunctionController fc) {

        jButton.addActionListener(fc);
        jButton.setActionCommand("2game");
        jButton2.addActionListener(fc);
        jButton2.setActionCommand("4game");
        jButton3.addActionListener(fc);
        jButton3.setActionCommand("Tournament");
        jButton4.addActionListener(fc);
        jButton4.setActionCommand("Exit");
        jButton5.addActionListener(fc);
        jButton5.setActionCommand("Return");
        jButton6.addActionListener(fc);
        jButton6.setActionCommand("Mute");
        jButton7.addActionListener(fc);
        jButton7.setActionCommand("Settings");


    }
   /* public void registerControllerButton (ActionListener fc){
        jButton.addActionListener(fc);
        jButton.setActionCommand("2game");
        jButton2.addActionListener(fc);
        jButton2.setActionCommand("4game");
        jButton3.addActionListener(fc);
        jButton3.setActionCommand("Tournament");
        jButton4.addActionListener(fc);
        jButton4.setActionCommand("Exit");
        jButton5.addActionListener(fc);
        jButton5.setActionCommand("Return");
        jButton6.addActionListener(fc);
        jButton6.setActionCommand("Mute");
        jButton7.addActionListener(fc);
        jButton7.setActionCommand("Settings");


    }*/
    public void registerControllerButtons(Controller controller) {

        jButton.addActionListener(controller);
        jButton.setActionCommand("2game");
        jButton2.addActionListener(controller);
        jButton2.setActionCommand("4game");
        jButton3.addActionListener(controller);
        jButton3.setActionCommand("Tournament");
        jButton4.addActionListener(controller);
        jButton4.setActionCommand("Exit");
        jButton5.addActionListener(controller);
        jButton5.setActionCommand("Return");
        jButton6.addActionListener(controller);
        jButton6.setActionCommand("Mute");
        jButton7.addActionListener(controller);
        jButton7.setActionCommand("Settings");


    }
    public void registerControllerButton (ActionListener controller){
        jButton.addActionListener(controller);
        jButton.setActionCommand("2game");
        jButton2.addActionListener(controller);
        jButton2.setActionCommand("4game");
        jButton3.addActionListener(controller);
        jButton3.setActionCommand("Tournament");
        jButton4.addActionListener(controller);
        jButton4.setActionCommand("Exit");
        jButton5.addActionListener(controller);
        jButton5.setActionCommand("Return");
        jButton6.addActionListener(controller);
        jButton6.setActionCommand("Mute");
        jButton7.addActionListener(controller);
        jButton7.setActionCommand("Settings");


    }

}

