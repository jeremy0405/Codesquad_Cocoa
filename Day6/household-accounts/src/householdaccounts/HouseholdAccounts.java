package householdaccounts;

import householdaccounts.datamanager.RegisterUser;
import householdaccounts.datamanager.InputData;
import java.util.ArrayList;

public class HouseholdAccounts {

    public static ArrayList<String> User = new ArrayList<>();
    public static ArrayList<String> Password = new ArrayList<>();
    public static int cnt = 0;

    public static void getUserAccount() {
        String[] nameandpassword = new String[2];
        nameandpassword = RegisterUser.getNameAndPassword();
        User.add(cnt, nameandpassword[0]);
        Password.add(cnt, nameandpassword[1]);
        cnt++;
    }

    public static void main(String[] args) {
        boolean getUser = true;
        if(getUser){
            getUserAccount();
            getUser = false;
        }

        getUser = true;
        if(getUser){
            getUserAccount();
            getUser = false;
        }

    }

}
