import java.util.Scanner;

public class num2442 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        String space = " ";
        String star = "*";
        int row = 2 * num - 1;

        for (int i = num; i > 0; i--) {
            System.out.print(space.repeat(i - 1));
            System.out.println(star.repeat(row - 2 * (i - 1)));
        }
    }
}
