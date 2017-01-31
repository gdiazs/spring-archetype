#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
    @Filter(type = FilterType.ANNOTATION, value = Controller.class),
    @Filter(type = FilterType.ANNOTATION, value = RestController.class)})
public class RootConfig {

}
