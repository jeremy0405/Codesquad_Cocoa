import java.util.Scanner;

public class num2438 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 1; i <= num; i++){
            String star = "*";
            System.out.println(star.repeat(i));
        }
    }
}
