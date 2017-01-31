package com.example.exampleapp.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.example.exampleapp.RootConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.support.
   * AbstractDispatcherServletInitializer#onStartup(javax.servlet. ServletContext)
   */
  @Override
  public void onStartup(ServletContext context) throws ServletException {
    // context.setInitParameter("spring.profiles.active", "test");
    super.onStartup(context);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.support.
   * AbstractAnnotationConfigDispatcherServletInitializer# getRootConfigClasses()
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    // TODO Auto-generated method stub
    return new Class[] {RootConfig.class};
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.support.
   * AbstractAnnotationConfigDispatcherServletInitializer# getServletConfigClasses()
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {WebConfig.class, WebSecurityConfig.class};
  }

  @Override
  protected Filter[] getServletFilters() {
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding("UTF-8");
    return new Filter[] {characterEncodingFilter};
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.support.
   * AbstractDispatcherServletInitializer#getServletMappings ()
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }
}
