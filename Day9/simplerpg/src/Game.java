import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final int MAP_X = 5;
    private static final int MAP_Y = 5;
    private static final int PLAYER_X = 2;
    private static final int PLAYER_Y = 2;
    private String[][] map;

    private Player player;
    private Monster monster;
    private Mine mine;

    private final Random ran = new Random();

    public void getUser(){
        System.out.println("게임을 시작합니다.");
        System.out.print("이름을 입력해주세요 >>> ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s + "님 환영합니다!!");
        player = new Player(s);
    }

    public void init() {
        createMap(MAP_X, MAP_Y);
        createValues();
        setMap();
        PrintMap.print(map);
    }

    public void run() {

        boolean isRun = true;
        int score = 0;
        while (isRun) {
            System.out.print("움직일 방향을 입력해주세요.(w a s d) >>> ");
            movePlayerAndPirntMap();
            if (checkMonster(player.getX(), player.getY())) {
                score += 100;
                System.out.println("\n\n\n");
                System.out.println("SCORE : " + score);
                init();
            }
            isRun = checkMine(player.getX(), player.getY());
            if(!isRun) {
                System.out.println("FINAL SCORE : " + score);
            }
        }

    }

    private boolean checkMonster(int px, int py) {
        if (px == monster.getX() && py == monster.getY()) {
            System.out.println("몬스터를 잡았습니다. 다음 라운드를 진행합니다.");
            return true;
        }
        return false;
    }

    private void movePlayerAndPirntMap() {
        player.move(player.getX(), player.getY());
        initialMap(map);
        setMap();
        PrintMap.print(map);
    }

    private void initialMap(String[][] map) {
        for (int i = 0; i < MAP_X; i++) {
            for (int j = 0; j < MAP_Y; j++) {
                map[i][j] = "□";
            }
        }
    }

    private boolean checkMine(int px, int py) {

        if (px == mine.getX() && py == mine.getY()) {
            System.out.println("마인을 밟았습니다. 게임을 종료합니다.");
            return false;
        }
        return true;
    }


    private void createValues() {
        createPlayer();
        createMonster();
        createMine();
    }

    private void setMap() {
        map[player.getX()][player.getY()] = "P";
        map[monster.getX()][monster.getY()] = "M";
    }

    private void createMine() {

        int[] xy = getMineLocation();
        mine = new Mine(xy[0], xy[1]);
        System.out.println("Mine : " + xy[0] + " " + xy[1]);

    }

    private int[] getMineLocation() {
        int[] xy = new int[2];
        boolean isSame = true;
        while (isSame) {
            xy = getRandomLocation();
            if (xy[0] == PLAYER_X && xy[1] == PLAYER_Y) {
                isSame = true;
                continue;
            }
            if (xy[0] == monster.getX() && xy[1] == monster.getY()) {
                isSame = true;
                continue;
            }
            isSame = false;
        }
        return xy;
    }

    private void createMonster() {

        int[] xy = getMonsterLocation();
        monster = new Monster(xy[0], xy[1]);
        System.out.println("Monster : " + xy[0] + " " + xy[1]);

    }

    private int[] getMonsterLocation() {
        int[] xy = new int[2];
        boolean isSame = true;
        while (isSame) {
            xy = getRandomLocation();
            if (xy[0] == PLAYER_X && xy[1] == PLAYER_Y) {
                isSame = true;
                continue;
            }
            isSame = false;
        }
        return xy;
    }

    private int[] getRandomLocation() {

        int[] rxy = new int[2];
        rxy[0] = ran.nextInt(5);
        rxy[1] = ran.nextInt(5);
        return rxy;
    }

    private void createPlayer() {
        player.setX(PLAYER_X);
        player.setY(PLAYER_Y);
    }

    private void createMap(int w, int h) {
        map = new String[w][h];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                map[i][j] = "□";
            }
        }
    }

}
