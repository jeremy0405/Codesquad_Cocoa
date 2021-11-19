package hclock;

import java.time.LocalTime;

public class HangulClock {

    private int hour;
    private int minute;
    LocalTime now = LocalTime.now();

    HangulMap hangulMap = new HangulMap();

    public void clockRun() {
        setHour();
        setMinute();

        hangulMap.setMap(this.hour, this.minute);
        String[][] map = hangulMap.getMap();

        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%d: %02d%n%n",
            this.hour, this.minute);

        hangulMap.printMap(map);
    }

    public void setHour() {
        this.hour = now.getHour();
    }

    public void setMinute() {
        this.minute = now.getMinute();
    }

}
