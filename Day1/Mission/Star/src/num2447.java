import java.util.Scanner;

public class num2447 {

    static String star = "*";
    static String space = " ";

    static void draw(int num){

        System.out.print(star.repeat(num));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i = 3; i <= num; i *= 3)
        {
            draw(i);
        }
    }
}
