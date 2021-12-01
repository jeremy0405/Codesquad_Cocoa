public class Cube {
    private static final String[][][] Answer = {
        {{"B","B","B"}, {"B","B","B"}, {"B","B","B"}}, // U
        {{"W","W","W"}, {"W","W","W"}, {"W","W","W"}}, // L
        {{"O","O","O"}, {"O","O","O"}, {"O","O","O"}}, // F
        {{"G","G","G"}, {"G","G","G"}, {"G","G","G"}}, // R
        {{"Y","Y","Y"}, {"Y","Y","Y"}, {"Y","Y","Y"}}, // B
        {{"R","R","R"}, {"R","R","R"}, {"R","R","R"}}  // D
    };

    private String[][] PlaneU = {{"B","B","B"}, {"B","B","B"}, {"B","B","B"}};
    private String[][] PlaneL = {{"W","W","W"}, {"W","W","W"}, {"W","W","W"}};
    private String[][] PlaneF = {{"O","O","O"}, {"O","O","O"}, {"O","O","O"}};
    private String[][] PlaneR = {{"G","G","G"}, {"G","G","G"}, {"G","G","G"}};
    private String[][] PlaneB = {{"Y","Y","Y"}, {"Y","Y","Y"}, {"Y","Y","Y"}};
    private String[][] PlaneD = {{"R","R","R"}, {"R","R","R"}, {"R","R","R"}};

    Cube() {
        init();
    }

    private void init() {
        //todo suffle();
        // initial timecheck -> 전역변수로 만든 값에 넣어줘야 할듯.
        // 셔플 된 큐브 출력
    }

    public void run() {
        Input input = new Input();
        String[] command = input.userInput();
        for (var a: command
        ) {
            System.out.println(a);
        }
    }


}
