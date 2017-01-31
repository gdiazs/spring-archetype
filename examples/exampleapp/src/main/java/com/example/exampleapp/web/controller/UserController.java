/**
 * Copyright (C) 29 ene. 2017 Guillermo Díaz Solís.
 * Todos los derechos reservados.
 */
package com.example.exampleapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.thymeleaf.Layout;

/**
 * @author Guillermo B Díaz Solís
 * @since 29 ene. 2017
 * @version 1.0
 */
@Controller
@RequestMapping("users")
@Layout("layouts/login")
public class UserController {

  @RequestMapping("/login")
  public String login(){
    
    
    return "user/login";
  }
  
  @RequestMapping("/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response){
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){    
        new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login?logout";
  }
}
