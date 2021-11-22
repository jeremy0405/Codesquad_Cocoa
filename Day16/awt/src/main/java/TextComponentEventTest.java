import java.awt.*;
import java.awt.event.*;
import myhandler.WindowHandler;

class TextComponentEventTest extends Frame {
    TextField tf;
    TextArea ta;
    TextComponentEventTest(String title) {
        super(title); // Frame(String title) . 을 호출한다
        tf = new TextField();
        ta = new TextArea();

        addWindowListener(new WindowHandler());


        add(ta, "Center");
        add(tf, "South");

        tf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ta.append(tf.getText() + "\n");
                tf.setText(""); // tf text . 의 를 지운다
                tf.requestFocus();
            }
        });

        ta.setEditable(false); // TextArea text . 의 를 편집하지 못하게 한다
        setSize(300, 200);
        setVisible(true);
        tf.requestFocus(); // focus TextField . 가 에 위치하도록 한다
    }

    public static void main(String[] args) {
        TextComponentEventTest mainWin =
            new TextComponentEventTest("TextComponentEventTest");
    }
}

