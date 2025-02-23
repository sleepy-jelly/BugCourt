package com.sleepyjelly.pb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
public class BugCourtApplicationTestConfig {

    public static void main(String[] args) {
        SpringApplication.run(BugCourtApplicationTestConfig.class, args);
    }
    
}