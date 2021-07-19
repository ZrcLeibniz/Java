package com.rich.standar.http;

import com.rich.standar.ServletResponse;

public interface HttpServletResponse extends ServletResponse {
    void addCookie(Cookie cookie);

    void sendError(int sc);

    void sendRedirect(String location);

    void setHeaders(String name, String value);

    void setStatus(int sc);
}
