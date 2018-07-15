package controller;


import network.NetworkServiceUser;
import view.MainView;

public class Server extends Thread {
    private NetworkServiceUser networkService;
    private FunctionController functionController;
    private Controller controller;
    private MainView mainView;

    public Server(MainView mainView,Controller controller){
        this.mainView = mainView;
        this.controller =controller;
        this.networkService = new NetworkServiceUser(mainView);

    }

    public void run(){

        if(networkService.isOn()) {
            controller.setOn(true);

            functionController = new FunctionController(networkService, mainView);
            mainView.registerFunctionController(functionController);
            controller.setEnd(true);
        }
    }

    public NetworkServiceUser getNetworkService() {
        return networkService;
    }

    public void setNetworkService(NetworkServiceUser networkService) {
        this.networkService = networkService;
    }


}
