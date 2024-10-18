package structural.proxy;

public class DatabaseConnectionImpl implements DatabaseConnection {

    public DatabaseConnectionImpl() {
        setupInitialConnection();
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Query executed");
    }

    private void setupInitialConnection() {
        System.out.printf("Setting up database connection\n");
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
