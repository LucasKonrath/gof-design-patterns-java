package structural.proxy;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.Assert.assertTrue;

public class ProxyTest {

    @Test
    public void test() {
        Instant then = Instant.now();
        DatabaseConnectionProxy proxy = new DatabaseConnectionProxy();
        proxy.executeQuery("SELECT * FROM TEST");
        proxy.executeQuery("SELECT * FROM TEST");
        proxy.executeQuery("SELECT * FROM TEST");
        Instant now = Instant.now();
        long proxyDelta = Duration.between(then, now).toMillis();

        then = Instant.now();
        DatabaseConnectionImpl databaseConnection = new DatabaseConnectionImpl();
        databaseConnection.executeQuery("SELECT * FROM TEST");
        DatabaseConnectionImpl databaseConnection2 = new DatabaseConnectionImpl();
        databaseConnection2.executeQuery("SELECT * FROM TEST");
        DatabaseConnectionImpl databaseConnection3 = new DatabaseConnectionImpl();
        databaseConnection3.executeQuery("SELECT * FROM TEST");
        now = Instant.now();

        long noProxyDelta = Duration.between(then, now).toMillis();

        System.out.println("Proxy delta:" + proxyDelta + "ms no Proxy delta:" + noProxyDelta + "ms");
        assertTrue(proxyDelta < noProxyDelta);
    }
}
