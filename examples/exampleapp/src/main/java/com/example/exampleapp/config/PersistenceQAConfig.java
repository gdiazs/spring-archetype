package com.example.exampleapp.config;

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
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.exampleapp.domain.DomainLayer;
import com.example.exampleapp.repository.RootRepositoryConfig;

@Profile("qa")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {RootRepositoryConfig.class})
@PropertySource("classpath:application.properties")
public class PersistenceQAConfig {


  private static final String DATASOURCE_PASSWORD = "datasource.password";

  private static final String DATASOURCE_USERNAME = "datasource.username";

  private static final String DATASOURCE_URL = "datasource.url";

  private static final String DATASOURCE_DRIVER = "datasource.driver";
  
  @Autowired
  private Environment env;

  /**
   * Crea un datasource en archivo plano. El la base de datos que genera, es un archivo en
   * directorio ~/.mocker
   * 
   * @return DataSource Una instancia de H2 DB en memoria
   * @throws SQLException
   */
  @Bean
  public DataSource dataSource() throws SQLException {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setDriverClassName(env.getProperty(DATASOURCE_DRIVER));
    dataSource.setUrl(env.getProperty(DATASOURCE_URL));
    dataSource.setUsername(env.getProperty(DATASOURCE_USERNAME));
    dataSource.setPassword(env.getProperty(DATASOURCE_PASSWORD));
    return dataSource;
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
