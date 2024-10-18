package creational.singleton;

public class StaticSingleton {

    private static final StaticSingleton instance;

    // Private constructor so no one can instantiate the singleton straight away.
    private StaticSingleton() {}

    // This way we can catch and rethrow exceptions.
    static {
        try {
            instance = new StaticSingleton();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static StaticSingleton getInstance() {
        return instance;
    }

}
