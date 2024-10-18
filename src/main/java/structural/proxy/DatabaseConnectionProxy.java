package structural.proxy;

public class DatabaseConnectionProxy implements DatabaseConnection {

    private static DatabaseConnection instance;

    @Override
    public void executeQuery(String query) {
        if (instance == null) {
            instance = new DatabaseConnectionImpl();
        }
        instance.executeQuery(query);
    }
}
