import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoFrame extends Frame {

    private Set<Integer> LottoNum = new HashSet<>();
    private Random ran = new Random();

    public LottoFrame(String title) {
        super(title);
        setBounds(250, 100, 1200, 800);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setButton();
        setVisible(true);
    }

    public void paint(Graphics g) {

        if (LottoNum.size() == 6) {
            List<Integer> listNum = new ArrayList<>(LottoNum);
            Collections.sort(listNum);
            for (int i = 0; i < 6; i++) {
                int num = listNum.get(i);
                if (num < 10) {
                    g.setColor(Color.yellow);
                } else if (num < 20) {
                    g.setColor(Color.blue);
                } else if (num < 30) {
                    g.setColor(Color.red);
                } else if (num < 40) {
                    g.setColor(Color.gray);
                } else {
                    g.setColor(Color.green);
                }
                g.fillOval(100 + 180 * i, 330, 130, 130);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Serif", Font.PLAIN, 30));
                g.drawString(String.valueOf(num),150 + 180 * i, 405);

            }
        }


    }

    private void setButton() {
        Panel p = new Panel();
        p.setBackground(Color.GRAY);
        Button button = new Button("추천!!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LottoNum.clear();
                while (LottoNum.size() < 6) {
                    LottoNum.add(ran.nextInt(45) + 1);
                }
                repaint();
            }
        });
        p.add(button);
        setBackground(Color.lightGray);
        add(p, "South");

    }
}
