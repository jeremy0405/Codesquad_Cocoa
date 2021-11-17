import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isWork = true;
        while (isWork) {
            isWork = run();
        }
    }

    private static boolean run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("clock or cal >> ");
        String command = sc.nextLine();
        return choiceOption(command);
    }

    private static boolean choiceOption(String command) {
        if (command.equals("clock")) {
            hclock();
            return false;
        } else if (command.equals("cal")) {
            calendar();
            return true;
        } else {
            run();
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

    private static void hclock() {
        while (true) {
            try {
                HangulClock hangulClock = new HangulClock();
                hangulClock.run();
                Thread.sleep(2000); // 2초마다 갱신.
//                Scanner sc = new Scanner(System.in);
//                int a = sc.nextInt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
