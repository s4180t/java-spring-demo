package com.saibot.springdemo.dto;

import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** DTO for the /hello endpoint result. */
public class HelloResult {
  private static final Logger logger = LoggerFactory.getLogger(HelloResult.class);
  private String result;
  private final String dateUtc = Instant.now().toString();

  public HelloResult(String result) {
    this.result = result;
    logger.debug("HelloResult created with result: {} at {}", result, dateUtc);
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    logger.info("Setting result to: {}", result);
    this.result = result;
  }

  public String getDateUtc() {
    return dateUtc;
  }
}
