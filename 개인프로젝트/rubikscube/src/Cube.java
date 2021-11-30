public class Cube {

    private String[][] plane = {{"R", "R", "W"},
        {"G", "C", "W"},
        {"G", "B", "B"}};
    private boolean isRun = true;

    public void run() {

        Input input = new Input();
        PrintCube.print(plane);

        while(isRun) {
            String[] userInput = input.input(); // userInput에 값이 들어감.
            suffle(userInput);
        }
        System.out.println("시스템을 종료합니다.");
        input.close();
    }

    private void suffle(String[] userInput) {
        for (String input : userInput) {
            valCommandToCube(input);
        }
    }

    private void valCommandToCube(String input) {
        int x = 0; // up down
        int y = 0; // left right
        int z = 0;
        String UCinput = input.toUpperCase();
        switch (UCinput) {
            case "U":
                x = 1; y = -1; z = 1;
                break;
            case "U'":
                x = 1; y = 1; z = 1;
                break;
            case "B":
                x = -1; y = 1; z = 1;
                break;
            case "B'":
                x = -1; y = -1; z = 1;
                break;
            case "R":
                x = 1; y = -1; z = -1;
                break;
            case "R'":
                x = 1; y = 1; z = -1;
                break;
            case "L":
                x = -1; y = 1; z = -1;
                break;
            case "L'":
                x = -1; y = -1; z = -1;
                break;
            case "Q":
                isRun = false;
                return;
        }
        if (z < 0) {
            turnUpDownCube(x, y);
        } else {
            turnLeftRightCube(x, y);
        }
        System.out.println(UCinput);
        PrintCube.print(this.plane);
    }

    private void turnLeftRightCube(int x, int y) {

        String tmp = this.plane[1 - x][1 + y];
        this.plane[1 - x][1 + y] = this.plane[1 - x][1];
        this.plane[1 - x][1] = this.plane[1 - x][1 - y];
        this.plane[1 - x][1 - y] = tmp;

    }

    private void turnUpDownCube(int x, int y) {

        String tmp = this.plane[1 + y][1 + x];
        this.plane[1 + y][1 + x] = this.plane[1][1 + x];
        this.plane[1][1 + x] = this.plane[1 - y][1 + x];
        this.plane[1 - y][1 + x] = tmp;

    }


}
