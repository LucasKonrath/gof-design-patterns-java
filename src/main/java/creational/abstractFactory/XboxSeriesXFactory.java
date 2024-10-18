package creational.abstractFactory;

public class XboxSeriesXFactory implements ConsoleAbstractFactory {
    @Override
    public Console createConsole() {
        return new XboxSeriesX();
    }
}
