import java.awt.*;
import java.awt.event.*;

public class TextEvent {

    public static void main(String[] args) {
        Frame f = new Frame("텍스트 입력 이벤트");
        f.setSize(500,300);
        f.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 250,Toolkit.getDefaultToolkit().getScreenSize().height/2 - 300);
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        Panel textArea = new Panel();
        TextArea ta = new TextArea(15,50);
        ta.setEnabled(false);

        Panel textField = new Panel();
        TextField tf = new TextField(50);
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var a = e.getActionCommand();
                if(a.equals("X")){
                    f.setVisible(false);
                    f.dispose();
                }
                ta.append(a + "\n");
                tf.setText("");
                tf.requestFocus();
            }
        });

        textArea.add(ta);
        textField.add(tf);

        f.add(textArea, "Center");
        f.add(textField, "South");

        f.setVisible(true);
    }
}
