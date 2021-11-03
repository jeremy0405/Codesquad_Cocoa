import java.util.Random;
import java.util.Scanner;

public class RPG {

    public static String[][] getMap() {

        String[][] map = new String[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = "□";
            }
        }

        return map;
    }

    public static void printMap(String[][] map) {
        System.out.println("*********");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[] getMonsterLocation() {
        Random ran = new Random();
        int[] xy = new int[2];
        xy[0] = ran.nextInt(5);
        xy[1] = ran.nextInt(5);

        if (xy[0] == 2 && xy[1] == 2) {
            xy = getMonsterLocation();
        }
        return xy;
    }

    public static int[] getMineLocation(int[] MonsterLocation) {
        Random ran = new Random();
        int[] xy = new int[2];
        xy[0] = ran.nextInt(5);
        xy[1] = ran.nextInt(5);

        if (xy[0] == 2 && xy[1] == 2) {
            xy = getMineLocation(MonsterLocation);
        }

        if (xy[0] == MonsterLocation[0] && xy[1] == MonsterLocation[0]) {
            xy = getMineLocation(MonsterLocation);
        }

        return xy;
    }

    private static int[] MovePlayer(String[][] map, int x, int y) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();

        int[] xy = new int[2];

        if (a.equals("w")) {
            if (x - 1 < 0) {
                System.out.println("잘못된 값을 입력했습니다.");
                xy[0] = x;
                xy[1] = y;
                return xy;
            }
            map[x - 1][y] = map[x][y];
            map[x][y] = "□";
            xy[0] = x - 1;
            xy[1] = y;
            return xy;
        } else if (a.equals("s")) {
            if (x + 1 > 4) {
                System.out.println("잘못된 값을 입력했습니다.");
                xy[0] = x;
                xy[1] = y;
                return xy;
            }
            map[x + 1][y] = map[x][y];
            map[x][y] = "□";
            xy[0] = x + 1;
            xy[1] = y;
            return xy;
        } else if (a.equals("a")) {

            if (y - 1 < 0) {
                System.out.println("잘못된 값을 입력했습니다.");
                xy[0] = x;
                xy[1] = y;
                return xy;
            }

            map[x][y - 1] = map[x][y];
            map[x][y] = "□";
            xy[0] = x;
            xy[1] = y - 1;
            return xy;
        } else if (a.equals("d")) {

            if (y + 1 > 4) {
                System.out.println("잘못된 값을 입력했습니다.");
                xy[0] = x;
                xy[1] = y;
                return xy;
            }

            map[x][y + 1] = map[x][y];
            map[x][y] = "□";
            xy[0] = x;
            xy[1] = y + 1;

            return xy;
        } else {
            System.out.println("잘못된 값을 입력했습니다.");
            xy[0] = x;
            xy[1] = y;
            return xy;
        }

    }

    public static void main(String[] args) {

        String[][] map = getMap();

        int[] Player = new int[2];
        Player[0] = 2;
        Player[1] = 2;

        map[Player[0]][Player[1]] = "P";

        int[] MonsterLocation = getMonsterLocation();
        map[MonsterLocation[0]][MonsterLocation[1]] = "M";

        int[] MineLocation = getMineLocation(MonsterLocation);

        int score = 0;

        while (true) {

            printMap(map);

            Player = MovePlayer(map, Player[0], Player[1]);

            System.out.printf("Mine : %d, %d\n", MineLocation[0],
                MineLocation[1]);        // 테스트용 마인 위치 프린트
            System.out.printf("Monster : %d, %d\n", MonsterLocation[0],
                MonsterLocation[1]);  // 테스트용 몬스터 위치 프린트
            System.out.printf("Player :%d, %d\n", Player[0],
                Player[1]);                    // 테스트용 플레이어 위치 프린트

            if (Player[0] == MonsterLocation[0] && Player[1] == MonsterLocation[1]) {
                System.out.println("You catch the monster!!");
                score += 100;
                continue;
            }

            if (Player[0] == MineLocation[0] && Player[1] == MineLocation[1]) {
                System.out.println("You stepped on a mine");
                System.out.println("Game Over!!");
                break;
            }
        }

    }

}
