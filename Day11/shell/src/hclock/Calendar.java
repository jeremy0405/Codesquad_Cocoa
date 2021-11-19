package hclock;

import java.time.LocalDate;

public class Calendar {

    private int year;
    private int month;
    private int day = 1;
    private int today;

    private LocalDate date;

    Calendar() {
        date = LocalDate.now();
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.today = date.getDayOfMonth();
    }

    Calendar(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public void printCal() {
        date = LocalDate.of(this.year, this.month, this.day);

        String week = date.getDayOfWeek().toString();
        int tmp = getTmp(week);

        StringBuilder sb = new StringBuilder();
        String yymm = this.year + "년 " + this.month + "월\n";
        sb.append(yymm);

        sb.append(" SUN MON TUE WED THU FRI SAT\n");
        for (int i = 0; i < tmp; i++) {
            sb.append("    ");
        }
        for (int i = 1; i <= date.lengthOfMonth(); i++) {
            if (i < 10) {
                sb.append("   ").append(i);
            } else {
                sb.append("  ").append(i);
            }
            if (tmp % 7 == 6) {
                sb.append("\n");
            }
            tmp++;
        }
        System.out.println(sb.toString());
    }

    private static int getTmp(String week) {
        int tmp = 0;
        switch (week) {
            case "SUNDAY":
                tmp = 0;
                break;
            case "MONDAY":
                tmp = 1;
                break;
            case "TUESDAY":
                tmp = 2;
                break;
            case "WEDNESDAY":
                tmp = 3;
                break;
            case "THURSDAY":
                tmp = 4;
                break;
            case "FRIDAY":
                tmp = 5;
                break;
            case "SATURDAY":
                tmp = 6;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + week);
        }
        return tmp;
    }


}
