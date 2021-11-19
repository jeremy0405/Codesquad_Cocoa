import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);

    public String getInput(String s) {
        System.out.print("Jerry> ");
        System.out.print(s);
        return sc.nextLine();
    }

    public void close() {
        sc.close();
    }

}
