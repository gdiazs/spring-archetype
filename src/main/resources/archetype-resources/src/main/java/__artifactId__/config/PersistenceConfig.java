#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ${package}.${artifactId}.domain.DomainLayer;
import ${package}.${artifactId}.repository.RootRepositoryConfig;

@Profile("prod")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {RootRepositoryConfig.class})
@PropertySource("classpath:application.properties")
public class PersistenceConfig {
  
  @Autowired
  private Environment env;
  
  
  
  private static final String JNDI = "datasource.jndi-name";

  /**
   * Crea un datasource en archivo plano. El la base de datos que genera, es un archivo en
   * directorio ~/.mocker
   * 
   * @return DataSource Una instancia de H2 DB en memoria
   * @throws SQLException
   */
  @Bean
  public DataSource dataSource() throws SQLException {
    JndiDataSourceLookup lookup = new JndiDataSourceLookup();
    return lookup.getDataSource(env.getProperty(JNDI));
  }



  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPersistenceUnitName("default");
    em.setPackagesToScan(new String[] {DomainLayer.class.getPackage().getName()});
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    em.setJpaProperties(additionalProperties());
    return em;
  }

  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    return properties;
  }

  @Bean
  public JpaTransactionManager transactionManager() throws SQLException {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

}
