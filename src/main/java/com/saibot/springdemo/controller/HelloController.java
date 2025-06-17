package com.saibot.springdemo.controller;

import com.saibot.springdemo.dto.HelloResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** REST controller that handles hello endpoint. */
@RestController
public class HelloController {
  private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

  /**
   * Returns a JSON object {"result": "banana"} when /hello endpoint is accessed.
   *
   * @return a HelloResult object with result set to "banana"
   */
  @Operation(
      summary = "Returns a banana result",
      responses = {
        @ApiResponse(
            description = "Successful response",
            responseCode = "200",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = HelloResult.class)))
      })
  @GetMapping("/hello")
  public HelloResult hello() {
    logger.info("/hello endpoint called");
    HelloResult result = new HelloResult("banana");
    logger.debug("Returning HelloResult: {}", result.getResult());
    return result;
  }
}
