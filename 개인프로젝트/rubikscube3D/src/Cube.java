import java.util.Arrays;

public class Cube {

    private static final String[][][] Answer = {
        {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}}, // U
        {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}}, // L
        {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}}, // F
        {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}}, // R
        {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}}, // B
        {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}}  // D
    };

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
        //todo suffle();
        // initial timecheck -> 전역변수로 만든 값에 넣어줘야 할듯.
        callPrint();
    }

    public void run() {
        Input input = new Input();

        //todo 아래 구문을 무한반복
        // 정답과 일치하는지 비교하는 메서드 추가해야함.
        // 프린트하는 거 추가해야함.
        boolean isRun = true;
        while (isRun) {
            String[] commands = input.userInput();
            for (String command : commands) {
                System.out.println(command);
                turnCube(command);
                callPrint();
                // todo 횟수 카운트하는 int 여기서 증가
                isRun = checkAnswer();
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

    private void turnR() {
        PlaneR = clockwiseTurn(PlaneR);
        turnAroundR();
    }

    private void turnL() {
        PlaneL = clockwiseTurn(PlaneL);
        turnAroundL();
    }

    private void turnB() {
        PlaneB = clockwiseTurn(PlaneB);
        turnAroundB();
    }

    private void turnF() {
        PlaneF = clockwiseTurn(PlaneF);
        turnAroundF();
    }

    private void dipose() {
        System.out.println("프로그램을 종료합니다.");
        //todo 횟수, 시간 출력
        System.exit(0);
    }

    private void turnD() {
        PlaneD = clockwiseTurn(PlaneD);
        turnAroundD();
    }

    private void turnU() {
        PlaneU = clockwiseTurn(PlaneU);
        turnAroundU();
    }

    public String[][] clockwiseTurn(String[][] plane) {
        String[][] afterTurn = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                afterTurn[j][2 - i] = plane[i][j];
            }
        }
        return afterTurn;
    }

    private void turnAroundU() { // L F R B
        String[] tmp = new String[3];
        System.arraycopy(PlaneL[0], 0, tmp, 0, 3);
        System.arraycopy(PlaneF[0], 0, PlaneL[0], 0, 3);
        System.arraycopy(PlaneR[0], 0, PlaneF[0], 0, 3);
        System.arraycopy(PlaneB[0], 0, PlaneR[0], 0, 3);
        System.arraycopy(tmp, 0, PlaneB[0], 0, 3);
    }

    private void turnAroundD() {
        String[] tmp = new String[3];
        System.arraycopy(PlaneB[2], 0, tmp, 0, 3);
        System.arraycopy(PlaneR[2], 0, PlaneB[2], 0, 3);
        System.arraycopy(PlaneF[2], 0, PlaneR[2], 0, 3);
        System.arraycopy(PlaneL[2], 0, PlaneF[2], 0, 3);
        System.arraycopy(tmp, 0, PlaneL[2], 0, 3);
    }

    private void turnAroundF() {
        PlaneL = clockwiseTurn(PlaneL);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneR = clockwiseTurn(PlaneR);
        PlaneR = clockwiseTurn(PlaneR);
        PlaneR = clockwiseTurn(PlaneR);
        String[] tmp = new String[3];
        System.arraycopy(PlaneR[2], 0, tmp, 0, 3);
        System.arraycopy(PlaneU[2], 0, PlaneR[2], 0, 3);
        System.arraycopy(PlaneL[2], 0, PlaneU[2], 0, 3);
        System.arraycopy(PlaneD[2], 0, PlaneL[2], 0, 3);
        System.arraycopy(tmp, 0, PlaneD[2], 0, 3);
        PlaneL = clockwiseTurn(PlaneL);
        PlaneL = clockwiseTurn(PlaneL);
        PlaneL = clockwiseTurn(PlaneL);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneR = clockwiseTurn(PlaneR);
    }

    private void turnAroundB() {
        PlaneR = clockwiseTurn(PlaneR);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneL = clockwiseTurn(PlaneL);
        PlaneL = clockwiseTurn(PlaneL);
        PlaneL = clockwiseTurn(PlaneL);
        String[] tmp = new String[3];
        System.arraycopy(PlaneD[2], 0, tmp, 0, 3);
        System.arraycopy(PlaneL[2], 0, PlaneD[2], 0, 3);
        System.arraycopy(PlaneU[2], 0, PlaneL[2], 0, 3);
        System.arraycopy(PlaneR[2], 0, PlaneU[2], 0, 3);
        System.arraycopy(tmp, 0, PlaneR[2], 0, 3);
        PlaneL = clockwiseTurn(PlaneL);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneR = clockwiseTurn(PlaneR);
        PlaneR = clockwiseTurn(PlaneR);
        PlaneR = clockwiseTurn(PlaneR);
    }

    private void turnAroundL() {
        PlaneU = clockwiseTurn(PlaneU);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneF = clockwiseTurn(PlaneF);
        PlaneF = clockwiseTurn(PlaneF);
        PlaneF = clockwiseTurn(PlaneF);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneB = clockwiseTurn(PlaneB);
        String[] tmp = new String[3];
        System.arraycopy(PlaneU[2], 0, tmp, 0, 3);
        System.arraycopy(PlaneB[2], 0, PlaneU[2], 0, 3);
        System.arraycopy(PlaneD[2], 0, PlaneB[2], 0, 3);
        System.arraycopy(PlaneF[2], 0, PlaneD[2], 0, 3);
        System.arraycopy(tmp, 0, PlaneF[2], 0, 3);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneF = clockwiseTurn(PlaneF);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneB = clockwiseTurn(PlaneB);
        PlaneB = clockwiseTurn(PlaneB);
        PlaneB = clockwiseTurn(PlaneB);
    }

    private void turnAroundR() {
        PlaneU = clockwiseTurn(PlaneU);
        PlaneF = clockwiseTurn(PlaneF);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneB = clockwiseTurn(PlaneB);
        PlaneB = clockwiseTurn(PlaneB);
        PlaneB = clockwiseTurn(PlaneB);
        String[] tmp = new String[3];
        System.arraycopy(PlaneU[2], 0, tmp, 0, 3);
        System.arraycopy(PlaneF[2], 0, PlaneU[2], 0, 3);
        System.arraycopy(PlaneD[2], 0, PlaneF[2], 0, 3);
        System.arraycopy(PlaneB[2], 0, PlaneD[2], 0, 3);
        System.arraycopy(tmp, 0, PlaneB[2], 0, 3);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneU = clockwiseTurn(PlaneU);
        PlaneF = clockwiseTurn(PlaneF);
        PlaneF = clockwiseTurn(PlaneF);
        PlaneF = clockwiseTurn(PlaneF);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneD = clockwiseTurn(PlaneD);
        PlaneB = clockwiseTurn(PlaneB);
    }

}
