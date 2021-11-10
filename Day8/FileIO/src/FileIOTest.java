import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {

    public static void main(String[] args) {

        fileRead();

//        fileWrite();


    }

    private static void fileRead() {
        try (
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
        ) {
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                System.out.println(readLine);
                String[] s = readLine.split(" ");
                for(int i = 0; i < s.length; i++){
                    System.out.printf("%5s", s[i]);
                }
                // readLine 가공해야함.....
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void fileWrite() {

        try {
            FileWriter fw = new FileWriter("data.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.append("0").append(" ").append("10").append(" ").append("20").append(" ").append("0").append(" ").append("적요").append(" ").append("수입").append(" ").append("지출").append(" ").append("현금");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
