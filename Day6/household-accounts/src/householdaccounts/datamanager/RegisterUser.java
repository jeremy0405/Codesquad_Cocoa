package householdaccounts.datamanager;

import java.util.Scanner;

public class RegisterUser {
    static String[] nameandpassword = new String[2];

    public static String[] getNameAndPassword() {
        Scanner sc = new Scanner(System.in);
        nameandpassword[0] = sc.next();
        nameandpassword[1] = sc.next();
        sc.close();
        return nameandpassword;
    }


}
