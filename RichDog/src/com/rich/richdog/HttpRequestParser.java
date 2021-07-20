package com.rich.richdog;

import com.rich.standar.http.Cookie;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;

public class HttpRequestParser {
    public Request parse(InputStream socketInputStream) throws IOException {
        Map<String, String> parameters = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        List<Cookie> cookieList = new ArrayList<>();
        Scanner scanner = new Scanner(socketInputStream, "utf-8");
        String method = scanner.next().toLowerCase();
        String path = scanner.next();
        int i = path.indexOf("?");
        String requestURI = path;
        if (i != -1) {
            requestURI = path.substring(0, i);
            String queryString = path.substring(i + 1);
            for (String KV : queryString.split("&")) {
                String[] split = KV.split("=");
                String name = URLDecoder.decode(split[0].trim(), "utf-8");
                String value = URLDecoder.decode(split[1].trim(), "utf-8");
                parameters.put(name, value);
            }
        }
        int j = requestURI.indexOf('/', 1);
        String contextPath = requestURI.substring(1, j);
        String servletPath = requestURI.substring(j);
        String version = scanner.nextLine();
        String headLine;
        while (scanner.hasNextLine() && !(headLine = scanner.nextLine().trim()).isEmpty()) {
            String[] parts = headLine.split(":");
            String name = parts[0].toLowerCase();
            String value = parts[1].toLowerCase();
            headers.put(name, value);
            if (name.equals("cookie")) {
                String[] kvParts = value.split(";");
                String cookieName = kvParts[0].trim();
                String cookieValue = kvParts[1].trim();
                Cookie cookie = new Cookie(cookieName, cookieValue);
                cookieList.add(cookie);
            }
        }
        return new Request(method, requestURI, contextPath, servletPath, parameters, headers, cookieList);
    }
}
