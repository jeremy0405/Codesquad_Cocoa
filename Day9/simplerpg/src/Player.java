import java.io.IOException;
import java.util.Scanner;

public class Player {

    private int x;
    private int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x, int y) {
        // TODO
        //  x 또는 y 가 0 또는 4가 입력되어 왔을 때 움직일 수 없게 해야 함.
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        switch(s){
            case "w" :
                if(x <= 0){
                    System.out.println("그 방향으로 움직일 수 없습니다.");
                    break;
                }
                this.x = x - 1;
                break;
            case "a" :
                if(y <= 0){
                    System.out.println("그 방향으로 움직일 수 없습니다.");
                    break;
                }
                this.y = y - 1;
                break;
            case "s" :
                if(x >= 4){
                    System.out.println("그 방향으로 움직일 수 없습니다.");
                    break;
                }
                this.x = x + 1;
                break;
            case "d" :
                if(y >= 4){
                    System.out.println("그 방향으로 움직일 수 없습니다.");
                    break;
                }
                this.y = y + 1;
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
        System.out.println("Player : " + this.x + " " + this.y);
    }
}
