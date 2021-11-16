public class Main {

    public static void main(String[] args) {

        while (true) {
            try {
                HangulClock hangulClock;
                hangulClock = HangulClock.getNewClass();
                hangulClock.run();
                Thread.sleep(10000); // 10초마다 갱신.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
