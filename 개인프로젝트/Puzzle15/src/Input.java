import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);

    public String input() {
        System.out.print("w a s d 중 하나를 입력해주세요 >> ");
        String input = sc.nextLine();

        if (!input.equalsIgnoreCase("w") && !input.equalsIgnoreCase("a")
            && !input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("d")) {
            System.out.println("잘못된 값을 입력했습니다. w a s d 중에 하나를 입력해주세요.");
            input = input();
        }
        return input;
    }

}
