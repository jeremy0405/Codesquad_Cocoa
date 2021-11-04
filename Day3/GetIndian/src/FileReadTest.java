import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileReadTest {

    public static void main(String[] args) {
        String[] ddd = new String[31];
        List<String> list = new ArrayList<>();
        try{
            list = Files.readAllLines(Path.of(
                "C:\\Users\\hsjan\\Desktop\\Codesquad_Cocoa\\Day3\\GetIndian\\src\\ddd.txt"), StandardCharsets.UTF_8);
        } catch(IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < list.size(); i++){
            ddd[i] = list.get(i).toString();
            System.out.println(ddd[i]);
        }

    }

}
