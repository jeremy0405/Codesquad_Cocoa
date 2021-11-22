import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myhandler.WindowHandler;

public class TextFieldTest2 extends Frame {

    Label lId;
    Label lPwd;
    TextField tfId;
    TextField tfPwd;
    Button ok;

    TextFieldTest2 (String title) {
        Frame f = new Frame(title);
        f.addWindowListener(new WindowHandler());

        lId = new Label("ID :", Label.RIGHT);
        lPwd = new Label("Password :", Label.RIGHT);

        tfId = new TextField(10);
        tfPwd = new TextField(10);
        tfPwd.setEchoChar('*');

        ok = new Button("OK");

        tfId.addActionListener(new EventHandler());
        tfPwd.addActionListener(new EventHandler());
        ok.addActionListener(new EventHandler());

        f.setLayout(new FlowLayout());
        f.add(lId);
        f.add(tfId);
        f.add(lPwd);
        f.add(tfPwd);
        f.add(ok);

        f.setSize(450, 65);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new TextFieldTest2("Login");
    }

    class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = tfId.getText(); // tfId text . 에 입력되어있는 를 얻어온다
            String password = tfPwd.getText();
            if (!id.equals("jeremy0405")){
                System.out.println("입력하신 id가 존재하지 않습니다. 다시 입력해 주세요.");
                tfId.requestFocus();
                tfId.selectAll();
            } else if (!password.equals("qwer12")) {
                System.out.println("입력하신 비밀번호가 틀렸습니다. 다시 입력해 주세요.");
                tfPwd.requestFocus();
                tfPwd.selectAll();
            } else {
                System.out.println(id + "님, 성공적으로 로그인 되었습니다.");
            }
        }
    }

}
