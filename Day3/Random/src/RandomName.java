import java.util.*;

public class RandomName {

    public static int Getnum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 명인가요? ");
        int a = sc.nextInt();
        sc.close();
        return a;
    }

    public static void main(String[] args) {
        int num = Getnum();

        String[] name = {"Jerry", "donggi", "땃쥐", "후", "Tany", "피오", "K", "taksu", "MK", "노리",
            "mandoo"};

        Random random = new Random();

        for (int i = 0; i < num; i++) {
            System.out.print(name[random.nextInt(11)]);
            if(i != num - 1){
                System.out.print(", ");
            }
        }


    }

}
