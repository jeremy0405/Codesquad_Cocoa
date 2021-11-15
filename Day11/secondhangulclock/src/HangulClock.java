import java.time.LocalTime;

public class HangulClock {

    private int hour;
    private int minute;
    LocalTime now = LocalTime.now();

    HangulMap hangulMap = new HangulMap();

    public void run(){
        setHour();
        setMinute();

        hangulMap.setMap(this.hour, this.minute);
        String[][] map = hangulMap.getMap();

        System.out.printf("%d: %d\n\n", this.hour, this.minute);

        hangulMap.printMap(map);
    }

    public void setHour() {
        this.hour = now.getHour();
    }

    public void setMinute() {
        this.minute = now.getMinute();
    }

    public static HangulClock getNewClass(){
        return new HangulClock();
    }
}
