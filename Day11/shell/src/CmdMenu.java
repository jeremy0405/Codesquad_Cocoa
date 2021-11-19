import hclock.Mainclock;

public class CmdMenu {

    Cmd cmd = new Cmd();
    Mainclock clock = new Mainclock();

    public boolean run(String command) {

        String[] com = command.split(" +");

        switch (com[0]) {
            case "cd":
                cmd.cd(com[1]);
                return true;
            case "pwd":
                cmd.pwd();
                return true;
            case "clock":
                clock.clockRun();
                return true;
            case "exit":
                return false;
            default:
                cmd.cmd();
                return true;
        }

    }

}
