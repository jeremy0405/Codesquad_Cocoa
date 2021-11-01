import java.util.Scanner;

public class num2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        String space = " ";
        String star = "*";
        int row = 2 * num;

        for(int i = 1; i <= num; i++){
            System.out.print(star.repeat(i));
            System.out.print(space.repeat(row-2*i));
            System.out.println(star.repeat(i));
        }

        for(int i = num-1; i >= 1; i--){
            System.out.print(star.repeat(i));
            System.out.print(space.repeat(row-2*i));
            System.out.println(star.repeat(i));
        }
    }
}