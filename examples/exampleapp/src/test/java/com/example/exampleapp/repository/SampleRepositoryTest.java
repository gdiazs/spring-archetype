package com.example.exampleapp.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.example.exampleapp.config.PersistenceDevConfig;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceDevConfig.class,
    loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("dev")
public class SampleRepositoryTest {

  @Autowired
  private SampleRepository exampleappRepository;

  @Test
  public void exampleappRepositoryIsNotNull() {
    Assert.assertNotNull(exampleappRepository);
  }

  @Test
  public void testIterateAll() {
    exampleappRepository.findAll().forEach((exampleapp) -> {
      System.out.println(exampleapp);
    });
  }

}
