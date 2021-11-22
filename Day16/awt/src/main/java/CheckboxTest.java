import java.awt.*;

public class CheckboxTest {

    public static void main(String[] args) {
        Frame f = new Frame("질문");
        f.setSize(305,250);
        f.setLayout(new FlowLayout());

        Label q1 = new Label("1. 당신의 관심 분야는? (다중선택 가능)", Label.CENTER);
        Checkbox news = new Checkbox("news", true);
        Checkbox sports = new Checkbox("sports");
        Checkbox movies = new Checkbox("movies");
        f.add(q1);
        f.add(news);
        f.add(sports);
        f.add(movies);

        Label q2 = new Label("2. 얼마나 자주 극장에 가십니까?", Label.CENTER);
        CheckboxGroup group1 = new CheckboxGroup();
        Checkbox m1 = new Checkbox("일주일에 1번", group1,true);
        Checkbox m2 = new Checkbox("일주일에 2번", group1, false);
        Checkbox m3 = new Checkbox("일주일에 3번", group1, false);
        f.add(q2);
        f.add(m1);
        f.add(m2);
        f.add(m3);

        f.setVisible(true);
    }
}
