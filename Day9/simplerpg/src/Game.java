import java.util.Scanner;

public class Game {

    private final int Map_X = 5;
    private final int Map_Y = 5;
    private final int PLAYER_X = 2;
    private final int PLAYER_Y = 2;
    public String[][] map;

    private Player player;
    private Monster monster;
    private Mine mine;

    public void init() {
        createMap(Map_X, Map_Y);
        createValues();
        setMap();
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
        //TODO x, y를 랜덤하게 생성
        // 하지만 플레이어 위치, 몬스터 위치와 겹치면 안됨.
    }

    private void createMonster() {

        //TODO x, y를 랜덤하게 생성
        // 하지만 플레이어 위치와 겹치면 안됨.
        monster = new Monster(1, 1);

    }

    private void createPlayer() {
        String name = getUserName();
        player = new Player(name, PLAYER_X, PLAYER_Y);
    }

    private String getUserName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력해주세요! >>> ");
        String name = sc.nextLine();
        sc.close();
        return name;
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
