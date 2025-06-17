package com.saibot.springdemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/** Unit tests for {@link HelloController}. */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

  @Autowired private MockMvc mockMvc;

  /**
   * Tests that the /hello endpoint returns {"result": "banana", "dateUtc": ...} in JSON format.
   *
   * @throws Exception if the request fails
   */
  @Test
  void helloEndpointReturnsBanana() throws Exception {
    MvcResult result =
        mockMvc
            .perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("banana"))
            .andExpect(jsonPath("$.dateUtc").exists())
            .andExpect(jsonPath("$.dateUtc").isString())
            .andReturn();

    // Validate that dateUtc is a valid ISO-8601 UTC date
    String response = result.getResponse().getContentAsString();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(response);
    String dateUtc = node.get("dateUtc").asText();
    Instant.parse(dateUtc); // will throw if not valid ISO-8601
  }
}
