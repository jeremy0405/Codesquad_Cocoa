import java.awt.*;
import java.awt.event.*;

public class CardLayout {

    public static void main(String[] args) {
        final Frame f = new Frame("카드레이아웃");
        java.awt.CardLayout card = new java.awt.CardLayout(10,10);
        f.setLayout(card);

        Panel card1 = new Panel();
        card1.setBackground(Color.WHITE);
        card1.add(new Label("라벨 카드1"));

        Panel card2 = new Panel();
        card2.setBackground(Color.BLUE);
        card2.add(new Label("라벨 카드2"));

        Panel card3 = new Panel();
        card3.setBackground(Color.GREEN);
        card3.add(new Label("라벨 카드3"));

        f.add(card1, "1");
        f.add(card2, "2");
        f.add(card3, "3");

        class Handler extends MouseAdapter {

            public void mouseClicked(MouseEvent e) {
                if (e.getModifiers() == e.BUTTON3_MASK) {
                    card.previous(f);
                } else {
                    card.next(f);
                }
            }
        }

        card1.addMouseListener(new Handler());
        card2.addMouseListener(new Handler());
        card3.addMouseListener(new Handler());

        f.setSize(200,200);
        f.setLocation(200,200);
        f.setVisible(true);

        card.show(f,"1");

    }
}
