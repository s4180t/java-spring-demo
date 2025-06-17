package com.saibot.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller that handles hello endpoint.
 */
@RestController
public class HelloController {

  /**
   * Returns the string "banana" when /hello endpoint is accessed.
   *
   * @return the string "banana"
   */
  @GetMapping("/hello")
  public String hello() {
    return "banana";
  }
}