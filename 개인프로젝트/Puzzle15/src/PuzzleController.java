import java.util.Arrays;
import java.util.Random;

public class PuzzleController {

    private static final String[][] solution = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", ""}
    };
    private String[][] answer = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", ""}
    };

    // 빈칸 위치 x, y 좌표 가지고 있는 클래스
    private Position position = new Position();
    private Input userInput = new Input();

    private PrintPuzzle printPuzzle = new PrintPuzzle();

    public void init() {
        System.out.println("15퍼즐 게임을 시작합니다");
        System.out.println("w a s d 를 눌러 15퍼즐을 완성하세요!");
        suffle();
    }

    private void suffle() {
        Random ran = new Random();
        int suffleNum = 300;
        for (int i = 0; i < suffleNum; i++) {
            move(matchNum(ran.nextInt(4)));
        }
    }

    private String matchNum(int num) {
        switch (num) {
            case 0:
                return "w";
            case 1:
                return "a";
            case 2:
                return "s";
            case 3:
                return "d";
            default:
                return "q";
        }
    }

    public void run() {

        printPuzzle.print(answer);

        while (true) {
            String ui = userInput.input();
            move(ui);
            if (ui.equals("q")) {
                System.out.println("게임을 종료합니다.");
                break;
            }

            printPuzzle.print(answer);
            if (Arrays.deepEquals(answer, solution)) {
                System.out.println("축하합니다! 퍼즐을 완성했습니다");
                break;
            }

        }

        userInput.close();

    }

    public void move(String input) {

        switch (input) {
            case "w":
                movedown();
                break;
            case "a":
                moveright();
                break;
            case "s":
                moveup();
                break;
            case "d":
                moveleft();
                break;
            default:
                break;
        }

    }

    private void movedown() {
        // 빈칸이 아래로
        int x = position.getX();
        int y = position.getY();
        if (x >= 3){
            return;
        }
        this.answer[x][y] = this.answer[x + 1][y];
        this.answer[x + 1][y] = "";
        position.setX(x + 1);
    }

    private void moveright() {
        // 빈칸이 오른쪽으로
        int x = position.getX();
        int y = position.getY();
        if (y >= 3){
            return;
        }
        this.answer[x][y] = this.answer[x][y + 1];
        this.answer[x][y + 1] = "";
        position.setY(y + 1);
    }

    private void moveup() {
        int x = position.getX();
        int y = position.getY();
        if (x <= 0){
            return;
        }
        this.answer[x][y] = this.answer[x - 1][y];
        this.answer[x - 1][y] = "";
        position.setX(x - 1);
    }

    private void moveleft() {
        int x = position.getX();
        int y = position.getY();
        if (y <= 0){
            return;
        }
        this.answer[x][y] = this.answer[x][y - 1];
        this.answer[x][y - 1] = "";
        position.setY(y - 1);

    }


}
