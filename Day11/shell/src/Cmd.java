import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cmd {

    private Path path = Paths.get("").toAbsolutePath();

    public void cd(String s) {

    }


    public void pwd() {
        System.out.println(this.path);
    }

    public void cmd(String command) {
        try {
            Process p = Runtime.getRuntime().exec("cmd /c " + command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            p.waitFor();

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
