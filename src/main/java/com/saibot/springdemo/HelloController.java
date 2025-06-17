package com.saibot.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * REST controller that handles hello endpoint.
 */
@RestController
public class HelloController {

  /**
   * Returns a JSON object {"result": "banana"} when /hello endpoint is accessed.
   *
   * @return a HelloResult object with result set to "banana"
   */
  @Operation(summary = "Returns a banana result", responses = {
      @ApiResponse(description = "Successful response", responseCode = "200",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = HelloResult.class)))
  })
  @GetMapping("/hello")
  public HelloResult hello() {
    return new HelloResult("banana");
  }
}