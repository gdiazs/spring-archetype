#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ${package}.${artifactId}.domain.Sample;

@Repository
public interface SampleRepository extends CrudRepository<Sample, Long> {

}
