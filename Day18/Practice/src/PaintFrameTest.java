import java.awt.*;
import java.awt.event.*;

public class PaintFrameTest {

    public static void main(String[] args) {
        PaintFrame f = new PaintFrame("PaintFrame");

        Graphics g = f.getGraphics();
        g.setColor(Color.red);

        for (int i = 0; true; i += f.getSpeed()) {
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.clearRect(0, 0, 300, 300);
            g.drawString("Hello", i, 150);
            i = (i < 300) ? i : 0;
        }
    }
}
