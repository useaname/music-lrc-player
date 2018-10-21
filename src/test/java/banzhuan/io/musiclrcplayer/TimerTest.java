package banzhuan.io.musiclrcplayer;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    @Test
    public void timerTaskTest() {

    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println("--");
                System.out.println(this.scheduledExecutionTime());
                System.out.println(System.currentTimeMillis());
                System.out.println("--");

            }
        }, 0,1000);
    }

}
