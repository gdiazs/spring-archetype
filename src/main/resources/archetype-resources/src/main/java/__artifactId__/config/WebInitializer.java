#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ${package}.${artifactId}.RootConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.support.
   * AbstractDispatcherServletInitializer${symbol_pound}onStartup(javax.servlet. ServletContext)
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
   * AbstractAnnotationConfigDispatcherServletInitializer${symbol_pound} getRootConfigClasses()
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
   * AbstractAnnotationConfigDispatcherServletInitializer${symbol_pound} getServletConfigClasses()
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
   * AbstractDispatcherServletInitializer${symbol_pound}getServletMappings ()
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }
}
