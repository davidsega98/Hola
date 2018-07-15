package network;

import controller.GameController;
import model.Petition;
import model.ServerGrid;
import model.User;
import view.GameMainView;
import view.MainView;

import javax.print.attribute.IntegerSyntax;
import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Permet: (1) rebre les actualitzacions de lestat del model que
 emmagatzema el servidor i (2) enviar de les dades (fnom,producte)
 quan lusuari selecciona la opcio send
 */
public class NetworkServiceUser extends Thread {
    private Integer actualLayout = 1;
    private boolean game = false;
    private GameController gameController;
    private ServerGrid serverGrid;
    private ObjectOutputStream doStreamO;
    private static final String IP = "127.0.0.1";
    private static final int PORT_USER = 12345;
    private Socket socketToServer;
    private GameMainView finestra;
    private ObjectInputStream objectIn;
    private boolean isOn;
    private String identifier;
    private MainView mainView;



    /**
     * constructor amb paramentres
     */
    public NetworkServiceUser(MainView mainView) {
            this.mainView = mainView;
            int foo = 1;
            this.isOn = false;
           // this.finestra = finestra;
            String direction = mainView.getConnexionView().getJtfDirection().getText();
            String port = mainView.getConnexionView().getjtfIp().getText();

            try {
                 foo = Integer.parseInt(port);
            }catch (Exception e){
                 foo = 1;
            }


            try {

                this.socketToServer = new Socket(direction, foo);
                this.doStreamO = new ObjectOutputStream(socketToServer.getOutputStream());
                this.objectIn = new ObjectInputStream(socketToServer.getInputStream());
                isOn = true;

            } catch (Exception e) {
                System.out.println(isOn+"La caga");
             //   JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        //gameController = new GameController(mainView.getGameMainView(), this );
       // mainView.registerGameController(gameController);
        }



    /**
     * comença la comunicació amb el servidor
     */
    public void startServerComunication() {
        isOn = true;
        this.start();
    }

    /**
     * Finalitza la comunicacio amb el servidor
     */
    public void stopServerComunication() {
        this.isOn = false;
        this.interrupt();
    }

    public void run() {

        try {
         //   String aux1=(String)objectIn.readObject();//llegim nse qu pro la pubix diu q es util (tot i q no serveix per re util)
            while (isOn){
                identifier =(String) objectIn.readObject();
                System.out.println(identifier+"<--id");
                switch(identifier){
                    case "login":
                        checkLogin();
                        break;
                    case "singin":
                        checkSingin();
                        break;
                    case "ready":
                        newView(7);
                        break;
                    case "notReady":
                        newView(8);
                        break;
                    case "three":
                        newView(12);
                        break;
                    case "two":
                        newView(11);
                        break;
                    case"one":
                        newView(10);
                        break;
                    case"zero":
                        newView(9);
                        doStreamO.writeObject("peticio");
                        break;
                    case "letsGo":
                        System.out.println("he entrat a letsGo");
                      //  gameController.getClass().
                        //gameController.
                        game();
                        break;


                }




            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error ha saltat el catch de q n ha pogut llegir be", JOptionPane.ERROR_MESSAGE);
            stopServerComunication();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            stopServerComunication();
            e.printStackTrace();
        }
        stopServerComunication();
    }
    public void sendCommand(Petition peticio) {
        try {
            System.out.println("this is the petiton "+peticio.getKey());
            System.out.println(doStreamO);
            doStreamO.reset();
            System.out.println(peticio+" PRINTAMOS PETICION");
            doStreamO.writeObject(peticio);
            //Tanquem el socket
            //socket.close();
        } catch (IOException e) {
            // Si hi ha algut algun problema informem al controlador, ell
            stopServerComunication();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private void game() {
        game = true;
        while(game){
            try {
                ServerGrid aux = (ServerGrid) objectIn.readObject();
                System.out.println("                                                 rebo serverGrid");
                actualitzarVista(aux);
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error ha saltat el catch de q n ha pogut llegir be", JOptionPane.ERROR_MESSAGE);
                stopServerComunication();
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                stopServerComunication();
                e.printStackTrace();
            }
        }
        stopServerComunication();

        }

    private void actualitzarVista(ServerGrid list) {
        mainView.canviaGrid(list);
    }


    private void newView(Integer i) {
        actualLayout = i;
        mainView.changePanel(i.toString());
    }

    private void checkSingin() {
        boolean signin = checkIfIsOkay(mainView.getUserSignIn());
        if (signin) {
            actualLayout = 5;
            mainView.changePanel(actualLayout.toString());
        } else {
            JOptionPane.showMessageDialog(null, "CANT SIGNIN", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkLogin() {
         boolean login = checkIfIsOkay(mainView.getUserLogin());
        if(login){
            actualLayout = 5;
            mainView.changePanel(actualLayout.toString());
        }else{
            JOptionPane.showMessageDialog(null, "CAN'T LOGIN","Inane error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void sendParameter(String selection) {
        try {
            doStreamO.writeObject(selection);
            System.out.println("ha escrit el que toca");

        } catch (IOException e) {
            e.printStackTrace();
            stopServerComunication();
            System.out.println("*** ESTA EL SERVIDOR EN EXECUCIO? ***");
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public boolean checkIfIsOkay(User userToSend) {
        boolean isOkay = false;
        try {
            doStreamO.writeObject(userToSend);
            isOkay =(boolean)objectIn.readObject();
            System.out.println("mirem si is okay "+ isOkay);


        } catch (IOException e) {
            e.printStackTrace();
            stopServerComunication();
            System.out.println("*** ESTA EL SERVIDOR EN EXECUCIO? ***");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isOkay;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean checkReady() {
        boolean isReady = false;
        System.out.println("entro a checkisReady");
        try {
            System.out.println("estic a punt de llegir is Ready");
            isReady =(boolean)objectIn.readObject();
            System.out.println("mirem si is READY "+ isReady);


        } catch (IOException e) {
            e.printStackTrace();
            stopServerComunication();
            System.out.println("*** ESTA EL SERVIDOR EN EXECUCIO? ***");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isReady;


    }
    //client ha acabat countdown i avisa al server que pot començar a moure troner
    public void sayStartGame() {
        boolean b =true;
        System.out.println("entro a start game");
        try {

            doStreamO.writeObject(b);
            System.out.println("ha escrit el que vull mourem");

        } catch (IOException e) {
            e.printStackTrace();
            stopServerComunication();
            System.out.println("*** ESTA EL SERVIDOR EN EXECUCIO? ***");

        }
    }
    //el servidor em diu per qin numero del countDown vaig
    public int startCountDown() {
        int aux = 0;
        try {
            aux =(int)objectIn.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return aux;

    }
}
