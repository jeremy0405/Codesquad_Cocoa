package householdaccounts.datamanager;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterUser {

    public static String[] nameandpassword = new String[2];
    public static ArrayList<String> User = new ArrayList<>();
    public static ArrayList<String> Password = new ArrayList<>();
    public static int cnt = 0;

    public static String[] getNameAndPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디를 입력하세요.");
        nameandpassword[0] = sc.next();
        System.out.println("비밀번호를 입력하세요");
        nameandpassword[1] = sc.next();
        sc.close();
        return nameandpassword;
    }

    public static void getUserAccount() {
        Scanner sc = new Scanner((System.in));

        System.out.println("회원가입 진행을 원하시면 Y를 이미 회원가입이 되어 있다면 N를 입력해주세요.");
        System.out.print("(Y/N) ");

        String isNewAccount = sc.nextLine();

        if (isNewAccount.equals("Y")) {
            String[] NP = new String[2];
            NP = getNameAndPassword();
            getID(NP, User);
            getPassword(NP, Password);
            System.out.println(User.get(0));
            System.out.println(Password.get(0));
            cnt++;
            return;
        }
        if (isNewAccount.equals("N")) {
            String[] NP = new String[2];
            NP = getNameAndPassword();
            while (logIn(NP[0], NP[1]) != -1) {
                System.out.println("로그인 성공 " + NP[0] + "님 환영합니다!");
            }
            return;
        }
    }

    private static void getPassword(String[] NP, ArrayList<String> password) {
        password.add(cnt, NP[1]);
    }

    private static void getID(String[] NP, ArrayList<String> user) {
        user.add(cnt, NP[0]);
    }

    public static int logIn(String ID, String Pw) {

        for (int i = 0; i < User.size(); i++) {
            if (User.get(i).equals(ID) && Password.get(i).equals(Pw)) {
                return i;
            }
        }
        return -1;
    }

}
