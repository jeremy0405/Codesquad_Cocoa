import java.awt.*;
import java.awt.event.*;
import myhandler.WindowHandler;

class CheckboxEventTest extends Frame {

    Label q1;
    Label q2;
    Label score;
    Checkbox q1cb1, q1cb2, q1cb3, q1cb4;
    Checkbox q2cb1, q2cb2, q2cb3, q2cb4;
    CheckboxGroup group;
    Button end;

    CheckboxEventTest(String title) {
        super(title); // Frame(String title) . 을 호출한다
        setSize(500, 300);
        setLayout(new GridLayout(13, 1));
        addWindowListener(new WindowHandler());
        q1 = new Label("1. ActionEvent actionPerformed?");
        q1cb1 = new Checkbox("When press Button");

        q1cb2 = new Checkbox("When press Enter key in TextField");

        q1cb3 = new Checkbox("When click MenuItem");

        q1cb4 = new Checkbox("When double click List item");

        q2 = new Label("2. Frame's default LayoutManager? (choose one)");

        group = new CheckboxGroup();
        q2cb1 = new Checkbox("FlowLayout", group, false);
        q2cb2 = new Checkbox("GridLayout", group, false);
        q2cb3 = new Checkbox("BorderLayout", group, false);
        q2cb4 = new Checkbox("CardLayout", group, false);

        score = new Label("* your score :");

        end = new Button("push this button for get your score.");

        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                float totalScore = 0;
                if (q1cb1.getState()) {
                    totalScore += 12.5;
                }
                if (q1cb2.getState()) {
                    totalScore += 12.5;
                }
                if (q1cb3.getState()) {
                    totalScore += 12.5;
                }
                if (q1cb4.getState()) {
                    totalScore += 12.5;
                }
                if (q2cb3.getState()) {
                    totalScore += 50;
                }
                score.setText("* your score : " + totalScore);
            }
        });
        add(q1);
        add(q1cb1);
        add(q1cb2);
        add(q1cb3);
        add(q1cb4);
        add(new Label("")); // 문제들 사이에 빈 줄을 하나 삽입하기 위해 사용
        add(q2);
        add(q2cb1);
        add(q2cb2);
        add(q2cb3);
        add(q2cb4);
        add(end);
        add(score);
        setVisible(true);
    }

    public static void main(String args[]) {
        CheckboxEventTest mainWin =
            new CheckboxEventTest("CheckboxEventTest - Quiz");
    }
}
