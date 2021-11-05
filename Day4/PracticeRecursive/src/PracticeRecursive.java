import java.util.Scanner;

public class PracticeRecursive {

    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        for(int i = 0; i < n; i++){
            System.out.printf("%4d", fibonacci(i));
        }
    }

}
