import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> UserID = new ArrayList<>();
    public static ArrayList<String> UserPassword = new ArrayList<>();
    public static String[][][][] arr = new String[2][12][31][5];
    public static int[][][][][] arrMoney = new int[2][12][31][5][2];

    public static int idx = 0;
    public static int Useridx;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean workHouseholdAccount = true;
        while (workHouseholdAccount) {
            workHouseholdAccount = getUser();
        }

        System.out.println("======================================");
        System.out.println(UserID.get(Useridx) + "님 환영합니다!!");

        boolean keepWork = true;
        while (keepWork) {
            keepWork = chooseFunction();
        }

    }

    private static boolean chooseFunction() {
        System.out.println("데이터 입력 : I");
        System.out.println("데이터 삭제 : D");
        System.out.println("데이터 수정 : R");
        System.out.println("해당 월의 지출 내역 확인 : P");
        System.out.println("다른 아이디로 로그인 : A");
        System.out.println("종료 : Q");
        String choose = sc.nextLine();

        switch (choose) {
            case "I":
                getData();
                break;
            case "D":
                deleteData();
                break;
            case "R":
                reviseData();
                break;
            case "P":
                printData();
                break;
            case "A":
                // 구현 실패.. 메인 문 자체를 while 안에 넣어서 boolean으로 하는 방법 말고는 생각 안남.
                // 위 방법대로 시도했지만 결과가 좋지 않음.
                // 인스턴스를 생성해서 각자 고유한 arr과 arrMoney를 갖도록 해야지 각자의 가계부 생성 가능.
                break;
            case "Q":
                System.out.println("시스템을 종료합니다.");
                return false;
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
                System.out.println("==================================");
                return chooseFunction();
        }
        return true;
    }

    private static void reviseData() {
        System.out.println("데이터를 수정합니다.");
        System.out.println("수정하고 싶은 데이터의 년, 월, 일을 입력하세요. ex) 2021 11 01");
        int Ryear = sc.nextInt();
        int Rmonth = sc.nextInt();
        int Rday = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 5; i++) {
            if (arr[Ryear - 2021][Rmonth - 1][Rday - 1][i] != null) {
                System.out.printf("%d ; 적요 : %8s  수입 : %8d  지출 : %8d\n",
                    i,
                    arr[Ryear - 2021][Rmonth - 1][Rday - 1][i],
                    arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][i][0],
                    arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][i][1]);
            }
        }
        System.out.println("수정하고 싶은 인덱스를 입력하세요.");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("수정하고 싶은 부분을 알려주세요");
        System.out.println("0 : 전체\t 1 : 적요\t 2 : 수입\t 3 : 지출");
        int validation = sc.nextInt();
        sc.nextLine();

        if (validation == 0) {
            System.out.println("적요를 입력해 주세요.");
            arr[Ryear - 2021][Rmonth - 1][Rday - 1][num] = sc.nextLine();
            System.out.println("수입을 입력해 주세요");
            arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][num][0] = sc.nextInt();
            System.out.println("지출을 입력해 주세요");
            arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][num][1] = sc.nextInt();
            sc.nextLine();
        } else if (validation == 1) {
            System.out.println("적요를 입력해 주세요.");
            arr[Ryear - 2021][Rmonth - 1][Rday - 1][num] = sc.nextLine();
        } else if (validation == 2) {
            System.out.println("수입을 입력해 주세요");
            arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][num][0] = sc.nextInt();
            sc.nextLine();
        } else if (validation == 3) {
            System.out.println("지출을 입력해 주세요");
            arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][num][1] = sc.nextInt();
            sc.nextLine();
        }
    }

    private static void deleteData() {
        System.out.println("데이터를 삭제합니다.");
        System.out.println("삭제하고 싶은 데이터의 년, 월, 일을 입력하세요. ex) 2021 11 01");
        int Dyear = sc.nextInt();
        int Dmonth = sc.nextInt();
        int Dday = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 5; i++) {
            if (arr[Dyear - 2021][Dmonth - 1][Dday - 1][i] != null) {
                System.out.printf("%d ; 적요 : %8s  수입 : %8d  지출 : %8d\n",
                    i,
                    arr[Dyear - 2021][Dmonth - 1][Dday - 1][i],
                    arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i][0],
                    arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i][1]);
            }
        }
        System.out.println("삭제하고 싶은 인덱스를 입력하세요.");
        int num = sc.nextInt();
        sc.nextLine();
        if (num == 0) {
            arr[Dyear - 2021][Dmonth - 1][Dday - 1][0] = null;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][0][0] = 0;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][0][1] = 0;
            System.out.println("데이터 삭제 완료!!");
            System.out.println("===========================");
            return;
        }

        if (num == 4) {
            arr[Dyear - 2021][Dmonth - 1][Dday - 1][4] = null;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][4][0] = 0;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][4][1] = 0;
            System.out.println("데이터 삭제 완료!!");
            System.out.println("===========================");
            return;
        }

        for (int i = num; i < 4; i++) {
            if (arr[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1] != null) {
                arr[Dyear - 2021][Dmonth - 1][Dday - 1][i] = arr[Dyear - 2021][Dmonth - 1][Dday
                    - 1][i + 1];
                arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i][0] = arrMoney[Dyear - 2021][Dmonth
                    - 1][Dday - 1][i + 1][0];
                arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i][1] = arrMoney[Dyear - 2021][Dmonth
                    - 1][Dday - 1][i + 1][1];
            }
            arr[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1] = null;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1][0] = 0;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1][1] = 0;
        }
        System.out.println("데이터 삭제 완료!!");
        System.out.println("===========================");
        return;
    }

    private static void getData() {
        System.out.println("데이터를 입력합니다.");
        System.out.println("수입 또는 지출이 발생한 날짜를 입력해주세요. ex) 2021 11 01");

        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 5; i++) {
            if (arr[year - 2021][month - 1][day - 1][i] == null) {
                System.out.println("적요를 입력해 주세요.");
                arr[year - 2021][month - 1][day - 1][i] = sc.nextLine();
                System.out.println("수입을 입력해 주세요");
                arrMoney[year - 2021][month - 1][day - 1][i][0] = sc.nextInt();
                System.out.println("지출을 입력해 주세요");
                arrMoney[year - 2021][month - 1][day - 1][i][1] = sc.nextInt();
                sc.nextLine();
                break;
            }
        }
    }

    private static void printData() {
        System.out.println("출력하고 싶은 해당 년도와 월을 입력해 주세요. ex) 2021 11");

        int Pyear = sc.nextInt();
        int Pmonth = sc.nextInt();
        sc.nextLine();

        int money = 0;
        int getmoney;
        int losemoney;

        for (int j = 1; j <= 31; j++) {

            for (int i = 0; i < 5; i++) {
                if (arr[Pyear - 2021][Pmonth - 1][j - 1][i] != null) {
                    getmoney = 0;
                    losemoney = 0;
                    System.out.printf("%4d%4d %02d  ", Pyear, Pmonth, j);
                    getmoney = arrMoney[Pyear - 2021][Pmonth - 1][j - 1][i][0];
                    losemoney = arrMoney[Pyear - 2021][Pmonth - 1][j - 1][i][1];
                    System.out.printf(" 적요 : %8s  수입 : %8d  지출 : %8d\n",
                        arr[Pyear - 2021][Pmonth - 1][j - 1][i], getmoney, losemoney);
                    money = money + getmoney - losemoney;
                }

            }

        }
        System.out.println("이번 달 손익 : " + money + "원");
        System.out.println("===========================================");
    }

    private static boolean getUser() {
        System.out.println("회원가입 진행을 원하시면 Y를 이미 회원가입이 되어 있다면 N를 입력해주세요.");
        System.out.print("(Y/N) ");
        String isNewAccount = sc.nextLine();
        if (isNewAccount.equals("Y")) {
            getUserInformation();
            Useridx = idx - 1;
            return false;
        }
        if (isNewAccount.equals("N")) {
            int check = logIn();
            if (check != -1) {
                Useridx = check;
                return false;
            } else {
                System.out.println("로그인 실패!!");
                return true;
            }
        }
        return true;
    }

    private static int logIn() {
        System.out.print("아이디를 입력하세요 : ");
        String ID = sc.nextLine();

        System.out.print("비밀번호를 입력하세요 : ");
        String Password = sc.nextLine();

        for (int i = 0; i < UserID.size(); i++) {
            if (UserID.get(i).equals(ID) && UserPassword.get(i).equals(Password)) {
                return i;
            }
        }
        return -1;
    }

    private static void getUserInformation() {

        System.out.print("아이디를 입력하세요 : ");
        String ID = sc.nextLine();

        System.out.print("비밀번호를 입력하세요 : ");
        String Password = sc.nextLine();

        UserID.add(idx, ID);
        UserPassword.add(idx, Password);
        idx++;
    }

}
