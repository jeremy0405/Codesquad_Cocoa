public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.init();

        printMap p = new printMap(game);
        p.print(game);


    }

}
