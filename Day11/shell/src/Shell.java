public class Shell {

    private boolean isRun = true;

    private final Input input = new Input();
    private final CmdMenu cmdmenu = new CmdMenu();

    public void run() {

        while (isRun) {
            String command = input.getInput("");
            isRun = cmdmenu.run(command);
        }
        input.close();
    }
}
