import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.AdjustmentEvent;

public class PaintFrame extends Frame {

    private int speed = 1;
    private Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL,0,5,0,50);
    private Label lSpeed = new Label("Speed : 1");

    public PaintFrame(String title) {
        super(title);
        lSpeed.setBackground(Color.yellow);
        lSpeed.setSize(65,15);
        lSpeed.setLocation(10,30);
        sb.setSize(260,20);
        sb.setLocation(20,250);
        add(sb);
        add(lSpeed);
        sb.addAdjustmentListener(new MyHandler());
        addWindowListener(new MyHandler());
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
        setResizable(false);

    }

    public int getSpeed() {
        return speed;
    }

    private class MyHandler extends WindowAdapter implements AdjustmentListener {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e){
            speed = sb.getValue();
            lSpeed.setText("Speed : " + speed);
        }
        @Override
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }

    }
}
