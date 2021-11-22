import java.awt.*;
import java.awt.event.*;
class FileDialogTest {
    public static void main(String[] args) {
        Frame f = new Frame("Parent");
        f.setSize(300, 200);

        FileDialog fileOpen = new FileDialog(f, "title", FileDialog.LOAD);
        f.setVisible(true);
        fileOpen.setDirectory("C:\\Users\\hsjan\\Desktop");
        fileOpen.setVisible(true);

        System.out.println(fileOpen.getDirectory() + fileOpen.getFile());
    }
}
