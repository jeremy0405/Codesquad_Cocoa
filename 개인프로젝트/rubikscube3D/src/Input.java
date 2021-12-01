import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);

    public String[] userInput() {
        String userinput = sc.nextLine();
        String[] command = validateInput(userinput);
        return command;
    }

    private String[] validateInput(String userinput) {
        List<String> commandlist = new LinkedList<>();
        for (int i = 0; i < userinput.length(); i++) {
            if (i != 0 && userinput.charAt(i) == '2' || userinput.charAt(i) == '\'') {
                int idx = commandlist.size() - 1;
                commandlist.set(idx, commandlist.get(idx) + userinput.charAt(i));
                continue;
            }
            commandlist.add(userinput.charAt(i) + "");
        }
        return commandlist.toArray(new String[0]);
    }

}
