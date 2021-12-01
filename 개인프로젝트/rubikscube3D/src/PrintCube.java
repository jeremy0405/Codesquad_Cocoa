public class PrintCube {

    public static void print(String[][] U, String[][] L, String[][] F, String[][] R, String[][] B,
        String[][] D) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        printUPDOWN(U, sb);
        sb.append("\n");
        printLEFTTOBACK(L, F, R, B, sb);
        sb.append("\n");
        printUPDOWN(D, sb);
        System.out.println(sb.toString());
    }

    private static void printLEFTTOBACK(String[][] l, String[][] f, String[][] r, String[][] b,
        StringBuilder sb) {
        for (int i = 0; i < 3; i++) {
            sb.append(
                String.format("%2s%2s%2s%4s%2s%2s%4s%2s%2s%4s%2s%2s%n", l[i][0], l[i][1], l[i][2],
                    f[i][0], f[i][1], f[i][2], r[i][0], r[i][1], r[i][2],
                    b[i][0], b[i][1], b[i][2]));
        }
    }

    private static void printUPDOWN(String[][] ud, StringBuilder sb) {
        for (int i = 0; i < 3; i++) {
            sb.append(String.format("%10s", ud[i][0]));
            for (int j = 1; j < 3; j++) {
                sb.append(" ");
                sb.append(ud[i][j]);
            }
            sb.append("\n");
        }
    }

}
