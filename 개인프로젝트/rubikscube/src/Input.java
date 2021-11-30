import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);

    public String[] input() {
        String[] userInput;
        userInput = receiveInput().toArray(new String[0]);
        return userInput;
    }

    private List<String> receiveInput() {
        System.out.print("CUBE> ");
        String input = sc.nextLine();
        List<String> userInput = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '\'' && i != 0){
                userInput.set(userInput.size() - 1, userInput.get(userInput.size() - 1) + "'");
            } else {
                userInput.add(input.charAt(i) + "");
            }
        }

        userInput = validateInput(userInput);

        return userInput;
    }

    private List<String> validateInput(List<String> userInput) {

        boolean valInput = false; // 값이 올바르면 참 값이 이상하면 거짓

        for (String a : userInput) {
            valInput = a.equalsIgnoreCase("U") ||
                a.equalsIgnoreCase("U'") ||
                a.equalsIgnoreCase("R") ||
                a.equalsIgnoreCase("R'") ||
                a.equalsIgnoreCase("L") ||
                a.equalsIgnoreCase("L'") ||
                a.equalsIgnoreCase("B") ||
                a.equalsIgnoreCase("B'") ||
                a.equalsIgnoreCase("Q");
            if(!valInput){
                break;
            }
        }

        if(valInput) {
            return userInput;
        } else {
            return receiveInput();
        }

    }

    public void close() {
        sc.close();
    }

}
