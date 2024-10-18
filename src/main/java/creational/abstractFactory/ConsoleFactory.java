package creational.abstractFactory;

public class ConsoleFactory {

    public static Console createConsole(ConsoleAbstractFactory consoleAbstractFactory) {
        return consoleAbstractFactory.createConsole();
    }
}
