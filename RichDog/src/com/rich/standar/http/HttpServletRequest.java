package com.rich.standar.http;

import com.rich.standar.ServletRequest;

public interface HttpServletRequest extends ServletRequest {
    Cookie[] getCookie();

    String getHeader(String name);

    String getMethod();

    String getRequestURI();

    String getContextPath();

    String getServletPath();

    HttpSession getSession();
}
