import controller.Controller;
import controller.GameController;
import controller.WindowController;
import view.MainView;

public class ClientMain {
    public static void main(String args[]) {
        int i = 0; 
        MainView view = new MainView();

       // BackgroundImageJFrame bImage =  new BackgroundImageJFrame();
        Controller controller = new Controller(view);

        WindowController windowController = new WindowController(view,controller);
        view.registerController(controller);
        view.registerWindowController(windowController);
        view.setVisible(true);
        /*
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //creem la vista
                GameMainView finestra = new GameMainView();
                ConnexionView connexionView = new ConnexionView();
                //creem network
                NetworkServiceUser nService = new NetworkServiceUser(finestra, connexionView);
                //Creem els controladors
                FunctionController fController = new FunctionController(nService, view);
                view.registerFunctionController(fController);
               // GameController controller = new GameController(finestra,nService);
                //Establim les "relacions" V->C
                //finestra.actionPerformed(controller);
                //fem visible les dues finestres.

                //finestra.setVisible(true);

            }
        });*/
    }
}
