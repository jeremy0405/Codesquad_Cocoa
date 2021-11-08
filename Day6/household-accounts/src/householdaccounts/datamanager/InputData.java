package householdaccounts.datamanager;

import java.util.ArrayList;

public class InputData {

    public static ArrayList<Integer> year = new ArrayList<>();
    public static ArrayList<Integer> month = new ArrayList<>();
    public static ArrayList<Integer> day = new ArrayList<>();
    public static String content;
    public static int plusmoney;
    public static int minusmoney;

    public static void setYear(ArrayList<Integer> year) {
        InputData.year = year;
    }

    public static void setMonth(ArrayList<Integer> month) {
        InputData.year = month;
    }

    public static void setDay(ArrayList<Integer> day) {
        InputData.year = year;
    }
}
