package ru.geekbrains.webapp.services;

import org.flywaydb.core.Flyway;
import ru.geekbrains.webapp.util.PropertyUtil;

public class FlywayService {

    private static FlywayService instance;

    private FlywayService() {
    }

    public static FlywayService getInstance() {
        if (instance == null) {
            instance = new FlywayService();
        }
        return instance;
    }

    public void migrate() {
        Flyway flyway = Flyway.configure().dataSource(
                PropertyUtil.getDBConnection(),
                PropertyUtil.getDBLogin(),
                PropertyUtil.getDBPassword()
        ).load();
        flyway.migrate();
    }
}
