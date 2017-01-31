package com.example.exampleapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Guillermo B Díaz Solís
 * @since 12 de jul. de 2016
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  @Qualifier("userDetailsServiceImpl")
  private UserDetailsService userDetailsService;

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
    http.authorizeRequests()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/users/logout").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/users/login").permitAll()
        .and().logout().logoutUrl("/users/logout");

  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
