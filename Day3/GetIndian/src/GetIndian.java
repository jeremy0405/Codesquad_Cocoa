import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetIndian {

    public static int[] Getbirthday() throws IOException {
        int[] arr = new int[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static void PrintIndianName(int y, int m, int d){
        int y_idx = y % 10;

        switch(y_idx){
            case 0 :
                System.out.print("시끄러운 ");
                break;
            case 1 :
                System.out.print("푸른 ");
                break;
            case 2 :
                System.out.print("어두운 ");
                break;
            case 3 :
                System.out.print("조용한 ");
                break;
            case 4 :
                System.out.print("웅크린 ");
                break;
            case 5 :
                System.out.print("백색 ");
                break;
            case 6 :
                System.out.print("지혜로운 ");
                break;
            case 7 :
                System.out.print("용감한 ");
                break;
            case 8 :
                System.out.print("날카로운 ");
                break;
            case 9 :
                System.out.print("욕심많은 ");
                break;
            default :
                System.out.println("year 처리 과정에서 오류발생");
        }

        switch(m) {
            case 1:
                System.out.print("늑대 ");
                break;
            case 2:
                System.out.print("태양 ");
                break;
            case 3:
                System.out.print("양 ");
                break;
            case 4:
                System.out.print("매 ");
                break;
            case 5:
                System.out.print("황소 ");
                break;
            case 6:
                System.out.print("불꽃 ");
                break;
            case 7:
                System.out.print("나무 ");
                break;
            case 8:
                System.out.print("달빛 ");
                break;
            case 9:
                System.out.print("말 ");
                break;
            case 10:
                System.out.print("돼지 ");
                break;
            case 11:
                System.out.print("하늘 ");
                break;
            case 12:
                System.out.print("바람 ");
                break;
            default :
                System.out.println("month 처리 중 오류 발생");
        }


    }

    public static void main(String[] args) throws IOException {
        System.out.println("생년월일을 입력하세요. ex) 1996 04 05");
        int[] birthday = Getbirthday();

        PrintIndianName(birthday[0], birthday[1],birthday[2]);

    }

}
