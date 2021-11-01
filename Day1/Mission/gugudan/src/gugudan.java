import java.util.Scanner;

public class gugudan {
    public static void main(String[] args) {

        System.out.println("구구단");
        System.out.println("입력단과 끝단을 입력해 주세요");

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        for(int i = num1; i <= num2; i++){
            System.out.println(i + " 단");
            for(int j = 1; j <= 9; j++){
                System.out.println(i + " X " + j + " = " + i*j);
            }
            System.out.println("");
        }

    }
}
