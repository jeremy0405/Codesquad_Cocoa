public class printMap {

    Game game;

    printMap(Game game){
        this.game = game;
    }

    public void print(Game game) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%3s", game.map[i][j]);
            }
            System.out.println("");
        }
    }

}
