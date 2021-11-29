import java.util.Arrays;

public class PuzzleControler {

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
    private Input UserInput = new Input();

    private PrintPuzzle printPuzzle = new PrintPuzzle();

    public void init() {
        System.out.println("15퍼즐 게임을 시작합니다");
        //TODO 랜덤으로 섞기 해야함.
    }

    public void run() {
        //TODO 무한반복 정답이면 break;
        // 사용자 입력에 따른 move 들어있어야 함
        // move 후에 항상 print 있어야 함

        while(true) {
            String ui = UserInput.input();
            move(ui);
            printPuzzle.print(answer);



            if(Arrays.deepEquals(answer, solution)){
                System.out.println("축하합니다! 퍼즐을 완성했습니다");
                break;
            }

            if(ui.equals("q")){
                break;
            }
        }

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
        }

    }

    private void movedown() {
        // 빈칸이 아래로
        int x = position.getX();
        int y = position.getY();
        this.answer[x][y] = this.answer[x + 1][y];
        this.answer[x + 1][y] = "";
        position.setX(x + 1);
    }

    private void moveright() {
        // 빈칸이 오른쪽으로
        int x = position.getX();
        int y = position.getY();
        this.answer[x][y] = this.answer[x][y + 1];
        this.answer[x][y + 1] = "";
        position.setY(y + 1);
    }

    private void moveup() {
        int x = position.getX();
        int y = position.getY();
        this.answer[x][y] = this.answer[x - 1][y];
        this.answer[x - 1][y] = "";
        position.setX(x - 1);
    }

    private void moveleft() {
        int x = position.getX();
        int y = position.getY();
        this.answer[x][y] = this.answer[x][y - 1];
        this.answer[x][y - 1] = "";
        position.setY(y - 1);

    }


}
