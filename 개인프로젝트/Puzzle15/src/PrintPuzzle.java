public class PrintPuzzle {

    private static final int HEIGHT = 4;
    private static final int WIDTH = 4;
    private StringBuilder sb = new StringBuilder();

    public void print(String[][] map) {
        sb.append("=================\n");
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                sb.append(String.format("|%3s", map[i][j]));
            }
            sb.append("|\n=================\n");
        }

        System.out.println(sb.toString());
    }

}
