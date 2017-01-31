#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.service;

import ${package}.${artifactId}.domain.Sample;

public interface SampleService {

  public String getServiceName();

  public Iterable<Sample> findAll();
}
