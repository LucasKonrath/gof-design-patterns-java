package creational.abstractFactory;

public class PS5Factory implements ConsoleAbstractFactory {
    @Override
    public Console createConsole() {
        return new PS5();
    }
}
