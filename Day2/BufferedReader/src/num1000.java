import java.io.*;

public class num1000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        br.close();
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        System.out.println(a+b);

    }

}
