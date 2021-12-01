import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);

    public String[] userInput() {
        System.out.print("Cube> ");
        String userinput = sc.nextLine();
        String[] splitCommand = splitInput(userinput);
        String[] command = validateInput(splitCommand);
        return command;
    }

    private String[] validateInput(String[] command) {
        for (int i = 0; i < command.length; i++) {
            if (!command[i].equalsIgnoreCase("F") &&
                !command[i].equalsIgnoreCase("F'") &&
                !command[i].equalsIgnoreCase("F2") &&
                !command[i].equalsIgnoreCase("R") &&
                !command[i].equalsIgnoreCase("R'") &&
                !command[i].equalsIgnoreCase("R2") &&
                !command[i].equalsIgnoreCase("U") &&
                !command[i].equalsIgnoreCase("U'") &&
                !command[i].equalsIgnoreCase("U2") &&
                !command[i].equalsIgnoreCase("B") &&
                !command[i].equalsIgnoreCase("B'") &&
                !command[i].equalsIgnoreCase("B2") &&
                !command[i].equalsIgnoreCase("L") &&
                !command[i].equalsIgnoreCase("L'") &&
                !command[i].equalsIgnoreCase("L2") &&
                !command[i].equalsIgnoreCase("D") &&
                !command[i].equalsIgnoreCase("D'") &&
                !command[i].equalsIgnoreCase("D2") &&
                !command[i].equalsIgnoreCase("Q")
            ) {
                System.out.println("잘못된 입력값이 포함되어 있습니다. 다시 입력해주세요!");
                return userInput();
            }
        }
        return command;
    }

    private String[] splitInput(String userinput) {
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

    public void close() {
        sc.close();
    }

}
