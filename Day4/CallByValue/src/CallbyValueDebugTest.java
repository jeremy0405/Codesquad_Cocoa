public class CallbyValueDebugTest {

    static void run(A arg1, A arg2) {
        arg1.value = 111;
        arg2 = arg1;            // arg2가 arg1 의 메모리 주소값을 복사하는 것일 뿐
                                // arg2의 value 값이 111로 변하지는 않는다.
                                // 디버그 시에 run 메소드 안에서는 arg2.value 값이 111로 되어 있으나
                                // main 메소드로 넘어가면 arg2.value 값이 2로 원래처럼 돌아감.
                                // 사실 원래로 돌아간다는 표현보단 Heap 영역에서 arg2의 value 값(주소 값이 아닌 실제 값)을
                                // 변경해주지 않았기 때문에 main으로 가면 a2가 가르키는 메모리주소에 들어 있는 value값은 2가 맞다.
    }

    public static void main(String[] args) {

        A a1 = new A(1);
        A a2 = new A(2);

        run(a1, a2);

        System.out.println(a1.value);       // 111
        System.out.println(a2.value);       //   2
        //

    }

}
