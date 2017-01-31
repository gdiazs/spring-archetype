package com.example.exampleapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exampleapp.service.SampleService;

@Controller
@RequestMapping("")
public class HomeController {

  private SampleService exampleappService;

  @Autowired
  public HomeController(SampleService exampleappService) {
    this.exampleappService = exampleappService;
  }


  @GetMapping
  public String index(Model model) {

    model.addAttribute("name", exampleappService.getServiceName());
    model.addAttribute("exampleapps", exampleappService.findAll());

    return "home/index";
  }
}
