import java.awt.*;

public class FrameTest {

    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300,200);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        Button b = new Button("메 뉴");
        b.setSize(100, 50);

        f.add(b);
        f.setLocation(screenSize.width/2 - 150, screenSize.height/2 - 100);
        f.setVisible(true);
    }

}
