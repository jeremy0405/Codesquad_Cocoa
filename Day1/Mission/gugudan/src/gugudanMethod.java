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

    public static int[] getNums() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("시작 단과 끝 단을 입력하세요.");
        System.out.println("ex) 2");
        System.out.println("    5");

        int[] num = new int[2];
        num[0] = Integer.parseInt(br.readLine());
        num[1] = Integer.parseInt(br.readLine());

        br.close();
        return num;
    }

    public static void main(String[] args) throws IOException {
        int[] num = getNums();

        for (int i = num[0]; i <= num[1]; i++) {
            printGugudan(i);
        }
    }
}
