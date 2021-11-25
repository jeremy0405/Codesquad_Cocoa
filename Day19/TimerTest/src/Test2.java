import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Helper extends TimerTask
{
    public static int i = 0;
    public void run()
    {
        System.out.println("Timer ran " + ++i);
        if(i == 4)
        {
            synchronized(Test2.obj)
            {
                Test2.obj.notify();
            }
        }
    }

}


public class Test2
{
    protected static Test2 obj;
    public static void main(String[] args) throws InterruptedException
    {
        obj = new Test2();

        //creating a new instance of timer class
        Timer timer = new Timer();
        TimerTask task = new Helper();

        //instance of date object for fixed-rate execution
        Date date = new Date();

        timer.scheduleAtFixedRate(task, date, 5000);

        System.out.println("Timer running");

        synchronized(obj)
        {
            //make the main thread wait
            obj.wait();

            //once timer has scheduled the task 4 times,
            //main thread resumes
            //and terminates the timer
            timer.cancel();

            //purge is used to remove all cancelled
            //tasks from the timer'stack queue
            System.out.println(timer.purge());
        }
    }
}

