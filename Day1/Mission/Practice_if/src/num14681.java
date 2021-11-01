import java.util.Scanner;

public class num14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[2];
        num[0] = sc.nextInt();
        num[1] = sc.nextInt();

        if(num[0] * num[1] > 0){
            if(num[0] > 0) System.out.println(1);
            else System.out.println(3);
        } else if(num[0] > 0) System.out.println(4);
        else System.out.println(2);

    }
}
