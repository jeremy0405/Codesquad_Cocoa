import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaRunCommand {

    public static void main(String[] args) {
        boolean isKeep = true;
        while (isKeep) {
            Process p;
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Jerry> ");
                String cmd = sc.nextLine();
                p = Runtime.getRuntime().exec("cmd /c" + cmd);
                if(cmd.equals("exit")){
                    isKeep = false;
                }
                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("입출력오류");
                e.printStackTrace();
            } catch (InterruptedException e) {
                System.out.println("Interrupted 오류");
                e.printStackTrace();
            }
        }
    }
}
