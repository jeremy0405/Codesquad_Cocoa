package datemanager;

import java.util.Scanner;

public class RegisterUser {
    String name;

    public String getName() {
        Scanner sc = new Scanner(System.in);
        this.name = sc.next();
        return this.name;
    }

}
