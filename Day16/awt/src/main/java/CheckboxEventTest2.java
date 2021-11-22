import java.awt.*;
import java.awt.event.*;
import myhandler.WindowHandler;

class CheckboxEventTest2 extends Frame {
    CheckboxGroup group;
    Checkbox cb1;
    Checkbox cb2;
    Checkbox cb3;

    CheckboxEventTest2(String title) {
        super(title);

        group = new CheckboxGroup();

        cb1 = new Checkbox("red", group, false);
        cb2 = new Checkbox("green", group, false);
        cb3 = new Checkbox("blue", group, false);

        cb1.addItemListener(new EventHandler());
        cb2.addItemListener(new EventHandler());
        cb3.addItemListener(new EventHandler());

        setSize(300, 200);
        setLayout(new FlowLayout());
        setBackground(Color.white);
        addWindowListener(new WindowHandler());

        add(cb1);
        add(cb2);
        add(cb3);

        setVisible(true);
    }

    public static void main(String args[]) {
        CheckboxEventTest2 mainWin =
            new CheckboxEventTest2("CheckboxEventTest2");
    }

    class EventHandler implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            Checkbox cb = (Checkbox) e.getSource();
            String color = cb.getLabel();
            if(color.equals("red")) {
                setBackground(Color.red);
            } else if (color.equals("green")) {
                setBackground(Color.green);
            } else {
                setBackground(Color.blue);
            }
        }
    }

}
