package com.jirifrank.work.moneta.test.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.jirifrank.work.moneta.test.config.ApplicationConfig.APPLICATION_PACKAGE;

@SpringBootApplication(scanBasePackages = APPLICATION_PACKAGE)
public class ApplicationConfig {

	public static final String APPLICATION_PACKAGE = "com.jirifrank.work.moneta.test";

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}

}
