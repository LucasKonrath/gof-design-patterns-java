package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class SessionFactory {
    private final Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String sessionId) {
        return sessions.computeIfAbsent(sessionId, SimpleSession::new);
    }
}
