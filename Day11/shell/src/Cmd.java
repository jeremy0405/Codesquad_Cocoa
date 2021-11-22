import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Cmd {

    private Path path = Paths.get("").toAbsolutePath();

    public void cd(String s) {
        if (s.equals("..")) {
            path = path.getParent();
            System.out.println(path.toString());
        } else if (s.equals("~")) {
            path = path.getRoot();
            System.out.println(path.toString());
        } else {
            path = Paths.get(path.toString() + s);
            System.out.println(path);
        }

    }


    public void pwd() {
        System.out.println(this.path);
    }

    public void cmd(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.directory(new File(path.toString()));
            processBuilder.redirectErrorStream(true);
            ArrayList<String> commandlist = new ArrayList<>();
            commandlist.add("cmd");
            commandlist.add("/c");
            String[] comArr = command.split(" +");
            commandlist.addAll(Arrays.asList(comArr));
            processBuilder.command(commandlist);
            Process p = processBuilder.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            p.waitFor();

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
