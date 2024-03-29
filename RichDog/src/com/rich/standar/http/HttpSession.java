package com.rich.standar.http;

public interface HttpSession {
    Object getAttribute(String name);

    void removeAttribute(String name);

    void setAttribute(String name, Object value);
}
