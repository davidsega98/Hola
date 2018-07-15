package controller;

import model.User;
import network.NetworkServiceUser;
import view.CountDownView;
import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionController extends Thread implements ActionListener {
    private NetworkServiceUser nService;
    private boolean ready2 = false;
    private int aux;
    private boolean login;
    private boolean signin;
    private MainView view;
    private Integer actualLayout = 1;
    private User userAux;
    private boolean isReady = false;
    private Controller controller;
    //private TimerDo timerDo = new TimerDo(nService);
    private boolean primerCopThtIsNotReady = true;


    public  FunctionController(NetworkServiceUser nService, MainView view){
       this.nService = nService;
       this.nService.startServerComunication();
       this.view = view;
       controller = new Controller(view);
       aux = 8;
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")){
            nService.sendParameter("login");
            /*login = nService.checkIfIsOkay(view.getUserLogin());
            if(login){
                actualLayout = 5;
                view.changePanel(actualLayout.toString());
            }else{
                JOptionPane.showMessageDialog(null, "CAN'T LOGIN","Inane error", JOptionPane.ERROR_MESSAGE);

            }*/
        }else if(e.getActionCommand().equals("Signin")){
            if(checkSignIn() != 4){
                setErrorMessage();
            }else {
                nService.sendParameter("sign");
                /*signin = nService.checkIfIsOkay(view.getUserSignIn());
                if (signin) {
                    actualLayout = 5;
                    view.changePanel(actualLayout.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "CANT SIGNIN", "Inane error", JOptionPane.ERROR_MESSAGE);
                }*/
            }
        }else if (e.getActionCommand().equals("2game")){
            nService.sendParameter("twoPlayer");

            //tactica numero 10000000
            //envio al servidor q el client vol jugar a 2Players
            //espero des del netork server User a que el servidor menvii si estic ready o no
            //si no estic ready poso layout 9
            //si SI estic ready mostro el 3,2,1,0 --> 12,11,10,9 (layouts equivalents)





            /*isReady = nService.checkReady();

            while(!ready2) {
                if (isReady) {
                    //.posaMainView(9);
                    //nService.startCountDown();

                    /*while(aux!=0) {
                        if (aux != 0) {
                            //mostro el 3,2,1
                            //System.out.println((aux+1)+"AUXXX");
                            //aux = nService.startCountDown();

                            //començaCountDown(aux);

                        } else {
                            //mostro el '0'
                            controller.posaMainView(aux+9);
                        }
                    }


                    //timerDo.startCountDown(nService);
                    ready2 = true;*
                }else{
                    if(primerCopThtIsNotReady){
                        controller.posaMainView(8);
                        System.out.println("he entrat al bucle guaxi");
                        primerCopThtIsNotReady = false;
                    }


                    //System.out.println("he posat la 8");
                    //JOptionPane.showMessageDialog(null, "PLEASE, WAIT FOR MORE PLAYERS:)");
                    isReady = nService.checkReady(); //TORNO A ESPERAR READY FINS QUE ESTIGUI READY

                }
            */




        }else if (e.getActionCommand().equals("4game")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
        }else if (e.getActionCommand().equals("Tournament")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
        }
    }



    public void setErrorMessage(){
        switch (checkSignIn()){
            case 1:
                JOptionPane.showMessageDialog(null, "Invalid Email","Inane error", JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Passwords don't match ","Inane error", JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Invalid passowrd","Inane error", JOptionPane.ERROR_MESSAGE);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Empty Fields","Inane error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public int checkSignIn(){
        if(!checkEmail(view.getEmail())){
            return 1;
        }else if(!checkBothPasswords(view.getPasswordS(), view.getRepeatPasswordS())){
            return 2;
        }else if(!checkPassword(view.getPasswordS())){
            return 3;
        }else if(checkFields(view.getNicknameS(),view.getEmail(),view.getPasswordS(),view.getRepeatPasswordS())) {
            return 5;
        }else{
            return 4;
        }

    }

    public boolean checkEmail(String email){
        boolean ok = false;
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@') {
                ok = true;
            }
        }
        return ok;
    }
    public boolean checkBothPasswords(String p1, String p2){
        System.out.println(p1+" "+p2);
        return p1.equals(p2);
    }
    public boolean checkPassword(String p){
        boolean ok = false;
        boolean isUpperCase=false;
        boolean isLowerCase = false;
        boolean isDigit=false;

        if(p.length() > 5 ){
            for(int i = 0; i < p.length(); i++){
                if(Character.isUpperCase(p.charAt(i))){
                    isUpperCase=true;
                }
                if(Character.isLowerCase(p.charAt(i))){
                    isLowerCase=true;
                }
                if(Character.isDigit(p.charAt(i))){
                    isDigit=true;
                }
            }
            ok = isDigit&isLowerCase&isUpperCase;
        }
        return ok;
    }

    public boolean checkFields(String p1, String p2, String p3, String p4){
        boolean ok = false;
        if(p1.equals("Please input User Name")|| p2.equals("example@gmail.com")|| p3.equals("Minimum 8 carachters")|| p4.equals("Minimum 8 carachters")||p1.equals("")|| p2.equals("")|| p3.equals("")|| p4.equals("")){
            ok=true;
        }
        return ok;
    }










}
