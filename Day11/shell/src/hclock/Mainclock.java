package hclock;

public class Mainclock {

    public void clockRun() {
        boolean isWork = true;
        while (isWork) {
            isWork = Menu.systemRun();
        }
    }

}
