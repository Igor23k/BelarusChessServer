package by.of.bobrchess.belaruschess.server.entity;

import java.util.Map;

public class UserContext {

    private final User user;
    private final Map<String, String> tokenMap;

    public UserContext(User user, Map<String, String> tokenMap) {
        this.user = user;
        this.tokenMap = tokenMap;
    }

    public User getUser() {
        return user;
    }

    public Map<String, String> getTokenMap() {
        return tokenMap;
    }
}
