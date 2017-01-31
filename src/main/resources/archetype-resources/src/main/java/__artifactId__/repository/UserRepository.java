#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ${package}.${artifactId}.domain.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  public User findUserByUsername(String userName);
}
