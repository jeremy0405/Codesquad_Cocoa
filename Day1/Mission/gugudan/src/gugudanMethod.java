import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gugudanMethod {

    public static void printGugudan(int num) {

        System.out.println(num + " 단");

        for (int j = 1; j < 10; j++) {
            System.out.println(num + " X " + j + " = " + num * j);
        }

        System.out.println("");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        br.close();

        for (int i = num1; i <= num2; i++) {
            printGugudan(i);
        }
    }
}
