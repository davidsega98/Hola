package view;

import controller.Controller;
import controller.GameController;
import model.ServerGrid;

import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class GameMainView extends JPanel{

    private final int files = 120;
    private final int columnes = 120;



    private JPanel[][] jTauler; //matriu (caselles)
    private JPanel jpMainView;
    private JPanel jpGrid;
    private BackgroundImageJFrame bgPanel;
    private JButton jbExit;
    private JButton jbMute;
    private  JLabel [] jlPlayer;
    private  JLabel [] jlPoints;
    Image bg = new ImageIcon("data/display/giphy.gif").getImage();
    private Color [] cColors;

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
    public GameMainView(){
        this.setOpaque(true);



        this.setLayout(null);
        setSize(800,800);



        JPanel jpPantalla = new JPanel();
        jpPantalla.setLayout(new GridLayout(files, columnes));
        //jpPantalla.setLayout(new BorderLayout());
        jpPantalla.setOpaque(false);

        //jpPantalla.setBackground(new Color(0.0f, 0.0f, 0.5f, 0.7f));
        //jpPantalla.setLayout(new BorderLayout());




        //JPanel joc = new JPanel();
        //jpPantalla.setBorder(new MatteBorder(10,10,10,10,Color.cyan.brighter()));
        //joc.setBorder(new BevelBorder(BevelBorder.RAISED));
        //aux.setLayout(new BorderLayout());
        //joc.setBackground(Color.cyan);
        jTauler = new JPanel[files][columnes];

        //().setLayout(new GridLayout(files, columnes));

        for(int i = 0; i<files; i++){
            for(int j=0; j<columnes; j++){
                jTauler[i][j]=new JPanel();
                jTauler[i][j].setLayout(new BorderLayout());
                //jTauler[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                //jTauler[i][j].setOpaque(true);
                jTauler[i][j].setBackground(new Color(0.0f, 0.0f, 0.0f, 0.7f));
                //jTauler[i][j].setBorder(null);



                jpPantalla.add(jTauler[i][j]);

            }

        }

        /*jTauler[3][4].setBackground(Color.WHITE);

        jTauler[3][4].setBorder(new MatteBorder(2,0,2,0,Color.red));
        jTauler[3][5].setBackground(Color.WHITE);
        jTauler[3][6].setBackground(Color.WHITE);

        jTauler[3][5].setBorder( new MatteBorder(2,0,2,0,Color.red) );
        jTauler[3][6].setBorder( new MatteBorder(2,0,2,0,Color.red) );

        jTauler[3][7].setBackground(Color.WHITE);

        jTauler[3][7].setBorder(new MatteBorder(2,0,2,0,Color.red));
        jTauler[3][8].setBackground(Color.WHITE);

        jTauler[3][8].setBorder(new MatteBorder(2,0,2,0,Color.red));
        jTauler[3][9].setBackground(Color.WHITE);

        jTauler[3][9].setBorder(new MatteBorder(2,0,2,0,Color.red));



        jTauler[33][4].setBackground(Color.WHITE);

        jTauler[33][4].setBorder(new MatteBorder(2,1,2,0,Color.cyan));
        jTauler[33][5].setBackground(Color.WHITE);
        jTauler[33][6].setBackground(Color.WHITE);

        jTauler[33][5].setBorder( new MatteBorder(2,0,2,0,Color.cyan) );
        jTauler[33][6].setBorder( new MatteBorder(2,0,2,0,Color.cyan) );

        jTauler[33][7].setBackground(Color.WHITE);

        jTauler[33][7].setBorder(new MatteBorder(2,0,2,0,Color.cyan));
        jTauler[33][8].setBackground(Color.WHITE);

        jTauler[33][8].setBorder(new MatteBorder(2,0,2,0,Color.cyan));
        jTauler[33][9].setBackground(Color.WHITE);

        jTauler[33][9].setBorder(new MatteBorder(2,0,2,0,Color.cyan));




        jTauler[53][4].setBackground(Color.WHITE);

        jTauler[53][4].setBorder(new MatteBorder(2,0,2,0,Color.green.brighter()));
        jTauler[53][5].setBackground(Color.WHITE);
        jTauler[53][6].setBackground(Color.WHITE);

        jTauler[53][5].setBorder( new MatteBorder(2,0,2,0,Color.green.brighter()) );
        jTauler[53][6].setBorder( new MatteBorder(2,0,2,0,Color.green.brighter()) );

        jTauler[53][7].setBackground(Color.WHITE);

        jTauler[53][7].setBorder(new MatteBorder(2,0,2,0,Color.green.brighter()));
        jTauler[53][8].setBackground(Color.WHITE);

        jTauler[53][8].setBorder(new MatteBorder(2,0,2,0,Color.green.brighter()));
        jTauler[53][9].setBackground(Color.WHITE);
        //jTauler[3][4].setBorder( new SoftBevelBorder(BevelBorder.LOWERED) );
        jTauler[53][9].setBorder(new MatteBorder(2,0,2,0,Color.green.brighter()));

        jTauler[83][4].setBackground(Color.WHITE);
        //jTauler[3][4].setBorder( new SoftBevelBorder(BevelBorder.LOWERED) );
        jTauler[83][4].setBorder(new MatteBorder(2,0,2,0,Color.yellow));
        jTauler[83][5].setBackground(Color.WHITE);
        jTauler[83][6].setBackground(Color.WHITE);
        //jTauler[3][5].setBorder( (10,0,10,,Color.black));
        //jTauler[3][6].setBorder( (10,0,10,,Color.black) );
        jTauler[83][5].setBorder( new MatteBorder(2,0,2,0,Color.yellow ));
        jTauler[83][6].setBorder( new MatteBorder(2,0,2,0,Color.yellow) );

        jTauler[83][7].setBackground(Color.WHITE);
        //jTauler[3][4].setBorder( new SoftBevelBorder(BevelBorder.LOWERED) );
        jTauler[83][7].setBorder(new MatteBorder(2,0,2,0,Color.yellow));
        jTauler[83][8].setBackground(Color.WHITE);
        //jTauler[3][4].setBorder( new SoftBevelBorder(BevelBorder.LOWERED) );
        jTauler[83][8].setBorder(new MatteBorder(2,0,2,0,Color.yellow));
        jTauler[83][9].setBackground(Color.WHITE);
        //jTauler[3][4].setBorder( new SoftBevelBorder(BevelBorder.LOWERED) );
        jTauler[83][9].setBorder(new MatteBorder(2,0,2,0,Color.yellow));*/


        for(int j=0; j<files; j++){

            jTauler[0][j].setBackground(Color.WHITE);
            //jTauler[3][4].setBorder( new SoftBevelBorder(BevelBorder.LOWERED) );
            jTauler[0][j].setBorder(new MatteBorder(2,0,2,1,Color.cyan.brighter()));
            //getContentPane().add(jTauler[i][j]);
        }
        for(int j=0; j<files; j++){
            jTauler[files-1][j].setBackground(Color.WHITE);
            //jTauler[3][4].setBorder( new SoftBevelBorder(BevelBorder.LOWERED) );
            jTauler[files-1][j].setBorder(new MatteBorder(2,0,2,0,Color.cyan.brighter()));
            //getContentPane().add(jTauler[i][j]);
        }

        for(int j=0; j<columnes; j++){

            jTauler[j][0].setBackground(Color.WHITE);
            //jTauler[3][4].setBorder( new SoftBevelBorder(BevelBorder.LOWERED) );
            jTauler[j][0].setBorder(new MatteBorder(0,2,0,2,Color.cyan.brighter()));
            //getContentPane().add(jTauler[i][j]);
        }
        for(int j=0; j<columnes; j++){

            jTauler[j][columnes-1].setBackground(Color.WHITE);

            jTauler[j][columnes-1].setBorder(new MatteBorder(0,2,0,2,Color.cyan.brighter()));

        }


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Mypanel jpplayers = new Mypanel();
        jpplayers.setLayout(new BorderLayout());
        JPanel jpPanel = new JPanel();
        jpPanel.setLayout(new GridLayout(4,1));
        jpPanel.setOpaque(false);
        jlPlayer = new JLabel[4];
        jlPoints = new JLabel[4];
        cColors  = new Color[4];
        cColors[0]= Color.cyan;
        cColors[1]= Color.red;
        cColors[2]= Color.yellow;
        cColors[3]= Color.green;
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("data/fonts/GearsOfPeace.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(40f);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        for (int i = 0 ; i< 4; i++){
            JPanel jpPanel1 = new JPanel();
            jpPanel1.setLayout(new GridLayout(1,2));
            jpPanel1.setOpaque(false);
            jlPlayer[i] = new JLabel("Players");
            jlPlayer[i].setFont(font);
            jlPlayer[i].setForeground(cColors[i]);
            jlPlayer[i].setHorizontalAlignment(JTextField.CENTER);
            jlPoints[i] = new JLabel("1");
            jlPoints[i].setFont(font);
            jlPoints[i].setForeground(cColors[i]);
            jlPoints[i].setHorizontalAlignment(JTextField.CENTER);

            jpPanel1.add( jlPlayer [i]);
            jpPanel1.add( jlPoints [i]);
            jpPanel.add(jpPanel1);
        }









//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        jbExit = new JButton();
        jbExit.setIcon(new ImageIcon("data/display/EXIT1.png"));
        jbExit.setOpaque(false);
        jbExit.setContentAreaFilled(false);
        jbExit.setBorderPainted(false);
        jbExit.setFocusPainted(false);




        Image img6 = new ImageIcon("data/display/neonmute.png").getImage();
        img6 = img6.getScaledInstance(15 + (int) (this.getWidth() / 20), 15 + (int) (this.getWidth() / 20), Image.SCALE_DEFAULT);
        jbMute  = new JButton();
        jbMute.setIcon(new ImageIcon(img6));
        jbMute.setOpaque(false);
        jbMute.setContentAreaFilled(false);
        jbMute.setBorderPainted(false);
        jbMute.setFocusPainted(false);





        jpPantalla.setBounds(0,0,1310,950);
        jpplayers.setBounds(1290,45,390,500);
        jbExit.setBounds(1390,800,250,100);
        jbMute.setBounds(1310,800,80,100);
        jpPanel.setBounds(1360,160,290,360);

        this.add(jpPanel);
        this.add(jpPantalla);
        this.add(jpplayers);
        this.add(jbExit);
        this.add(jbMute);






    }

    public void actionPerformedKeys(GameController c) {

        this.addKeyListener(c);
    }

    /**
     * procediment que si es necessàri actualitza el color de les caselles, segons si hi ha client o no (amb el seu respectiu color)
     * @param matrix rebem un char (0: transparent, 1,2,3,4:indiquen quin client i per tant quin color)
     */
    public void canviaGrid(ServerGrid matrix) {
        for (int i=1; i<files-1; i++) {
            for (int j=1; j<columnes-1; j++) {

                if (matrix.getServerGrid()[i][j] == 0) {
                    jTauler[i][j].setBackground(new Color(0.0f, 0.0f, 0.0f, 0.7f));
                }

                if (matrix.getServerGrid()[i][j]==1) {
                    //System.out.println("blau");
                    jTauler[i][j].setBackground(Color.cyan);
                    //jTauler[i][j].setBackground(Color.WHITE);
                    //jTauler[i][j].setBorder(new MatteBorder(0,2,0,2,Color.cyan.brighter()));
                }
                if (matrix.getServerGrid()[i][j]==2) {
                 //   System.out.println("verd");
                    jTauler[i][j].setBackground(Color.green);
                    //jTauler[i][j].setBackground(Color.WHITE);
                    //jTauler[i][j].setBorder(new MatteBorder(2,0,2,0,Color.green.brighter()));
                    //jTauler[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
                }
                if (matrix.getServerGrid()[i][j]==3) {
                   //o System.out.println("blau");
                    jTauler[i][j].setBackground(Color.yellow);
                    //jTauler[j][j].setBackground(Color.WHITE);
                    //jTauler[i][j].setBorder(new MatteBorder(2,0,2,0,Color.yellow));

                    //jTauler[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
                }
                if (matrix.getServerGrid()[i][j]==4) {
                   // System.out.println("vermell");
                    jTauler[i][j].setBackground(Color.red);
                    //jTauler[i][j].setBackground(Color.WHITE);
                    //jTauler[i][j].setBorder(new MatteBorder(2,0,2,0,Color.red));
                    // jTauler[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
                }

            }
        }

    }
    public long getFiles() {
        return files;
    }

    public long getColumnes() {
        return columnes;
    }
    private class Mypanel extends JPanel {

        private JLabel l1;
        private Timer t;
        private Clip clip;
        private Image bg = new ImageIcon("data/display/Player1.png").getImage();

        @Override
        public void paintComponent(Graphics g) {

            g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
        }
        public void registerController(Controller controller){
            this.addKeyListener(controller);
        }

        public Image getBg() {
            return bg;
        }

        public void setBg(Image bg) {
            this.bg = bg;
        }
    }

}

