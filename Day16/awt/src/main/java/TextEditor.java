import java.awt.*;
import java.awt.event.*;
import java.io.*;
import myhandler.WindowHandler;

class TextEditor extends Frame {

    String fileName;
    TextArea content;
    MenuBar mb;
    Menu mFile;
    MenuItem miNew, miOpen, miSaveAs, miExit;

    TextEditor(String title) {
        super(title);
        addWindowListener(new WindowHandler());

        content = new TextArea();
        add(content);

        mb = new MenuBar();

        mFile = new Menu("File");
        miNew = new MenuItem("New");
        miOpen = new MenuItem("Open");
        miSaveAs = new MenuItem("Save As...");
        miExit = new MenuItem("Exit");
        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSaveAs);
        mFile.addSeparator(); // (separator) . 메뉴 분리선 을 넣는다
        mFile.add(miExit);

        mb.add(mFile); // MenuBar Menu . 에 를 추가한다
        setMenuBar(mb); // Frame MenuBar .

        MyHandler handler = new MyHandler();
        miNew.addActionListener(handler);
        miOpen.addActionListener(handler);
        miSaveAs.addActionListener(handler);
        miExit.addActionListener(handler);
        setSize(300, 200);
        setVisible(true);
    }

    // TextArea 선택된 파일의 내용을 읽어서 에 보여주는 메서드
    void fileOpen(String fileName) {
        FileReader fr;
        BufferedReader br;
        StringWriter sw;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            sw = new StringWriter();

            int ch = 0;
            while ((ch = br.read()) != -1) {
                sw.write(ch);
            }
            br.close();
            content.setText(sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void saveAs(String fileName) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            bw.write(content.getText()); // TextArea . 의 내용을 파일에 저장한다
            bw.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        } // try
    } // saveAs메서드의 끝

    public static void main(String args[]) {
        TextEditor mainWin = new TextEditor("Text Editor");
    } // main메서드의 끝

    // 메뉴를 클릭했을 때 메뉴별 처리코드
    class MyHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String command = e.getActionCommand();
            if (command.equals("New")) {
                content.setText("");
            } else if (command.equals("Open")) {
                FileDialog fileOpen =
                    new FileDialog(TextEditor.this, " ");
                fileOpen.setVisible(true);
                fileName = fileOpen.getDirectory() + fileOpen.getFile();
                System.out.println(fileName);
                fileOpen(fileName);
            } else if (command.equals("Save As...")) {
                FileDialog fileSave =
                    new FileDialog(TextEditor.this, " ", FileDialog.SAVE);
                fileSave.setVisible(true);
                fileName = fileSave.getDirectory() + fileSave.getFile();
                System.out.println(fileName);
                saveAs(fileName);
            } else if (command.equals("Exit")) {
                System.exit(0);
            }
        }
    }
}
