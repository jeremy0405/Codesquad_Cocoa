import java.awt.*;

public class MenuTest {

    public static void main(String[] args) {
        Frame f = new Frame("메뉴 만들기");
        f.setSize(300,200);

        MenuBar mb = new MenuBar();

        Menu mFile = new Menu("File");

        MenuItem miNew = new MenuItem("New");
        MenuItem miOpen = new MenuItem("Open");
        Menu mOthers = new Menu("Others");
        MenuItem miExit = new MenuItem("Exit");

        mOthers.add(new MenuItem("Other1"));
        mOthers.add(new MenuItem("Other2"));
        mOthers.add(new MenuItem("Other3"));


        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(mOthers);
        mFile.addSeparator();
        mFile.add(miExit);

        Menu mEdit = new Menu("Edit");
        Menu mView = new Menu("View");
        Menu mHelp = new Menu("Help");
        CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar");
        mView.add(miStatusbar);

        mb.add(mFile);
        mb.add(mEdit);
        mb.add(mView);
        mb.setHelpMenu(mHelp);

        f.setMenuBar(mb);
        f.setVisible(true);

    }
}
