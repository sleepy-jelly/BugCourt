package com.sleepyjelly.pb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
@MapperScan("com.sleepyjelly.pb.common.user.service.impl")
public class BugCourtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugCourtApplication.class, args);
	}

}
