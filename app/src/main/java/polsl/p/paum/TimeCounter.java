package polsl.p.paum;

import android.os.CountDownTimer;

public class TimeCounter {

    private CountDownTimer countDownTimer;
    public long timeInMiliSeconds = 0; //5s
    public boolean timerRunning = false;

    public void startStop(){
        if(timerRunning) {
            stopTimer();
        }else{
            startTimer();
        }
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeInMiliSeconds,1000) {
            @Override
            public void onTick(long l) {
                timeInMiliSeconds = 1;
                timerRunning = true;
            }

            @Override
            public void onFinish() {
                timerRunning = false;
            }
        }.start();
      // timerRunning = false;
    }

    public void updateTimer() {
        timeInMiliSeconds=timeInMiliSeconds+5000;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        timerRunning = false;
    }

}
