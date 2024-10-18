package structural.flyweight;

public class SimpleSession implements Session {
    public String sessionId;

    public SimpleSession(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void login() {
        System.out.print("Logged in as " + sessionId);
    }
}
