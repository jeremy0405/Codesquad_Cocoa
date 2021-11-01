import java.util.Scanner;

public class num11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        String num = sc.next();
        int sum = 0;

        for(int i = 0; i < total; i++){
            sum += ((int)num.charAt(i) - 48);
        }
        System.out.println(sum);
    }
}
