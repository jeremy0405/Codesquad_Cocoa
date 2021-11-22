import java.awt.*;
import myhandler.WindowHandler;

public class exitTest {

    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(200,200);

        f.addWindowListener(new WindowHandler());
        f.setVisible(true);
    }
}
