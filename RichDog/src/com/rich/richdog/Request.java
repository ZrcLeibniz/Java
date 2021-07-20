package com.rich.richdog;

import com.rich.standar.http.Cookie;
import com.rich.standar.http.HttpServletRequest;
import com.rich.standar.http.HttpSession;

import java.util.List;
import java.util.Map;

public class Request implements HttpServletRequest {
    private final String method;
    private final String requestURI;
    private final String contextPath;
    private final String servletPath;
    private final Map<String, String> parameters;
    private final Map<String, String> headers;
    private final List<Cookie> cookieList;

    public Request(String method, String requestURI, String contextPath, String servletPath, Map<String, String> parameters, Map<String, String> headers, List<Cookie> cookieList) {
        this.method = method;
        this.requestURI = requestURI;
        this.contextPath = contextPath;
        this.servletPath = servletPath;
        this.parameters = parameters;
        this.headers = headers;
        this.cookieList = cookieList;
    }

    @Override
    public Cookie[] getCookie() {
        return cookieList.toArray(new Cookie[0]);
    }

    @Override
    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getRequestURI() {
        return requestURI;
    }

    @Override
    public String getContextPath() {
        return contextPath;
    }

    @Override
    public String getServletPath() {
        return servletPath;
    }

    @Override
    public HttpSession getSession() {
        return null;
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }
}
