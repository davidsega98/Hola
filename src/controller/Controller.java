
package controller;


import model.Petition;
import network.NetworkServiceUser;
import view.GameMainView;
import view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Controller extends Thread implements ActionListener, KeyListener, MouseListener, FocusListener {
    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String RIGHT = "right";
    private static final String LEFT = "left";
    private GameMainView viewGame;
    private Petition peticio;
    private NetworkServiceUser nService;




    private Timer t;
    private int x;
    private int acum;
    private MainView view;
    private boolean isBack;
    private int key;
    private int keyAux;
    private boolean isTimeS;
    private boolean isTimeL;
    private boolean isTimeB;
    private boolean isTimeM;
    private boolean stopMusic = true;
    private Integer actualLayout = 0;
    private float size;
    private float size2;
    private int size4;
    private int size5;
    private Music music;
    private boolean soundNow;
    private boolean closeSound;
    private boolean activate1=false;
    private boolean activate2=false;
    private boolean activate3=false;
    private boolean activate4=false;
    private boolean duringThread=false;
    private boolean activateN;
    private boolean activateP;
    private boolean isOn =false;
    private boolean end;
    private int sizeY = 800;
    private int sizeX = 600;

    public Controller(MainView view) {
        closeSound = false;
        soundNow = false;
        this.view = view;
        music = new Music(this);
        this.run();
        acum = 0;
        end =false;
        this.keyAux = 0;



        this.nService = nService;
        //nService = new NetworkServiceUser(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(actualLayout);
        if(e.getActionCommand().equals("StartConnexion")){
       //     try {
               Server server = new Server(view,this);
               server.start();

               nService = server.getNetworkService();
            System.out.println(nService+"<--nservice");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if(isOn) {
                   actualLayout = 1;
                   view.changePanel(actualLayout.toString());
                new Thread(music).start();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                view.setSize((int)(screenSize.width*(0.6)), (int)(screenSize.height*(2.0/3)));
                System.out.println(screenSize.width);
                System.out.println(screenSize.height);
                view.setLocationRelativeTo(null);
                view.setResizable(true);
               }else {
                //       }catch (Exception Error){
                view.showDialog("Error en la introduccion de Direccion / Puertos", 10);
            }
            ((JButton) e.getSource()).getTopLevelAncestor().requestFocus();
     }
        if(e.getActionCommand().equals("Return")){

            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
        }

        if (e.getActionCommand().equals("Login")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout = 5;
            /**
             * fet al function controller
             */
           // view.changePanel(actualLayout.toString());

        }
        if (e.getActionCommand().equals("2game")){

            //actualLayout = 7; //--> passem al actualLayout = 7 un cop ja haguem
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            //view.changePanel(actualLayout.toString());
            view.setExtendedState(view.MAXIMIZED_BOTH);




            //startGame();
        }
        if (e.getActionCommand().equals("4game")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
        }
        if (e.getActionCommand().equals("Tournament")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();

        }
        if (e.getActionCommand().equals("Exit")){
            if (view.showDialog("¿Desea salir del juego?", actualLayout)) {
                System.exit(0);
            }
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();

        }
        //if (e.getActionCommand().equals("Mute")){
         //   ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
          //  System.out.println("XT");

        //}
        if (e.getActionCommand().equals("Return")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            view.cleanFieldsSignIn();
            switchAndChange();
        }
        if (e.getActionCommand().equals("S")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout = 4;
            view.changePanel(actualLayout.toString());
        }
        if (e.getActionCommand().equals("goButton")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            //Si la verificacion es correcta
            actualLayout = 5;
            view.changePanel(actualLayout.toString());
        }
        if (e.getActionCommand().equals("RegisterButton")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            //Si es correcto
            actualLayout = 5;
            view.changePanel(actualLayout.toString());
        }

        if (e.getActionCommand().equals("L")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout = 3;
            view.changePanel(actualLayout.toString());
        }
        if (e.getActionCommand().equals("Back")) {
            if (actualLayout == 5) {

                if (view.showDialog("¿Desea volver a la ventana de inicio?", actualLayout)) {

                    view.cleanFieldsSignIn();
                    view.changePanel(actualLayout.toString());
                }

            }
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
        }
        if (e.getActionCommand().equals("Mute")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            acum++;
            if (acum % 2 == 0) {
                music.turnOnVolume();
            } else {
                music.turnOffVolume();
            }
        }
        if (e.getActionCommand().equals("Signin")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
           // actualLayout = 5;
           // view.changePanel(actualLayout.toString());
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        System.out.println("ENTRA AQUIIIII");
        key = e.getKeyCode();
        peticio = new Petition(key);
        if (key == KeyEvent.VK_RIGHT && keyAux != key) {
            if(key!=keyAux) {
                System.out.println("dreta");
                System.out.println("entro telctes");
                System.out.println(nService);
                nService.sendCommand(peticio);
                keyAux = key;
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            if(key!=keyAux) {
                nService.sendCommand(peticio);
                keyAux = key;
            }
        }
        if (key == KeyEvent.VK_UP && keyAux != key){
            if(key!=keyAux) {
                nService.sendCommand(peticio);
                keyAux = key;
            }
        }
        if (key == KeyEvent.VK_DOWN && keyAux != key){
            if(key!=keyAux) {
                nService.sendCommand(peticio);
                keyAux = key;
            }
        }








        if (e.getKeyCode() == 27) {
          switchAndChange();
        }
        if (e.getKeyCode() == 10 && actualLayout == 1) {
            //actualLayout = 2;
            //music.stopMusic();
            //music.runMusic(new File("data/Laser.wav"));
            //try {

                stopMusic();
                duringThread = true;
                // isBack = true;
                t.start();
                soundNow = true;
                Thread t = new Thread(new Runnable() {
                    public void run() {
                        try {
                            TimeUnit.MILLISECONDS.sleep(1600);
                            //music.stopMusic();
                            TimeUnit.MILLISECONDS.sleep(500);
                            System.out.println("changing");
                            actualLayout++;
                            view.changePanel(actualLayout.toString());
                            duringThread = false;
                        }catch( InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                t.start();


                soundNow = false;
                //closeSound = false;
                //startMusic();
                //music.runMusic(new File("data/LogInTheme.wav"));

            } /*catch (InterruptedException e1) {
                e1.printStackTrace();
            }*/


        }




    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key=e.getKeyCode();
        if(key==KeyEvent.VK_LEFT){
        }
        if(key==KeyEvent.VK_RIGHT){
        }
        if(key==KeyEvent.VK_UP){
        }
        if(key==KeyEvent.VK_DOWN){
        }
    }


    @Override
    public void run() {
        x = 50;
        size = 30f;
        size2 = 30f;
        size4 = 80;
        size5 = 80;
        isBack = false;

        t = new Timer(5, new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                if (x == 255) {
                    isBack = true;
                }
                if (isBack) {
                    view.setFadeaux(157, 207, 222, x--);
                    if (x == 50) {
                        isBack = false;
                        t.start();
                        x = 50;
                    }
                } else {
                    view.setFadeaux(157, 207, 222, x++);
                }

                if (isTimeS && !isTimeL && size2 < 40f && actualLayout == 3) {
                    view.augmentButtons("S", size2++, 0);
                }
                if (isTimeL && !isTimeS && size < 40f) {
                    view.augmentButtons("L", size++, 0);
                }
                if (!isTimeS && size2 > 30f) {
                    view.disaugmentButtons("S", size2--);
                }
                if (!isTimeL && size > 30f) {
                    view.disaugmentButtons("L", size--);
                }
                if (isTimeB && size4 < 90) {
                    view.augmentButtons("Back", 0, size4++);
                }
                if (!isTimeB && size4 > 80) {
                    view.augmentButtons("Back", 0, size4--);
                }
                if (isTimeM && size5 < 90) {
                    view.augmentButtons("Mute", 0, size5++);
                }
                if (!isTimeM && size5 > 80) {
                    view.augmentButtons("Mute", 0, size5--);
                }
            }

        });
        t.start();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (activateN == false && e.getComponent().getY() == 0) {
            //Hablar esto, me entra abajo
           // view.changeTextFields("Username");
//            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout++;
            activateN = true;
        }

        if (activateP == false&& e.getComponent().getY() == 124) {
            //view.changeTextFields("Password");
            ((JTextField)e.getSource()).getTopLevelAncestor().requestFocus();
            activateP=true;
        }

        if (e.getComponent().getY() == 47 && activate1==false) {
            ((JTextField)e.getSource()).getTopLevelAncestor().requestFocus();
            //view.changeTextFields("Nickname");
            activate1 = true;
        }
        if (e.getComponent().getY() == 141 && activate2==false) {
            ((JTextField)e.getSource()).getTopLevelAncestor().requestFocus();
            //view.changeTextFields("Email");
            activate2 = true;
        }
        if (e.getComponent().getY() == 235 && activate3==false) {
            ((JPasswordField)e.getSource()).getTopLevelAncestor().requestFocus();
            //view.changeTextFields("Password1");
            activate3 = true;
        }
        if (e.getComponent().getY() == 329 && activate4==false) {
            ((JPasswordField)e.getSource()).getTopLevelAncestor().requestFocus();
            //view.changeTextFields("RPassword");
            activate4 = true;
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getLocationOnScreen().getX() > 1080 && e.getLocationOnScreen().getX() < 1190 && e.getLocationOnScreen().getY() > 160 && e.getLocationOnScreen().getY() < 260 && actualLayout == 2) {
            isTimeM = true;
        }

        if (e.getLocationOnScreen().getX() > 250 && e.getLocationOnScreen().getX() < 360 && e.getLocationOnScreen().getY() > 160 && e.getLocationOnScreen().getY() < 260 && actualLayout == 2) {
            isTimeB = true;
        }
        if (e.getLocationOnScreen().getX() > 850 && e.getLocationOnScreen().getX() < 1050 && e.getLocationOnScreen().getY() > 410 && e.getLocationOnScreen().getY() < 470 && actualLayout == 2) {
            isTimeL = true;
        }
        if (e.getLocationOnScreen().getX() > 360 && e.getLocationOnScreen().getX() < 560 && e.getLocationOnScreen().getY() > 410 && e.getLocationOnScreen().getY() < 470 && actualLayout == 2) {
            isTimeS = true;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getLocationOnScreen().getX() > 1000 && e.getLocationOnScreen().getX() < 1200 && e.getLocationOnScreen().getY() > 160 && e.getLocationOnScreen().getY() < 275) {
            isTimeM = false;
        }

        if (e.getLocationOnScreen().getX() > 240 && e.getLocationOnScreen().getX() < 370 && e.getLocationOnScreen().getY() > 160 && e.getLocationOnScreen().getY() < 275) {
            isTimeB = false;
        }
        if (e.getLocationOnScreen().getX() > 830 && e.getLocationOnScreen().getX() < 1150 && e.getLocationOnScreen().getY() > 400 && e.getLocationOnScreen().getY() < 470) {
            isTimeL = false;
        }
        if (e.getLocationOnScreen().getX() > 320 && e.getLocationOnScreen().getX() < 580 && e.getLocationOnScreen().getY() > 400 && e.getLocationOnScreen().getY() < 470) {
            isTimeS = false;
        }

    }

    public Integer getActualLayout() {
        return actualLayout;
    }

    public void setActualLayout(Integer actualLayout) {
        this.actualLayout = actualLayout;
    }

    private void stopMusic() {
        this.stopMusic = false;
    }

    public void startMusic() {
        this.stopMusic = true;
    }
    public boolean getMusicOn(){
        return stopMusic;
    }

    public boolean getCloseSound() {
        return closeSound;
    }

    public boolean getSoundNow() {
        return soundNow;
    }

    public void setSoundNow(boolean soundNow) {
        this.soundNow = soundNow;
    }

    public void setMusicOn(boolean musicOn) {
        this.stopMusic = musicOn;
    }

    public void setCloseSound(boolean closeSound) {
        this.closeSound = closeSound;
    }
    private void switchAndChange(){
        switch (actualLayout) {
            case 0:
                if (view.showDialog("¿Desea salir del juego?", actualLayout)) {
                    System.exit(0);
                }
                break;
            case 1:
                if (view.showDialog("¿Desea salir del juego?", actualLayout)) {
                    System.exit(0);
                }
                break;
            case 3:
                actualLayout = 2;
                view.changePanel(actualLayout.toString());
                break;
            case 4:
                actualLayout = 2;
                view.changePanel(actualLayout.toString());
                break;
            case 5:
                if (view.showDialog("¿Desea volver a la pantalla de inicio?", actualLayout)) {

                    actualLayout = 1;
                    view.changePanel(actualLayout.toString());
                }
                break;
            case 7:
                System.out.println("he entrat al case 7 de controller");
                if (view.showDialog("Si abandona la partida sera penalizado.\n¿esta usted seguro de abandonar?", actualLayout)) {
                    actualLayout = 5;
                    view.setResizable(true);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    view.setSize((int)(screenSize.width*((float)25.0/45)), (int)(screenSize.height*(2.0/3)));
                    view.setLocationRelativeTo(null);
                    view.changePanel("5");
                    System.out.println(actualLayout);
                }
                break;
            default:
                actualLayout--;
                view.changePanel(actualLayout.toString());
                break;
        }
    }

   /* public void startGame(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //creem la vista
                GameMainView gameView = new GameMainView();
                //creem network
                NetworkService nService = new NetworkService(gameView);
                //Creem els controladors.
                GameController controller = new GameController(gameView,nService);
                //Establim les "relacions" V->C
                gameView.actionPerformed(controller);
                //fem visible les dues finestres.

                //finestra.setVisible(true);
                if(nService.isByebye()){
                    gameView.setVisible(false);
                }else{
                    gameView.setVisible(true);
                }
            }
        });
    }*/


    @Override
    public void focusGained(FocusEvent e) {

        if(e.getSource().toString().equals(view.getConnexionView().getJtfDirection().toString())){
            view.getConnexionView().changeTextField("DirectionIP");
        }
        if(e.getSource().toString().equals(view.getConnexionView().getjtfIp().toString())){
            view.getConnexionView().changeTextField("Port");
        }
        if(e.getSource().toString().equals(view.getJtfUsername().toString())){
            view.changeTextFields("UsernameL");

        }
        if(e.getSource().toString().equals(view.getJtfPassowrd().toString())){
            view.changeTextFields("PasswordL");

        }
        if(e.getSource().toString().equals(view.getJtfNicknameS().toString())){
            view.changeTextFields("Nickname");
        }
        if(e.getSource().toString().equals(view.getJtfEmailS().toString())){
            view.changeTextFields("Email");
        }
        if(e.getSource().toString().equals(view.getJtfPasswordS().toString())){
            view.changeTextFields("Password1");
        }
        if(e.getSource().toString().equals(view.getJtfRepeatPasswordS().toString())){
            view.changeTextFields("RPassword");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

        if(e.getSource().toString().equals(view.getConnexionView().getJtfDirection().toString())){
            view.getConnexionView().changeTextFieldEmpty("DirectionIP");
        }
        if(e.getSource().toString().equals(view.getConnexionView().getjtfIp().toString())){
            view.getConnexionView().changeTextFieldEmpty("Port");
        }
        if(e.getSource().toString().equals(view.getJtfUsername().toString())){
            view.changeTextFieldsEmpty("UsernameL");

        }
        if(e.getSource().toString().equals(view.getJtfPassowrd().toString())){
            view.changeTextFieldsEmpty("PasswordL");
        }
        if(e.getSource().toString().equals(view.getJtfNicknameS().toString())){
            view.changeTextFieldsEmpty("Nickname");
        }
        if(e.getSource().toString().equals(view.getJtfEmailS().toString())){
            view.changeTextFieldsEmpty("Email");
        }
        if(e.getSource().toString().equals(view.getJtfPasswordS().toString())){
            view.changeTextFieldsEmpty("Password1");
        }
        if(e.getSource().toString().equals(view.getJtfRepeatPasswordS().toString())){
            view.changeTextFieldsEmpty("RPassword");
        }


    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean duringThread() {
        return duringThread;
    }

    public void posaMainView(int layout){
        System.out.println("poso "+layout);
        actualLayout = layout;
        view.changePanel(actualLayout.toString());
    }


}

