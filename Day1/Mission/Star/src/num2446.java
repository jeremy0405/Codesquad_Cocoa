import java.util.Scanner;

public class num2446 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int row = num * 2 - 1;

        String star = "*";
        String space = " ";

        for (int i = 0; i < num; i++) {
            System.out.print(space.repeat(i));
            System.out.println(star.repeat(row - 2 * i));
        }

        for (int i = num - 2; i >= 0; i--) {
            System.out.print(space.repeat(i));
            System.out.println(star.repeat(row - 2 * i));
        }
    }
}
