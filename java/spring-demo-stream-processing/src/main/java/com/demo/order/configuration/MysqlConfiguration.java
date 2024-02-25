package com.demo.order.configuration;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * The type Mysql configuration.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.demo.order.repository.mysql",
        entityManagerFactoryRef = "rdbEntityManagerFactory", transactionManagerRef = "rdbTransactionManager")
@PropertySource({"classpath:application.properties"})
public class MysqlConfiguration {
    /**
     * The Driver class name.
     */
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    /**
     * The Url.
     */
    @Value("${spring.datasource.url}")
    private String url;

    /**
     * The Username.
     */
    @Value("${spring.datasource.username}")
    private String username;


    /**
     * The Password.
     */
    @Value("${spring.datasource.password}")
    private String password;

    /**
     * The Driver.
     */
    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    /**
     * The Dialect.
     */
    @Value("${spring.jpa.database-platform}")
    private String dialect;

    /**
     * The Ddl auto.
     */
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    /**
     * The Entity packages.
     */
    @Value("${spring.entityPackages}")
    private String entityPackages;

    /**
     * Rdb datasource data source.
     *
     * @return the data source
     */
    @Primary
    @Bean
    public DataSource rdbDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * Rdb entity manager factory local container entity manager factory bean.
     *
     * @return the local container entity manager factory bean
     */
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean rdbEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(rdbDatasource());
        entityManagerFactory.setPackagesToScan(entityPackages);
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaPropertyMap(
                new ImmutableMap.Builder<String, Object>()
                        .put("hibernate.dialect", dialect)
                        .put("hibernate.hbm2ddl.auto", ddlAuto).build());
        return entityManagerFactory;
    }

    /**
     * Rdb transaction manager platform transaction manager.
     *
     * @return the platform transaction manager
     */
    @Primary
    @Bean
    public PlatformTransactionManager rdbTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(rdbEntityManagerFactory().getObject());
        return transactionManager;
    }
}
