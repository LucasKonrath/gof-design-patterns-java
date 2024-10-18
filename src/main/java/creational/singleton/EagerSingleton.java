package creational.singleton;

public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor so no one can instantiate the singleton straight away.
    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }

}
