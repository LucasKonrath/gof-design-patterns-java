package behavioral.command;

public class CommandInvoker {

    public Command command;

    public CommandInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}
