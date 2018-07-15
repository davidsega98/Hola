package controller;

import network.NetworkServiceUser;
import view.CountDownView;


import java.util.Timer;
import java.util.TimerTask;

public class TimerDo {
    private NetworkServiceUser nService;
    private CountDownView countDownView;
    private boolean finishCD = false;



    int counter = 10;
    Boolean isIt = false;

    public TimerDo(NetworkServiceUser nService){
        this.countDownView = countDownView;
        this.finishCD = finishCD;
        this.counter = counter;
        this.isIt = isIt;
        this.nService = nService;


    }

    public void startCountDown(NetworkServiceUser nService){
        countDownView = new CountDownView();
        countDownView.setVisible(true);
        Timer timer = new Timer();
        counter = 10;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                countDownView.getTimeLeft().setText(Integer.toString(counter));
                counter--;
                System.out.println(counter);
                if (counter == -1) {
                    nService.sayStartGame();
                    timer.cancel();


                    finishCD = true;
                } else if (isIt) {
                    timer.cancel();
                    isIt = false;
                }

            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public int getCounter() {
        return counter;
    }

    public Boolean getIsIt() {
        return isIt;
    }

    public boolean getFinishCD() {
        return finishCD;
    }
}

