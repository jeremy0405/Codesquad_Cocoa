import java.util.Scanner;

public class num2439 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            String star = "*";
            String space = " ";
            System.out.println(space.repeat(num - i) + star.repeat(i));
        }
    }
}