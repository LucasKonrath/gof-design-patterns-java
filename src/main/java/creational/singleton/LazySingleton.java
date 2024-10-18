package creational.singleton;

public class LazySingleton {

    private static LazySingleton instance;

    // Private constructor so no one can instantiate the singleton straight away.
    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
