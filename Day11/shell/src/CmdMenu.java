public class Cmd {

    public boolean run(String command) {

        switch (command) {
            case "cd":
                //todo cd 메소드 호출
                return true;
            case "pwd":
                //todo pwd 메소드 호출
                return true;
            case "clock":
                //todo 시계 호출
                return true;
            case "exit":
                return false;
            default:
                //todo cmd 호출
                return true;
        }

    }

}
