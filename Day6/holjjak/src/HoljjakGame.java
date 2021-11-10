import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HoljjakGame {

    public static int PlayerMoney;
    public static int CounterMoney;
    public static int MaxPlayerMoney;
    public static int turn;
    public static ArrayList<String> RankName = new ArrayList<>();
    public static ArrayList<Integer> RankMoney = new ArrayList<>();
    public static ArrayList<Integer> RankTurn = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    private static String getPlayerName() {
        System.out.print("이름을 입력하세요! >>>>> ");
        String playerName = sc.nextLine();
        return playerName;
    }

    public static boolean gameStart(String name) {
        Random ran = new Random();

        while (true) {
            turn++;
            printStatus(name);

            int num = ran.nextInt(20);
            System.out.println("치트키 : " + num);

            int bet = getBet();

            checkHolJjak(num, bet);

            if (PlayerMoney == 0) {

                System.out.printf("Round 종료!!\n\n\n\n");

                printResult(name);

                return false;
            }

            if (CounterMoney == 0) {

                System.out.printf("Round 종료!!\n\n\n\n");
                return true;
            }
        }
    }

    private static void checkHolJjak(int num, int bet) {
        System.out.print("홀 또는 짝을 입력해주세요 : ");

        sc.nextLine();
        String input = sc.nextLine();

        if (input.equals("홀")) {
            if (num % 2 == 1) {
                System.out.println("Player의 승리\n\n");
                PlayerMoney += bet;
                MaxPlayerMoney = Math.max(PlayerMoney, MaxPlayerMoney);
                CounterMoney -= bet;
            } else {
                System.out.println("상대방의 승리\n\n");
                PlayerMoney -= bet;
                CounterMoney += bet;
            }
        }

        if (input.equals("짝")) {
            if (num % 2 == 0) {
                System.out.println("Player의 승리\n\n");
                PlayerMoney += bet;
                MaxPlayerMoney = Math.max(PlayerMoney, MaxPlayerMoney);
                CounterMoney -= bet;
            } else {
                System.out.println("상대방의 승리\n\n");
                PlayerMoney -= bet;
                CounterMoney += bet;
            }
        }
    }

    private static int getBet() {
        System.out.print("배팅 금액을 입력하세요! >>>>> ");
        int bet = sc.nextInt();
        if (bet > Math.min(PlayerMoney, CounterMoney)) {
            System.out.printf("베팅 금액을 %d 이하로 입력해 주세요! >>>>> ", Math.min(PlayerMoney, CounterMoney));
            bet = sc.nextInt();
        }
        return bet;
    }

    private static void printStatus(String name) {
        System.out.println("User Name : " + name);
        System.out.println("Your Money : " + PlayerMoney);
        System.out.println("Counter Money : " + CounterMoney);
        System.out.println("turn : " + turn);
    }

    private static boolean gameRun(String name) {
        boolean KeepGame = true;
        int Round = 1;
        PlayerMoney = 100;
        CounterMoney = 120;
        MaxPlayerMoney = 100;
        turn = 0;
        while (KeepGame) {
            System.out.println("Round " + Round);
            KeepGame = gameStart(name);
            Round++;
            if (Round == 9) {
                printResult(name);
                break;
            }
            CounterMoney = (int) (PlayerMoney * Math.pow(1.2, Round));
        }

        return vaildation();

    }

    private static boolean vaildation() {
        System.out.print("게임을 더 진행하시겠습니까? (Y/N) >>>>> ");
        String YesNo = sc.nextLine();

        if (YesNo.equals("Y")) {
            return true;
        } else if (YesNo.equals("N")) {
            return false;
        } else {
            System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요!");
            return vaildation();
        }
    }

    private static void printResult(String name) {

        getUserData(name);

        System.out.println("====================RankerBoard======================");
        for (int i = 0; i < RankName.size(); i++) {
            System.out.printf("User Name : %8s \t Max Money : %5d \t Turn : %3d\n", RankName.get(i),
                RankMoney.get(i), RankTurn.get(i));
        }
        System.out.println("=====================================================");
        System.out.println("\n\n\n\n\n\n");

    }

    private static void getUserData(String name) {
        if (RankName.size() == 0) {
            RankName.add(name);
            RankMoney.add(MaxPlayerMoney);
            RankTurn.add(turn);
        } else {
            int idx;
            for (int i = 0; i < RankMoney.size(); i++) {
                if (MaxPlayerMoney > RankMoney.get(i)) {
                    idx = i;
                    RankName.add(idx, name);
                    RankMoney.add(idx, MaxPlayerMoney);
                    RankTurn.add(idx, turn);
                    break;
                } else if (MaxPlayerMoney == RankMoney.get(i)) {
                    for (int j = 0; j < RankTurn.size(); j++) {
                        if (turn > RankTurn.get(j)) {
                            idx = j;
                            RankName.add(idx, name);
                            RankMoney.add(idx, MaxPlayerMoney);
                            RankTurn.add(idx, turn);
                            break;
                        } else {
                            RankName.add(name);
                            RankMoney.add(MaxPlayerMoney);
                            RankTurn.add(turn);
                            break;
                        }
                    }
                    break;
                } else {
                    RankName.add(name);
                    RankMoney.add(MaxPlayerMoney);
                    RankTurn.add(turn);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        boolean isKeepGame = true;

        while (isKeepGame) {
            String name = getPlayerName();
            isKeepGame = gameRun(name);
        }


    }

}
