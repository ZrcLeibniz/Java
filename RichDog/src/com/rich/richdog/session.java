package com.rich.richdog;

import com.rich.standar.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class session implements HttpSession {
    private final String sessionId;
    private final Map<String, Object> sessionData;

    public session() {
        sessionId = UUID.randomUUID().toString();
        sessionData = new HashMap<>();
    }

    public session(String sessionId) {
        this.sessionId = sessionId;
        sessionData = loadSessionData(sessionId);
    }

    private Map<String, Object> loadSessionData(String sessionId) {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return sessionData.get(name);
    }

    @Override
    public void removeAttribute(String name) {
        sessionData.remove(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        sessionData.put(name, value);
    }
}
