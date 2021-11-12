import java.util.Scanner;

public class Player {

    private int x;
    private int y;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int x, int y) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String warning = "그 방향으로 움직일 수 없습니다.";
        switch(s){
            case "w" :
                if(x <= 0){
                    System.out.println(warning);
                    break;
                }
                this.x = x - 1;
                break;
            case "a" :
                if(y <= 0){
                    System.out.println(warning);
                    break;
                }
                this.y = y - 1;
                break;
            case "s" :
                if(x >= 4){
                    System.out.println(warning);
                    break;
                }
                this.x = x + 1;
                break;
            case "d" :
                if(y >= 4){
                    System.out.println(warning);
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
