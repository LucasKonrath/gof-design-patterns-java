package structural.facade;

public abstract class Key {
    void press() {
        System.out.println(getKey());
    };

    abstract String getKey();
}
