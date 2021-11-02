import java.util.Scanner;

public class num2447 {

    static String star = "*";
    static String space = " ";

    static void draw(int num) {

        if (num == 3) {
            System.out.println("***");
            System.out.println("* *");
            System.out.println("***");
        } else {

            int temp = num / 3;

            for (int i = temp; i <= num; i *= 3) {
                for (int j = temp; j <= num; j *= 3) {
                    if (i == 2 * temp && j == 2 * temp) {

                    } else {
                        draw(temp);
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        double a = sc.nextLong(3);

        draw(num);
    }
}
