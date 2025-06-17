package com.saibot.springdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/** Configuration class for Spring Security. */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

  /**
   * Configures the security filter chain.
   *
   * @param http the HttpSecurity object to configure
   * @return the configured SecurityFilterChain
   * @throws Exception if configuration fails
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    logger.info("Configuring SecurityFilterChain");
    try {
      return http.csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(
              auth ->
                  auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**")
                      .permitAll()
                      .anyRequest()
                      .authenticated())
          .httpBasic(basic -> {})
          .build();
    } catch (Exception e) {
      logger.error("Error configuring SecurityFilterChain", e);
      throw e;
    }
  }

  /**
   * Creates an in-memory user details manager.
   *
   * @return the UserDetailsManager bean
   */
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    logger.info("Creating in-memory user details manager");
    UserDetails user =
        User.builder()
            .username("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();
    logger.debug("In-memory user created: {}", user.getUsername());
    return new InMemoryUserDetailsManager(user);
  }

  /**
   * Creates a password encoder bean.
   *
   * @return the PasswordEncoder bean
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    logger.info("Creating BCryptPasswordEncoder bean");
    return new BCryptPasswordEncoder();
  }
}
