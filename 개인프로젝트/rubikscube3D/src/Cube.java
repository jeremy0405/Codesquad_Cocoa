import java.util.Arrays;
import java.util.Random;

public class Cube {

    private static final String[][][] Answer = {
        {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}}, // U
        {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}}, // L
        {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}}, // F
        {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}}, // R
        {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}}, // B
        {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}}  // D
    };

    private int count = 0;
    private long start;

    private String[][] PlaneU = {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}};
    private String[][] PlaneL = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
    private String[][] PlaneF = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
    private String[][] PlaneR = {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}};
    private String[][] PlaneB = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};
    private String[][] PlaneD = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};

    Cube() {
        init();
    }

    private void init() {
        start = System.currentTimeMillis();
//        suffle();
        turnU();
        callPrint();
    }

    private void suffle() {
        Random ran = new Random();
        int suffleNum = 100;
        for (int i = 0; i < suffleNum; i++) {
            int random = ran.nextInt(6);
            switch (random) {
                case 0:
                    turnU();
                    break;
                case 1:
                    turnD();
                    break;
                case 2:
                    turnF();
                    break;
                case 3:
                    turnB();
                    break;
                case 4:
                    turnL();
                    break;
                case 5:
                    turnR();
                    break;
            }
        }
    }

    public void run() {
        Input input = new Input();

        boolean isRun = true;
        while (isRun) {
            String[] commands = input.userInput();
            for (String command : commands) {
                System.out.println(command);
                turnCube(command);
                callPrint();
                count++;
                isRun = checkAnswer();
                if (!isRun) {
                    System.out.println("정답입니다!");
                    dipose();
                }

            }
        }

    }

    private boolean checkAnswer() {
        return !(Arrays.deepEquals(PlaneU, Answer[0]) && Arrays.deepEquals(PlaneL, Answer[1])
            && Arrays.deepEquals(PlaneF, Answer[2]) && Arrays.deepEquals(PlaneR, Answer[3])
            && Arrays.deepEquals(PlaneB, Answer[4]) && Arrays.deepEquals(PlaneD, Answer[5]));
    }

    private void callPrint() {
        PrintCube.print(PlaneU, PlaneL, PlaneF, PlaneR, PlaneB, PlaneD);
    }

    public void turnCube(String command) {
        switch (command) {
            case "U":
                turnU();
                break;
            case "U2":
                turnU();
                turnU();
                break;
            case "U'":
                turnU();
                turnU();
                turnU();
                break;
            case "L":
                turnL();
                break;
            case "L2":
                turnL();
                turnL();
                break;
            case "L'":
                turnL();
                turnL();
                turnL();
                break;
            case "F":
                turnF();
                break;
            case "F2":
                turnF();
                turnF();
                break;
            case "F'":
                turnF();
                turnF();
                turnF();
                break;
            case "R":
                turnR();
                break;
            case "R2":
                turnR();
                turnR();
                break;
            case "R'":
                turnR();
                turnR();
                turnR();
                break;
            case "B":
                turnB();
                break;
            case "B2":
                turnB();
                turnB();
                break;
            case "B'":
                turnB();
                turnB();
                turnB();
                break;
            case "D":
                turnD();
                break;
            case "D2":
                turnD();
                turnD();
                break;
            case "D'":
                turnD();
                turnD();
                turnD();
                break;
            case "Q":
                dipose();
                break;
        }
    }

    private void dipose() {
        System.out.println("프로그램을 종료합니다.");
        long time = System.currentTimeMillis() - start;
        System.out.println("경과 시간(s) : " + time / 1000 + "sec");
        System.out.println("입력한 횟수 :" + count + "회");
        System.exit(0);
    }

    private void turnR() {
        clockwiseTurn(PlaneR);
        turnAroundR();
    }

    private void turnL() {
        clockwiseTurn(PlaneL);
        turnAroundL();
    }

    private void turnB() {
        clockwiseTurn(PlaneB);
        turnAroundB();
    }

    private void turnF() {
        clockwiseTurn(PlaneF);
        turnAroundF();
    }

    private void turnD() {
        clockwiseTurn(PlaneD);
        turnAroundD();
    }

    private void turnU() {
        clockwiseTurn(PlaneU);
        turnAroundU();
    }

    public void clockwiseTurn(String[][] plane) {
        String[][] tmp = new String[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(plane[i], 0, tmp[i], 0, 3);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plane[j][2 - i] = tmp[i][j];
            }
        }
    }

    private void repeatClockwiseTurn(int u, int d, int f, int b, int l, int r) {
        for (int i = 0; i < u; i++) {
            clockwiseTurn(PlaneU);
        }
        for (int i = 0; i < d; i++) {
            clockwiseTurn(PlaneD);
        }
        for (int i = 0; i < f; i++) {
            clockwiseTurn(PlaneF);
        }
        for (int i = 0; i < b; i++) {
            clockwiseTurn(PlaneB);
        }
        for (int i = 0; i < l; i++) {
            clockwiseTurn(PlaneL);
        }
        for (int i = 0; i < r; i++) {
            clockwiseTurn(PlaneR);
        }
    }

    private void turnAround(String[][] P1, String[][] P2, String[][] P3, String[][] P4) {
        String[] tmp = new String[3];
        System.arraycopy(P1[2], 0, tmp, 0, 3);
        System.arraycopy(P2[2], 0, P1[2], 0, 3);
        System.arraycopy(P3[2], 0, P2[2], 0, 3);
        System.arraycopy(P4[2], 0, P3[2], 0, 3);
        System.arraycopy(tmp, 0, P4[2], 0, 3);
    }

    private void turnAroundU() {
        repeatClockwiseTurn(0, 0, 2, 2, 2, 2);
        turnAround(PlaneL, PlaneF, PlaneR, PlaneB);
        repeatClockwiseTurn(0, 0, 2, 2, 2, 2);
    }

    private void turnAroundD() {
        turnAround(PlaneB, PlaneR, PlaneF, PlaneL);
    }

    private void turnAroundF() {
        repeatClockwiseTurn(0, 2, 0, 0, 1, 3);
        turnAround(PlaneR, PlaneU, PlaneL, PlaneD);
        repeatClockwiseTurn(0, 2, 0, 0, 3, 1);
    }

    private void turnAroundB() {
        repeatClockwiseTurn(2, 0, 0, 0, 3, 1);
        turnAround(PlaneD, PlaneL, PlaneU, PlaneR);
        repeatClockwiseTurn(2, 0, 0, 0, 1, 3);
    }

    private void turnAroundL() {
        repeatClockwiseTurn(3, 3, 3, 1, 0, 0);
        turnAround(PlaneU, PlaneB, PlaneD, PlaneF);
        repeatClockwiseTurn(1, 1, 1, 3, 0, 0);
    }

    private void turnAroundR() {
        repeatClockwiseTurn(1, 1, 1, 3, 0, 0);
        turnAround(PlaneU, PlaneF, PlaneD, PlaneB);
        repeatClockwiseTurn(3, 3, 3, 1, 0, 0);
    }

}
