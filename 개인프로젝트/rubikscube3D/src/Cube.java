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
        // initial timecheck
    }


}
