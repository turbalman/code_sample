package com.demo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The type Application.
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Application {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
