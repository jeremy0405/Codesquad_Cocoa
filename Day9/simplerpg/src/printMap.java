public class printMap {

    public static void print(String[][] map) {
        System.out.println("");
        System.out.println("=================");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    System.out.printf("|%2s", map[i][j]);
                } else if (j == 4) {
                    System.out.printf("%3s |", map[i][j]);
                } else {
                    System.out.printf("%3s", map[i][j]);
                }
            }
            System.out.println("");
        }
        System.out.println("=================");
        System.out.println("");
    }
}
