package com.rich.richdog;

import com.rich.standar.Servlet;
import com.rich.standar.ServletException;

import java.io.IOException;
import java.util.*;

public class Context {
    private final ConfigReader reader;
    private final String name;
    private Config config;
    private ClassLoader webappClassLoader = Context.class.getClassLoader();
    List<Class<?>> servletClassList = new ArrayList<>();
    List<Servlet> servletList = new ArrayList<>();

    public Context(ConfigReader reader, String name) {
        this.reader = reader;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void readConfigFile() throws IOException {
        this.config = reader.read(name);
    }

    public void loadServletClasses() throws ClassNotFoundException {
        Set<String> servletClassNames = new HashSet<>(config.servletNameToClassName.values());
        for (String servletClassName : servletClassNames) {
            Class<?> servletClass = webappClassLoader.loadClass(servletClassName);
            servletClassList.add(servletClass);
        }
    }

    public void instantiateServletObjects() throws IllegalAccessException, InstantiationException {
        for (Class<?> aClass : servletClassList) {
            Servlet servlet = (Servlet) aClass.newInstance();
            servletList.add(servlet);
        }
    }

    public void initializeServletObjects() throws ServletException {
        for (Servlet servlet : servletList) {
            servlet.init();
        }
    }

    public void destroyServlets() {
        for (Servlet servlet : servletList) {
            servlet.destroy();
        }
    }
}
