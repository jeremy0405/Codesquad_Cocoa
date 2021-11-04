import java.util.*;

public class PracticeList {

    public static void main(String[] args) {

        ArrayList<String> str = new ArrayList<>();

        str.add("딸기");
        str.add("포도");
        str.add("사과");
        str.add("배");

        str.add(1, "딸기랑 포도사이");
        str.remove("딸기");

        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }

        int idx = str.indexOf("배");
        System.out.println(idx);

        System.out.println("");
        System.out.println("");

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(1);
        integers.add(2);

        integers.remove(1);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }

    }

}
