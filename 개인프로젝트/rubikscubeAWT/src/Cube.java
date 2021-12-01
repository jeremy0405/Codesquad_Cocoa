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

    private String[][] PlaneU = {{"B", "B", "B"}, {"B", "B", "B"}, {"B", "B", "B"}};
    private String[][] PlaneL = {{"W", "W", "W"}, {"W", "W", "W"}, {"W", "W", "W"}};
    private String[][] PlaneF = {{"O", "O", "O"}, {"O", "O", "O"}, {"O", "O", "O"}};
    private String[][] PlaneR = {{"G", "G", "G"}, {"G", "G", "G"}, {"G", "G", "G"}};
    private String[][] PlaneB = {{"Y", "Y", "Y"}, {"Y", "Y", "Y"}, {"Y", "Y", "Y"}};
    private String[][] PlaneD = {{"R", "R", "R"}, {"R", "R", "R"}, {"R", "R", "R"}};

    public String[][] getPlaneU() {
        return PlaneU;
    }

    public String[][] getPlaneL() {
        return PlaneL;
    }

    public String[][] getPlaneF() {
        return PlaneF;
    }

    public String[][] getPlaneR() {
        return PlaneR;
    }

    public String[][] getPlaneB() {
        return PlaneB;
    }

    public String[][] getPlaneD() {
        return PlaneD;
    }

    public Cube() {
        init();
    }

    private void init() {
//        suffle();
        turnCube("U");
    }

    private void suffle() {
        Random ran = new Random();
        int suffleNum = 100;
        for (int i = 0; i < suffleNum; i++) {
            int random = ran.nextInt(6);
            switch (random) {
                case 0:
                    turnCube("U");
                    break;
                case 1:
                    turnCube("L");
                    break;
                case 2:
                    turnCube("F");
                    break;
                case 3:
                    turnCube("R");
                    break;
                case 4:
                    turnCube("B");
                    break;
                case 5:
                    turnCube("D");
                    break;
            }
        }
    }

    public boolean checkAnswer() {
        return (Arrays.deepEquals(PlaneU, Answer[0]) && Arrays.deepEquals(PlaneL, Answer[1])
            && Arrays.deepEquals(PlaneF, Answer[2]) && Arrays.deepEquals(PlaneR, Answer[3])
            && Arrays.deepEquals(PlaneB, Answer[4]) && Arrays.deepEquals(PlaneD, Answer[5]));
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

    private void turnAroundU() {
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

