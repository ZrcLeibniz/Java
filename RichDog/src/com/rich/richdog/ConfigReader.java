package com.rich.richdog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static com.rich.richdog.HttpServer.WEBAPPS_BASE;

public class ConfigReader {
    public Config read(String name) throws IOException {
        Map<String, String> servletNameToClassName = new HashMap<>();
        LinkedHashMap<String, String> urlToServletNameMap = new LinkedHashMap<>();

        String fileName = String.format("%s/%s/WEB-INF/web.conf", WEBAPPS_BASE, name);
        String stage = "start";
        try (InputStream is = new FileInputStream(fileName)) {
            Scanner scanner = new Scanner(is, "utf-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                switch (stage) {
                    case "start":
                        if (line.equals("servlets:")) {
                            stage = "servlets";
                        }
                        break;
                    case "servlets":
                        if (line.equals("servlet-mapping:")) {
                            stage = "mapping";
                        } else {
                            String[] parts = line.split("=");
                            String servletName = parts[0].trim();
                            String servletClassName = parts[1].trim();
                            servletNameToClassName.put(servletName, servletClassName);
                        }
                        break;
                    case "mapping":
                        String[] parts = line.split("=");
                        String servletName = parts[0].trim();
                        String servletClassName = parts[1].trim();
                        urlToServletNameMap.put(servletName, servletClassName);
                        break;
                }
            }
        }
        return new Config(servletNameToClassName, urlToServletNameMap);
    }
}
