import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cmd {

    private StringBuffer buffer;
    private Process process;
    private BufferedReader br;
    private StringBuffer readBuffer;

    private Path path = Paths.get("").toAbsolutePath();

    public void cd(String s){


    }


    public void pwd() {
        System.out.println(this.path);
    }

    public void cmd() {
        try {

        } catch (Exception e){

        }
    }

}
