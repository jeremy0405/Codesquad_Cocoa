import java.awt.BasicStroke;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawFrame extends Frame {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private static int dx1;
    private static int dy1;
    private boolean isBlack = true;
    private boolean isRed = false;
    private boolean isBlue = false;
    private boolean isLine = true;
    private boolean isRect = false;
    private boolean isCir = false;
    private boolean isCuv = false;
    private boolean isEraser = false;

    public DrawFrame(String title) {
        super(title);
        setBounds(250, 100, 1200, 800);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setCheckbox();
        addMouseListener(new MouseGetter());
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if (isCuv) {
                    dx1 = me.getX();
                    dy1 = me.getY();
                    repaint();
                }
            }
        });

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        if (isBlack) {
            g.setColor(Color.black);
        }
        if (isRed) {
            g.setColor(Color.red);
        }
        if (isBlue) {
            g.setColor(Color.blue);
        }

        if (isLine) {
            g.drawLine(x1, y1, x2, y2);
        }
        if (isRect) {
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
        if (isCir) {
            g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
        if (isCuv) {
            g.fillOval(dx1 - 5, dy1 - 5, 10, 10);
        }
        if (isEraser) {
            g.clearRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    private void setCheckbox() {

        Panel figure = new Panel();
        figure.setBackground(Color.lightGray);
        CheckboxGroup figuregroup = new CheckboxGroup();
        Checkbox line = new Checkbox("직선", figuregroup, true);
        Checkbox rec = new Checkbox("사각형", figuregroup, false);
        Checkbox cir = new Checkbox("원", figuregroup, false);
        Checkbox cuv = new Checkbox("곡선", figuregroup, false);
        Checkbox eraser = new Checkbox("지우개", figuregroup, false);

        line.addItemListener(new FigureHandler());
        rec.addItemListener(new FigureHandler());
        cir.addItemListener(new FigureHandler());
        cuv.addItemListener(new FigureHandler());
        eraser.addItemListener(new FigureHandler());

        Panel color = new Panel();
        color.setBackground(Color.lightGray);
        CheckboxGroup colorgroup = new CheckboxGroup();
        Checkbox black = new Checkbox("검은색", colorgroup, true);
        Checkbox red = new Checkbox("빨간색", colorgroup, false);
        Checkbox blue = new Checkbox("파란색", colorgroup, false);

        black.addItemListener(new ColorHandler());
        red.addItemListener(new ColorHandler());
        blue.addItemListener(new ColorHandler());

        figure.add(line);
        figure.add(rec);
        figure.add(cir);
        figure.add(cuv);
        figure.add(eraser);

        color.add(black);
        color.add(red);
        color.add(blue);

        add(figure, "North");
        add(color, "South");

    }

    private class ColorHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getItem().equals("검은색")) {
                isBlack = true;
                isRed = false;
                isBlue = false;
            }
            if (e.getItem().equals("빨간색")) {
                isBlack = false;
                isRed = true;
                isBlue = false;
            }
            if (e.getItem().equals("파란색")) {
                isBlack = false;
                isRed = false;
                isBlue = true;
            }
        }
    }

    private class FigureHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getItem().equals("직선")) {
                isLine = true;
                isRect = false;
                isCir = false;
                isCuv = false;
                isEraser = false;
            }
            if (e.getItem().equals("사각형")) {
                isLine = false;
                isRect = true;
                isCir = false;
                isCuv = false;
                isEraser = false;
            }
            if (e.getItem().equals("원")) {
                isLine = false;
                isRect = false;
                isCir = true;
                isCuv = false;
                isEraser = false;
            }
            if (e.getItem().equals("곡선")) {
                isLine = false;
                isRect = false;
                isCir = false;
                isCuv = true;
                isEraser = false;
            }
            if (e.getItem().equals("지우개")) {
                isLine = false;
                isRect = false;
                isCir = false;
                isCuv = false;
                isEraser = true;
            }
        }
    }

    private class MouseGetter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }
    }
}
