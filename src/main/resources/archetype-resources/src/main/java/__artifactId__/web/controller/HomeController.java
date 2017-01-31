#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ${package}.${artifactId}.service.SampleService;

@Controller
@RequestMapping("")
public class HomeController {

  private SampleService ${artifactId}Service;

  @Autowired
  public HomeController(SampleService ${artifactId}Service) {
    this.${artifactId}Service = ${artifactId}Service;
  }


  @GetMapping
  public String index(Model model) {

    model.addAttribute("name", ${artifactId}Service.getServiceName());
    model.addAttribute("${artifactId}s", ${artifactId}Service.findAll());

    return "home/index";
  }
}
