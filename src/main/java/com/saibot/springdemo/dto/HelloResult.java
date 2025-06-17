package com.saibot.springdemo.dto;

import java.time.Instant;

/**
 * DTO for the /hello endpoint result.
 */
public class HelloResult {
  private String result;
  private final String dateUtc = Instant.now().toString();

  public HelloResult(String result) {
    this.result = result;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getDateUtc() {
    return dateUtc;
  }
}
