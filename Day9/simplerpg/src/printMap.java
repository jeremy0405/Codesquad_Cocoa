public class printMap {

    public static void print(String[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%3s", map[i][j]);
            }
            System.out.println("");
        }
    }
}
