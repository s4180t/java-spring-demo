package com.saibot.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Void> handleNotFound(NoHandlerFoundException ex) {
    logger.error("404 Not Found: {} {}", ex.getHttpMethod(), ex.getRequestURL());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}
