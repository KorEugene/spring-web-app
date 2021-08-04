package ru.geekbrains.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.webapp.services.FlywayService;
import ru.geekbrains.webapp.util.PropertyUtil;

@SpringBootApplication
public class SpringWebAppApplication {

    public static void main(String[] args) {
        PropertyUtil.loadProperties();

        FlywayService.getInstance().migrate();

        SpringApplication.run(SpringWebAppApplication.class, args);
    }

}
