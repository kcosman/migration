package com.nfl.mysqltoneo;

import com.nfl.mysqltoneo.config.BatchConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

public class Application {
	public static void main(String[] args) {
        new SpringApplication(BatchConfiguration.class).run(args);
    }
}
