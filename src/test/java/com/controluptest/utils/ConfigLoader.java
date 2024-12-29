package com.controluptest.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    static {
        try (InputStream inputStream = ConfigLoader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("config.properties not found in resources");
            }
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
