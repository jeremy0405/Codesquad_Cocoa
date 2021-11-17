import java.util.Scanner;

class Test extends Thread {

    public void run() {

        try {
            for( int i = 0; i < 20; i++ ) {
                System.out.println(i + 1 + ". before sleep...");
                sleep(4000);
            }

        } catch( InterruptedException e ) {
            System.out.println( "InterruptedException 발생" );
        }

    }



    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        t.start();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.equals("q")) {
            t.interrupt();
        }
        //t 스레드가 종료할 때 까지 main Thread가 기다림
        // join이 생략되면 "Main Thread 종료"가 제일 먼저 출력됨
        System.out.println("Main Thread 종료...");

    }

}
