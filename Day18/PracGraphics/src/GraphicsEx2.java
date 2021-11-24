import java.awt.*;
import java.awt.event.*;
class GraphicsEx2 extends Frame implements MouseMotionListener {
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    public GraphicsEx2(String title) {
        super(title);
        addMouseMotionListener(this);
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setBounds(100,100, 500,500);
        setVisible(true);
    }
    public void paint(Graphics g) {
        g.drawString("마우스를 움직여보세요." ,10, 50);
        g.setColor(Color.red);
        g.drawLine(x1, y1, x2, y2);
    }
    public void update (Graphics g) {
        paint(g);
    }

    public void mouseDragged(MouseEvent me) {
        if (me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) {
            return;
        }
        x2 = me.getX();
        y2 = me.getY();
        x1 = x2;
        y1 = y2;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
//        x2 = me.getX();
//        y2 = me.getY();
//        x1 = x2;
//        y1 = y2;
//        repaint();
    }
} // class
