import java.awt.*;
import java.awt.event.*; // . 이벤트 처리를 위해서 추가했다

class PopupMenuTest {
    public static void main(String args[]) {
        final Frame f = new Frame("PopupMenu Test");
        f.setSize(300, 200);

        final PopupMenu pMenu = new PopupMenu("Edit");
        MenuItem miCut = new MenuItem("Cut");
        MenuItem miCopy = new MenuItem("Copy");
        MenuItem miPaste = new MenuItem("Paste");
        Menu mOption = new Menu("Option");
        mOption.add(new MenuItem("Option1"));
        mOption.add(new MenuItem("Option2"));
        mOption.add(new MenuItem("Option3"));
        pMenu.add(miCut); // PopupMenu MenuItem . 에 들을 추가한다
        pMenu.add(miCopy);
        pMenu.add(miPaste);
        pMenu.add(mOption);

        f.add(pMenu); // PopupMenu Frame . 를 에 추가한다

        f.addMouseListener( new MouseAdapter() { // 익명클래스
            public void mousePressed(MouseEvent me) {
                if(me.getModifiers() == me.BUTTON3_MASK)
                    pMenu.show(f, me.getX(), me.getY());
            }
        });

        f.setVisible(true);

    }
}

