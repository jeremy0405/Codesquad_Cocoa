import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                System.out.println("Timer ran : " + ++i);
            }
        };

        timer.schedule(task, 5000,1000); // 처음 실행될 때 5초동안 작동 안하고 이후 1초마다 실행
    }

}
