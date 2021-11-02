import java.io.*;

public class num2444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - (i + 1); j++) {
                sb.append(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * (num - 1) - 2 * i - 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

