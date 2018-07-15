package view;




import controller.Controller;
import controller.FunctionController;
import controller.GameController;
import controller.WindowController;
import model.ServerGrid;
import model.User;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainView extends JFrame{

    private LabelClass label = new LabelClass();
    private threeView threeView;
    private TwoView twoView;
    private OneView oneView;
    private ZeroView zeroView;
    private BackgroundImageJFrame bgPanel;
    private LogSignPanel card2;
    private LogInPanel card3;
    private SignInPanel card4;
    private MenuView menuView;
    private CardLayout layout;
    private GameMainView gameMainView;
    private ConnexionView connexionView;
    private Clip clip;
    private WaitingView waitingView;
    //private JPanel


    public MainView(){
        this.setTitle("TRONER");
        this.setMinimumSize(new Dimension(1000,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        layout = new CardLayout();
        bgPanel = new BackgroundImageJFrame();
        JPanel card1 = label;
        card2 = new LogSignPanel();
        card3 = new LogInPanel();
        card4 = new SignInPanel();
        gameMainView = new GameMainView();
        connexionView = new ConnexionView();
        this.setContentPane(bgPanel);
        menuView = new MenuView(this);
        waitingView = new WaitingView();
        threeView = new threeView();
        twoView = new TwoView();
        oneView = new OneView();
        zeroView = new ZeroView();


        bgPanel.setLayout(layout);
        bgPanel.add("1",card1);
        bgPanel.add("2",card2);
        bgPanel.add("3",card3);
        bgPanel.add("4",card4);
        bgPanel.add("7",gameMainView);
        bgPanel.add("0",connexionView);
        bgPanel.add("5",menuView);
        bgPanel.add("8", waitingView);
        bgPanel.add("12", threeView);
        bgPanel.add("11", twoView);//aq
        bgPanel.add("10", oneView);
        bgPanel.add("9", zeroView);

        layout.show(bgPanel, "0");



        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setContentPane(bgPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize((int)(screenSize.width*((float)25.0/45)), (int)(screenSize.height*(2.0/3)));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }


    public void changePanel(String which) {
        layout.show(this.getContentPane(), which);
    }


    public void registerController(Controller c){
        connexionView.registerControllerConnexionView(c);
        card2.registerControllerMouse(c);
        card2.registerControllerButtons(c);
        card3.registerControllerMouse(c);
        card3.registerControllerButton(c);
        card3.registerControllerFocus(c);
        card4.registerControllerButton(c);
        card4.registerControllerMouse(c);
        card4.registerControllerFocus(c);
        menuView.registerControllerButtons(c);
        this.addKeyListener(c);
    }

    public void registerFunctionController(FunctionController c){
        card2.registerControllerButtons(c);
        card3.registerControllerButton(c);
        card4.registerControllerButton(c);
        menuView.registerControllerButton(c);
    }
    public void registerGameController(GameController c){
        gameMainView.actionPerformedKeys(c);
    }


    public void runMusic(File file) {
       try {
           clip = AudioSystem.getClip();
           AudioInputStream ais = AudioSystem.getAudioInputStream(file);
           clip.open(ais);
          // clip.loop(Clip.LOOP_CONTINUOUSLY);

       } catch (LineUnavailableException e) {
           e.printStackTrace();
       } catch (UnsupportedAudioFileException e1) {
           e1.printStackTrace();
       } catch (IOException e2) {
           e2.printStackTrace();
       }

    }


     public void setFadeaux(int r, int g, int b, int x) {label.setFade(r,g,b,x); }

     public void augmentButtons(String button, float x, int x1){
        if(button.equals("Back")|| button.equals("Mute")){
            card4.augmentButtons(button,x1);
            card3.augmentButtons(button,x1);
        }else {
            card2.augmentButtons(button, x);
        }
      }
      public void disaugmentButtons(String button, float x){
        card2.disaugmentButton(button, x);
      }



    public boolean showDialog(String message,int i) {
        System.out.println(i);
        if (i != 10) {
            int reply = JOptionPane.showConfirmDialog(null, message, "Exit Game", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION && i == 1) {
                //No se si aqui habria que enviarle un mensaje al servidor
                return true;
            }
            if (reply == JOptionPane.YES_OPTION && i == 7) {
                return true;
                //Aqui corresponde a cerrar el juego
            }
            if (reply == JOptionPane.YES_OPTION && i == 5) {
                return true;
            }

            return false;
        } else {
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public void registerWindowController(WindowController controler){
        this.addComponentListener(controler);
    }

    public JPanel getBgPanel() {
        return bgPanel;
    }

    public void setBgPanel(int actualLayout) {
        bgPanel.setBg(actualLayout);
    }
    public void changeTextFields(String name){
        card3.changeTextField(name);
        card4.changeTextField(name);
    }
    public void changeTextFieldsEmpty(String name){
        card3.changeTextFieldEmpty(name);
        card4.changeTextFieldEmpty(name);
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public User getUserLogin(){
        return card3.getUserLogin();
    }

    public User getUserSignIn(){
        return new User(card4.getNickname(),card4.getPassword(),card4.getEmail()," "," ");
    }

    public String getNicknameS(){
        return card4.getNickname();
    }
    public String getPasswordS(){
        return card4.getPassword();
    }

    public String getRepeatPasswordS(){
        return card4.getRepeatPassword();
    }

    public String getEmail(){
        return card4.getEmail();
    }

    public JTextField getJtfUsername(){
        return card3.getJtfUsername();
    }
    public JPasswordField getJtfPassowrd(){
        return card3.getJtfPassword();
    }

    public JTextField getJtfNicknameS() {
        return card4.getJtfNickname();
    }

    public JTextField getJtfEmailS() {
        return card4.getJtfEmail();
    }

    public JPasswordField getJtfPasswordS() {
        return card4.getJtfPassword();
    }

    public JPasswordField getJtfRepeatPasswordS() {
        return card4.getJtfRepeatPassword();
    }

    public void cleanFieldsSignIn(){
        card4.cleanFields();
    }

    public ConnexionView getConnexionView() {
        return connexionView;
    }

    public void setConnexionView(ConnexionView connexionView) {
        this.connexionView = connexionView;
    }

    public GameMainView getGameMainView() {
        return gameMainView;
    }

    public void setGameMainView(GameMainView gameMainView) {
        this.gameMainView = gameMainView;
    }

    public void canviaGrid(ServerGrid list) {
        gameMainView.canviaGrid(list);
    }
}


