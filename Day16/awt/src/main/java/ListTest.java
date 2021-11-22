import java.awt.*;

public class ListTest {

    public static void main(String[] args) {
        Frame f = new Frame("List - Select");
        f.setSize(300,200);
        f.setLayout(null);

        List selectOne = new List(10);
        selectOne.setSize(100,120);
        selectOne.setLocation(20,40);
        selectOne.add("Student1");
        selectOne.add("Student2");
        selectOne.add("Student3");
        selectOne.add("Student4");
        selectOne.add("Student5");
        selectOne.add("Student6");
        selectOne.add("Student7");

        List selectMany = new List(3,true);
        selectMany.setSize(100,120);
        selectMany.setLocation(150,40);
        selectMany.add("Student1");
        selectMany.add("Student2");
        selectMany.add("Student3");
        selectMany.add("Student4");
        selectMany.add("Student5");
        selectMany.add("Student6");
        selectMany.add("Student7");

        f.add(selectMany);
        f.add(selectOne);
        f.setVisible(true);
    }
}
