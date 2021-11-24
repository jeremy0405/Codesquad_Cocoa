import java.awt.*;
import java.awt.event.*;
class GraphicsEx1 extends Frame {

    public void paint(Graphics g) {
//        g.setFont(new Font("Serif", Font.PLAIN, 15));
//        g.drawString("Graphics를 이용해서 그림을 그림." ,10, 50);
//        g.drawOval(50,100, 50,50);
//
//        g.setColor(Color.blue);
//        g.fillOval(100,100, 50,50);
//
//        g.setColor(Color.red);
//        g.drawLine(100,100, 150,150);

//        g.fillRoundRect(200, 100, 120, 80, 30, 30);

        g.setColor(Color.orange);
        g.fillPolygon(new int[]{ 80, 50, 150, 150},
            new int[]{50, 200, 200, 30}, 4);


//        g.setColor(Color.cyan);
//        g.fillArc(250, 200, 100, 100, 0, 120);
    }

    public GraphicsEx1(String title) {
        super(title);
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        setBounds(100,100, 400,300);

        setVisible(true);
    }
}

