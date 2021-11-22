import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.*;
import myhandler.WindowHandler;

public class CardLayoutEventTest extends Frame {

    Panel slide;
    Panel s1, s2, s3, s4, s5;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Panel button;
    CardLayout card;

    CardLayoutEventTest (String title) {
        super(title);

        addWindowListener(new WindowHandler());

        card = new CardLayout();
        slide = new Panel(card);

        button = new Panel(new FlowLayout());
        b1 = new Button("<<");
        b2 = new Button("<");
        b3 = new Button(">");
        b4 = new Button(">>");
        button.add(b1);
        button.add(b2);
        button.add(b3);
        button.add(b4);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.first(slide);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.previous(slide);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.next(slide);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.last(slide);
            }
        });
        button.setBackground(Color.YELLOW);

        add(button, "South");

        s1 = new Panel();
        s1.setBackground(Color.WHITE);
        s1.add(new Label("1번 슬라이드"));
        s2 = new Panel();
        s2.setBackground(Color.BLUE);
        s2.add(new Label("2번 슬라이드"));
        s3 = new Panel();
        s3.setBackground(Color.green);
        s3.add(new Label("3번 슬라이드"));
        s4 = new Panel();
        s4.setBackground(Color.PINK);
        s4.add(new Label("4번 슬라이드"));
        s5 = new Panel();
        s5.setBackground(Color.MAGENTA);
        Label label = new Label("5번 슬라이드");
        label.setForeground(Color.white);
        s5.add(label);

        slide.add(s1,"1");
        slide.add(s2,"2");
        slide.add(s3,"3");
        slide.add(s4,"4");
        slide.add(s5,"5");

        add(slide,"Center");

        setSize(300,300);
        setLocation(300,300);
        setVisible(true);

        card.show(slide, "1");
    }

    public static void main(String[] args) {
        CardLayoutEventTest ct = new CardLayoutEventTest("카드레이아웃이벤트테스트");
    }

}
