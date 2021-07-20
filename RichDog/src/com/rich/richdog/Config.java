package com.rich.richdog;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Config {
    public Map<String, String> servletNameToClassName = new HashMap<>();
    public LinkedHashMap<String, String> urlToServletNameMap = new LinkedHashMap<>();

    public Config(Map<String, String> servletNameToClassName, LinkedHashMap<String, String> urlToServletNameMap) {
        this.servletNameToClassName = servletNameToClassName;
        this.urlToServletNameMap = urlToServletNameMap;
    }
}
