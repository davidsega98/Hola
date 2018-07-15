package controller;



import model.Petition;
import network.NetworkService;
import network.NetworkServiceUser;
import view.GameMainView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
    private static final String UP = "up";
    private static final String DOWN = "down";
    private static final String RIGHT = "right";
    private static final String LEFT = "left";
    private GameMainView view;
    private int keyAux;
    private Petition peticio;
    private int key;//es el q volem enviar al servidr
    private NetworkServiceUser nService;


    /**
     * constructor amb paramentres
     * @param vista ens permet establir comunicació amb el servidor
     */
    public GameController(GameMainView vista, NetworkServiceUser nService){
        this.keyAux = 0;
        this.view = vista;
        this.nService = nService;
        //nService.startServerComunication();
    }

    /**
     * controlem/escoltem el teclat
     *
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
    /**
     * rebem la tecla premuda i cridem al procediment sendCommand per enviar la petició(informació) al servidor
     * @param e : ens informa el codi de la tecla premuda
     */
    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        peticio = new Petition(key);
        if (key == KeyEvent.VK_RIGHT && keyAux != key) {
            if(key!=keyAux) {
                System.out.println("entro telctes");
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
    }


    @Override
    public void keyReleased(KeyEvent e){
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


}
