import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HoljjakGame {

    public static int PlayerMoney = 100;
    public static int CounterMoney = 120;
    public static Scanner sc = new Scanner(System.in);

    private static String getPlayerName() {
        System.out.println("이름을 입력하세요!");
        String playerName = sc.nextLine();
        return playerName;
    }

    public static boolean gameStart(String name) {
        Random ran = new Random();

        boolean isKeepGame = true;

        while (isKeepGame) {

            printStatus(name);

            int num = ran.nextInt(20);
            System.out.println("치트키 : " + num);

            int bet = getBet();

            checkHolJjak(num, bet);

            if (PlayerMoney == 0) {
                isKeepGame = false;
                System.out.printf("Round 종료!!\n\n\n\n");
                return false;
            }

            if (CounterMoney == 0) {
                isKeepGame = false;
                System.out.printf("Round 종료!!\n\n\n\n");
                return true;
            }
        }
        return true;
    }

    private static void checkHolJjak(int num, int bet) {
        System.out.print("홀 또는 짝을 입력해주세요 : ");

        sc.nextLine();
        String input = sc.nextLine();

        if (input.equals("홀")) {
            if (num % 2 == 1) {
                System.out.println("Player의 승리");
                PlayerMoney += bet;
                CounterMoney -= bet;
            } else {
                System.out.println("상대방의 승리");
                PlayerMoney -= bet;
                CounterMoney += bet;
            }
        }

        if (input.equals("짝")) {
            if (num % 2 == 0) {
                System.out.println("Player의 승리");
                PlayerMoney += bet;
                CounterMoney -= bet;
            } else {
                System.out.println("상대방의 승리");
                PlayerMoney -= bet;
                CounterMoney += bet;
            }
        }
    }

    private static int getBet() {
        System.out.println("배팅 금액을 입력하세요!");
        int bet = sc.nextInt();
        if (bet > Math.min(PlayerMoney, CounterMoney)) {
            System.out.printf("베팅 금액을 %d 이하로 입력해 주세요!\n", Math.min(PlayerMoney, CounterMoney));
            bet = sc.nextInt();
        }
        return bet;
    }

    private static void printStatus(String name) {
        System.out.println("User Name : " + name);
        System.out.println("Your Money : " + PlayerMoney);
        System.out.println("Counter Money : " + CounterMoney);
    }

    private static void gameRun(String name) {
        boolean KeepGame = true;
        int Round = 1;
        while (KeepGame) {
            System.out.println("Round " + Round);
            KeepGame = gameStart(name);
            Round++;
            if(Round == 9) {
                break;
            }
            CounterMoney = (int) (PlayerMoney * Math.pow(1.2, Round));
        }
    }

    public static void main(String[] args) throws IOException {

        String name = getPlayerName();

        gameRun(name);
    }

}
