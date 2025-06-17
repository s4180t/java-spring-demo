package com.saibot.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Main class for the Spring Boot demo application. */
@SpringBootApplication
public class SpringDemoApplication {
  private static final Logger logger = LoggerFactory.getLogger(SpringDemoApplication.class);

  /**
   * Application entry point.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    logger.info("Starting SpringDemoApplication");
    SpringApplication.run(SpringDemoApplication.class, args);
    logger.info("SpringDemoApplication started successfully");
  }
}
