#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.${artifactId}.domain.Sample;
import ${package}.${artifactId}.repository.SampleRepository;

@Service
public class SampleServiceImpl implements SampleService {


  private SampleRepository ${artifactId}Repository;

  @Autowired
  public SampleServiceImpl(SampleRepository ${artifactId}Repository) {
    this.${artifactId}Repository = ${artifactId}Repository;
  }


  @Override
  public String getServiceName() {
    return this.getClass().getName();
  }


  @Override
  public Iterable<Sample> findAll() {
    return (Collection<Sample>) this.${artifactId}Repository.findAll();
  }

}
