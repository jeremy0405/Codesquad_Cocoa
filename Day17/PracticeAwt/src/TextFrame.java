import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TextFrame {

    public static void main(String[] args) {
        Frame f = new Frame("텍스트영역, 버튼이 있는 프레임");
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        f.setSize(500,500);

        Panel center = new Panel();
        TextArea ta = new TextArea("기본 입력",20,30);
        ta.selectAll();
        center.add(ta);

        f.add(center, "Center");

        Panel under = new Panel();
        Button b1 = new Button("버튼1");
        under.add(b1);

        f.add(under,"South");

        f.setVisible(true);
    }
}
