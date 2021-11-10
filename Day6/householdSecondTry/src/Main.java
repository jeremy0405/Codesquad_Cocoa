import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> UserID = new ArrayList<>();
    public static ArrayList<String> UserPassword = new ArrayList<>();
    public static String[][][][] text = new String[2][12][31][5];
    public static String[][][][] type = new String[2][12][31][5];
    public static int[][][][][] arrMoney = new int[2][12][31][5][2];

    public static int idx = 0;
    public static int Useridx;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean workHouseholdAccount = true;
        while (workHouseholdAccount) {
            workHouseholdAccount = getUser();
        }

        System.out.println("=====================");
        System.out.println(UserID.get(Useridx) + "님 환영합니다!!");

        boolean keepWork = true;
        while (keepWork) {
            keepWork = chooseFunction();
        }

    }

    private static boolean chooseFunction() {
        System.out.println(
            "=============================================================================================");
        System.out.println(
            "I : 데이터 입력\t D : 데이터 삭제\t R : 데이터 수정 \t P : 데이터 출력 \t S : 데이터 검색 \t Q : 종료");
        System.out.println(
            "=============================================================================================");

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
            case "S":
                searchData();
                break;
            case "Q":
                System.out.println("시스템을 종료합니다.");
                fileWrite();
                return false;
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
                System.out.println("==================================");
                return chooseFunction();
        }
        return true;
    }

    private static void searchData() {
        System.out.println("데이터를 검색합니다.");

        System.out.println("적요를 통한 검색을 원하시면 1 >>>");
        System.out.print("소비 유형을 통한 검색을 원하시면 2 >>> ");

        int val = sc.nextInt();
        sc.nextLine();

        if(val == 1){
            searchText();
        } else if (val == 2) {
            searchType();
        } else {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("==================================");
        }



    }

    private static void searchType() {
        System.out.println("검색하고 싶은 데이터의 년, 월, 소비 유형을 입력하세요. ex) 2021 11 카드");
        int Syear = sc.nextInt();
        int Smonth = sc.nextInt();
        String Stype = sc.next();
        sc.nextLine();
        int getmoney;
        int losemoney;
        int money = 0;

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 5; j++) {
                if (Stype.equals(type[Syear - 2021][Smonth - 1][i][j])) {
                    getmoney = 0;
                    losemoney = 0;
                    System.out.printf("%4d %02d %02d  ", Syear, Smonth, i);
                    getmoney = arrMoney[Syear - 2021][Smonth - 1][i][j][0];
                    losemoney = arrMoney[Syear - 2021][Smonth - 1][i][j][1];
                    System.out.printf(" 적요 : %8s  수입 : %8d  지출 : %8d    소비 유형 : %3s\n",
                        text[Syear - 2021][Smonth - 1][i][j], getmoney, losemoney,
                        type[Syear - 2021][Smonth - 1][i][j]);
                    money = money + getmoney - losemoney;
                }
            }
        }
        System.out.println("손익 : " + money + "원");
        System.out.println("======================================================");
        System.out.println("");
    }

    private static void searchText() {
        System.out.println("검색하고 싶은 데이터의 년, 월, 적요을 입력하세요. ex) 2021 11 coffee");
        int Syear = sc.nextInt();
        int Smonth = sc.nextInt();
        String Stext = sc.next();
        sc.nextLine();
        int getmoney;
        int losemoney;
        int money = 0;

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 5; j++) {
                if (Stext.equals(text[Syear - 2021][Smonth - 1][i][j])) {
                    getmoney = 0;
                    losemoney = 0;
                    System.out.printf("%4d %02d %02d  ", Syear, Smonth, i);
                    getmoney = arrMoney[Syear - 2021][Smonth - 1][i][j][0];
                    losemoney = arrMoney[Syear - 2021][Smonth - 1][i][j][1];
                    System.out.printf(" 적요 : %8s  수입 : %8d  지출 : %8d    소비 유형 : %3s\n",
                        text[Syear - 2021][Smonth - 1][i][j], getmoney, losemoney,
                        type[Syear - 2021][Smonth - 1][i][j]);
                    money = money + getmoney - losemoney;
                }
            }
        }
        System.out.println("손익 : " + money + "원");
        System.out.println("======================================================");
        System.out.println("");
    }

    private static void fileWrite() {
        try {
            FileWriter fw = new FileWriter("data.txt", false);
            BufferedWriter writer = new BufferedWriter(fw);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 12; j++) {
                    for (int k = 0; k < 31; k++) {
                        for (int l = 0; l < 5; l++) {
                            if (text[i][j][k][l] != null) {
                                writer.append(String.valueOf(i)).append(" ")
                                    .append(String.valueOf(j)).append(" ")
                                    .append(String.valueOf(k)).append(" ")
                                    .append(String.valueOf(l)).append(" ")
                                    .append(text[i][j][k][l]).append(" ")
                                    .append(String.valueOf(arrMoney[i][j][k][l][0])).append(" ")
                                    .append(String.valueOf(arrMoney[i][j][k][l][1])).append(" ")
                                    .append(type[i][j][k][l]).append("\n");
                            }
                        }
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reviseData() {
        System.out.println("데이터를 수정합니다.");
        System.out.println("수정하고 싶은 데이터의 년, 월, 일을 입력하세요. ex) 2021 11 01");
        int Ryear = sc.nextInt();
        int Rmonth = sc.nextInt();
        int Rday = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 5; i++) {
            if (text[Ryear - 2021][Rmonth - 1][Rday - 1][i] != null) {
                System.out.printf("%d ; 적요 : %8s  수입 : %8d  지출 : %8d  소비 유형 : %4s\n",
                    i,
                    text[Ryear - 2021][Rmonth - 1][Rday - 1][i],
                    arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][i][0],
                    arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][i][1],
                    type[Ryear - 2021][Rmonth - 1][Rday - 1][i]);
            }
        }
        System.out.println("수정하고 싶은 인덱스를 입력하세요.");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("수정하고 싶은 부분을 알려주세요");
        System.out.println("0 : 전체\t 1 : 적요\t 2 : 수입\t 3 : 지출\t 4 : 소비 유형");
        int validation = sc.nextInt();
        sc.nextLine();

        if (validation == 0) {
            System.out.println("적요를 입력해 주세요.");
            text[Ryear - 2021][Rmonth - 1][Rday - 1][num] = sc.nextLine();
            System.out.println("수입을 입력해 주세요");
            arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][num][0] = sc.nextInt();
            System.out.println("지출을 입력해 주세요");
            arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][num][1] = sc.nextInt();
            sc.nextLine();
            System.out.print("소비 유형을 입력해 주세요 (현금 or 카드) ");
            type[Ryear - 2021][Rmonth - 1][Rday - 1][num] = sc.nextLine();
        } else if (validation == 1) {
            System.out.println("적요를 입력해 주세요.");
            text[Ryear - 2021][Rmonth - 1][Rday - 1][num] = sc.nextLine();
        } else if (validation == 2) {
            System.out.println("수입을 입력해 주세요");
            arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][num][0] = sc.nextInt();
            sc.nextLine();
        } else if (validation == 3) {
            System.out.println("지출을 입력해 주세요");
            arrMoney[Ryear - 2021][Rmonth - 1][Rday - 1][num][1] = sc.nextInt();
            sc.nextLine();
        } else if (validation == 4) {
            System.out.print("소비 유형을 입력해 주세요 ( 현금 or 카드 )");
            type[Ryear - 2021][Rmonth - 1][Rday - 1][num] = sc.nextLine();
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
            if (text[Dyear - 2021][Dmonth - 1][Dday - 1][i] != null) {
                System.out.printf("%d ; 적요 : %8s  수입 : %8d  지출 : %8d\n",
                    i,
                    text[Dyear - 2021][Dmonth - 1][Dday - 1][i],
                    arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i][0],
                    arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i][1]);
            }
        }
        System.out.println("삭제하고 싶은 인덱스를 입력하세요.");
        int num = sc.nextInt();
        sc.nextLine();
        if (num == 0) {
            text[Dyear - 2021][Dmonth - 1][Dday - 1][0] = null;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][0][0] = 0;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][0][1] = 0;
            type[Dyear - 2021][Dmonth - 1][Dday - 1][0] = null;
            System.out.println("데이터 삭제 완료!!");
            System.out.println("===========================");
            return;
        }

        if (num == 4) {
            text[Dyear - 2021][Dmonth - 1][Dday - 1][4] = null;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][4][0] = 0;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][4][1] = 0;
            type[Dyear - 2021][Dmonth - 1][Dday - 1][0] = null;
            System.out.println("데이터 삭제 완료!!");
            System.out.println("===========================");
            return;
        }

        for (int i = num; i < 4; i++) {
            if (text[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1] != null) {
                text[Dyear - 2021][Dmonth - 1][Dday - 1][i] = text[Dyear - 2021][Dmonth - 1][Dday
                    - 1][i + 1];
                arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i][0] = arrMoney[Dyear - 2021][Dmonth
                    - 1][Dday - 1][i + 1][0];
                arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i][1] = arrMoney[Dyear - 2021][Dmonth
                    - 1][Dday - 1][i + 1][1];
                type[Dyear - 2021][Dmonth - 1][Dday - 1][i] = type[Dyear - 2021][Dmonth - 1][Dday
                    - 1][i + 1];
            }
            text[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1] = null;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1][0] = 0;
            arrMoney[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1][1] = 0;
            type[Dyear - 2021][Dmonth - 1][Dday - 1][i + 1] = null;
        }
        System.out.println("데이터 삭제 완료!!");
        System.out.println("===========================");
    }

    private static void getData() {
        System.out.println("데이터를 입력합니다.");
        System.out.println("수입 또는 지출이 발생한 날짜를 입력해주세요. ex) 2021 11 01");

        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 5; i++) {
            if (text[year - 2021][month - 1][day - 1][i] == null) {
                System.out.print("적요를 입력해 주세요 : ");
                text[year - 2021][month - 1][day - 1][i] = sc.nextLine();
                System.out.print("수입을 입력해 주세요 : ");
                arrMoney[year - 2021][month - 1][day - 1][i][0] = sc.nextInt();
                System.out.print("지출을 입력해 주세요 : ");
                arrMoney[year - 2021][month - 1][day - 1][i][1] = sc.nextInt();
                sc.nextLine();
                System.out.print("소비 유형을 입력해 주세요 (현금 or 카드) ");
                type[year - 2021][month - 1][day - 1][i] = sc.nextLine();
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
                if (text[Pyear - 2021][Pmonth - 1][j - 1][i] != null) {
                    getmoney = 0;
                    losemoney = 0;
                    System.out.printf("%4d %02d %02d  ", Pyear, Pmonth, j);
                    getmoney = arrMoney[Pyear - 2021][Pmonth - 1][j - 1][i][0];
                    losemoney = arrMoney[Pyear - 2021][Pmonth - 1][j - 1][i][1];
                    System.out.printf(" 적요 : %8s  수입 : %8d  지출 : %8d    소비 유형 : %3s\n",
                        text[Pyear - 2021][Pmonth - 1][j - 1][i], getmoney, losemoney,
                        type[Pyear - 2021][Pmonth - 1][j - 1][i]);
                    money = money + getmoney - losemoney;
                }

            }

        }
        System.out.println("손익 : " + money + "원");
        System.out.println("======================================================");
        System.out.println("");
    }

    private static boolean getUser() {
        System.out.println("회원가입 진행을 원하시면 Y를 이미 회원가입이 되어 있다면 N를 입력해주세요.");
        System.out.print("(Y/N) ");
        String isNewAccount = sc.nextLine();
        if (isNewAccount.equals("Y")) {
            getUserInformation();
            Useridx = idx - 1;
            fileRead();
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

    private static void fileRead() {
        try (
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
        ) {
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                String[] s = readLine.split(" ");

                text[Integer.parseInt(s[0])][Integer.parseInt(s[1])][Integer.parseInt(
                    s[2])][Integer.parseInt(s[3])] = s[4];
                arrMoney[Integer.parseInt(s[0])][Integer.parseInt(s[1])][Integer.parseInt(
                    s[2])][Integer.parseInt(s[3])][0] = Integer.parseInt(s[5]);
                arrMoney[Integer.parseInt(s[0])][Integer.parseInt(s[1])][Integer.parseInt(
                    s[2])][Integer.parseInt(s[3])][1] = Integer.parseInt(s[6]);
                type[Integer.parseInt(s[0])][Integer.parseInt(s[1])][Integer.parseInt(
                    s[2])][Integer.parseInt(s[3])] = s[7];

            }
        } catch (IOException e) {
            System.out.println(e);
        }
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
