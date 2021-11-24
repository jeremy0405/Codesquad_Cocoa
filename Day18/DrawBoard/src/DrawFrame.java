import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawFrame extends Frame {

    public DrawFrame(String title) {
        super(title);
        setBounds(250,100,1200,800);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setMenuBar();


        setVisible(true);
    }

    private void setMenuBar() {
        MenuBar mb = new MenuBar();
        Menu line = new Menu("직선");
        Menu rec = new Menu("사각형");
        Menu cir = new Menu("원");
        Menu cuv = new Menu("곡선");
        line.addActionListener(new FigureHandler());

        setMenuItem(line);
        setMenuItem(rec);
        setMenuItem(cir);
        setMenuItem(cuv);

        mb.add(line);
        mb.add(rec);
        mb.add(cir);
        mb.add(cuv);

        setMenuBar(mb);
    }

    private void setMenuItem(Menu menu) {
        MenuItem black = new MenuItem("검은색");
        MenuItem red = new MenuItem("빨간색");
        MenuItem blue = new MenuItem("파란색");
        black.addActionListener(new ColorHandler());
        red.addActionListener(new ColorHandler());
        blue.addActionListener(new ColorHandler());
        menu.add(black);
        menu.add(red);
        menu.add(blue);
    }

    class ColorHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO 색 지정 해주는 기능을 추가해야함.
            System.out.println(e.getActionCommand());
        }
    }

    private class FigureHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO 도형 지정 해주는 기능 추가해야함.
            System.out.println(e.getActionCommand());
        }
    }
}
