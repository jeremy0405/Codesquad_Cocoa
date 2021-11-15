public class Main extends Thread {

    public void run() {
        try {
            HangulClock hangulClock;
            hangulClock = HangulClock.getNewClass();
            hangulClock.run();
        } catch (Exception e) {
            System.out.println("exception e 에러");
        }
    }

    public static void main(String[] args) {

        while (true) {
            try {
                Thread t = new Main();
                t.start();
                Thread.sleep(5000); // 5초마다 갱신.
                ClearConsole();
            } catch (Exception e) {
                System.out.println("메인문 Exception 에러");
            }
        }
    }

    private static void ClearConsole() {
        try {
            System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            Process p;
            p = Runtime.getRuntime().exec("cmd /c cls");
            p.waitFor();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
