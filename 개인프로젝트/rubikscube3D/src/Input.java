import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);

    public String[] userInput() {
        System.out.print("Cube> ");
        String userinput = sc.nextLine().toUpperCase();
        String[] splitCommand = splitInput(userinput);
        String[] commands = validateInput(splitCommand);
        return commands;
    }

    private String[] validateInput(String[] command) {
        for (int i = 0; i < command.length; i++) {
            if (!command[i].equals("F") &&
                !command[i].equals("F'") &&
                !command[i].equals("F2") &&
                !command[i].equals("R") &&
                !command[i].equals("R'") &&
                !command[i].equals("R2") &&
                !command[i].equals("U") &&
                !command[i].equals("U'") &&
                !command[i].equals("U2") &&
                !command[i].equals("B") &&
                !command[i].equals("B'") &&
                !command[i].equals("B2") &&
                !command[i].equals("L") &&
                !command[i].equals("L'") &&
                !command[i].equals("L2") &&
                !command[i].equals("D") &&
                !command[i].equals("D'") &&
                !command[i].equals("D2") &&
                !command[i].equals("Q")
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
