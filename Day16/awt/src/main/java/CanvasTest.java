import java.awt.*;

public class CanvasTest {

    public static void main(String[] args) {
        Frame f = new Frame("Canvas");
        f.setSize(800,800);
        f.setLayout(null);

        Canvas c = new Canvas();
        c.setBackground(Color.GRAY);
        c.setBounds(50,50,500,500);

        f.add(c);
        f.setVisible(true);
    }
}
