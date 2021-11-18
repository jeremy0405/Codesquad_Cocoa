import static java.lang.Thread.sleep;

import java.util.Scanner;

public class Menu implements Runnable {

    public void run() {
        try {
            while (true) {
                HangulClock hangulClock = new HangulClock();
                hangulClock.clockRun();
                sleep(5000); // 10초마다 갱신.
            }
        } catch (Exception e) {
            System.out.println("시계 종료");
        }

    }

    public static boolean systemRun() {
        Scanner sc = new Scanner(System.in);
        System.out.print("clock or cal >> ");
        String command = sc.nextLine();
        return choiceOption(command);
    }

    private static boolean choiceOption(String command) {
        if (command.equals("clock")) {
            Menu menu = new Menu();
            Thread thread = new Thread(menu);
            thread.start();
            Scanner sc = new Scanner(System.in);
            while (true) {
                String s = sc.nextLine();
                if (s.equals("exit")) {
                    thread.interrupt();
                    break;
                }
            }
            return true;
        } else if (command.equals("cal")) {
            calendar();
            return true;
        } else if (command.equals("exit")) {
            return false;
        } else {
            systemRun();
            return false;
        }
    }

    private static void calendar() {
        Scanner sc = new Scanner(System.in);
        Calendar calendar = new Calendar();
        calendar.printCal();
        calMenu(sc);
    }

    private static void calMenu(Scanner sc) {
        Calendar calendar;
        boolean isWork = true;
        while (isWork) {
            try {
                System.out.print("년, 월을 입력해주세요 ex) 2021 10\n※올바르지 않은 값 입력시 메뉴로 이동 >> ");
                int year = sc.nextInt();
                int month = sc.nextInt();
                sc.nextLine();
                calendar = new Calendar(year, month);
                calendar.printCal();
            } catch (Exception e) {
                System.out.println("메뉴로 돌아갑니다.");
                isWork = false;
            }
        }
    }

}
