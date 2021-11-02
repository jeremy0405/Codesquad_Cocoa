import java.io.*;

public class TestBuffer {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(i);
    }
}
