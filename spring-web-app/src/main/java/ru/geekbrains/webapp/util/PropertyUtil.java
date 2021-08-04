package ru.geekbrains.webapp.util;

import ru.geekbrains.webapp.SpringWebAppApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    public static final String PROPERTIES_FILE = "db.properties";
    public static final String DB_CONNECTION = "db_connection";
    public static final String DB_LOGIN = "db_login";
    public static final String DB_PASSWORD = "db_password";

    private static Properties properties;

    private PropertyUtil() {
    }

    public static void loadProperties() {
        try (InputStream input = SpringWebAppApplication.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getDBConnection() {
        return properties.getProperty(DB_CONNECTION);
    }

    public static String getDBLogin() {
        return properties.getProperty(DB_LOGIN);
    }

    public static String getDBPassword() {
        return properties.getProperty(DB_PASSWORD);
    }
}
