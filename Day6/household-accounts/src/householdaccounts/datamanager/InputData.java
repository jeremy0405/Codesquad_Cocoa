package householdaccounts.datamanager;

import java.util.ArrayList;
import java.util.Scanner;

public class InputData {

    public static ArrayList<Integer>[][][] yymmdd = new ArrayList[5][12][31];

    public static String content;
    public static int plusmoney;
    public static int minusmoney;

    public static int[] getYymmdd() {
        System.out.println("년 / 월 / 일 입력");
        Scanner sc = new Scanner(System.in);
        int[] ymd = new int[3];
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        ymd[0] = year;
        ymd[1] = month;
        ymd[2] = day;

        return ymd;
    }
}
