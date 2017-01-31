#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import ${package}.${artifactId}.config.PersistenceDevConfig;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceDevConfig.class,
    loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("dev")
public class SampleRepositoryTest {

  @Autowired
  private SampleRepository ${artifactId}Repository;

  @Test
  public void ${artifactId}RepositoryIsNotNull() {
    Assert.assertNotNull(${artifactId}Repository);
  }

  @Test
  public void testIterateAll() {
    ${artifactId}Repository.findAll().forEach((${artifactId}) -> {
      System.out.println(${artifactId});
    });
  }

}
