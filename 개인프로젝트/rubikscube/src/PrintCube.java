public class PrintCube {

    public static void print(String[][] plane) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        for (int i = 0; i < plane.length; i++) {
            for (int j = 0; j < plane[i].length; j++) {
                sb.append(String.format("%2s", plane[i][j]));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
