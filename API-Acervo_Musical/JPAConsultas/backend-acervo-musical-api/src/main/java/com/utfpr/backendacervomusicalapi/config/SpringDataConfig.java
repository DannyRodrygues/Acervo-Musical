package com.utfpr.backendacervomusicalapi.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.utfpr.backendacervomusicalapi.repository")
@EnableTransactionManagement
public class SpringDataConfig {

    @Bean
    public DataSource datasource(){
        HikariDataSource ds = new HikariDataSource();

        ds.setUsername("root");
        ds.setPassword("221199");

        ds.setJdbcUrl("jdbc:mariadb://DevDany:3306/acervo_musical");// Substitua pela URL do seu banco de dados MariaDB
        ds.setDriverClassName("org.mariadb.jdbc.Driver");

        return ds;
    }
    @Bean
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);//true usado para banco em memoria
        vendorAdapter.setShowSql(false);//true = mostra o sql gerado. false = nao mostra

        factory.setDataSource(datasource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.utfpr.backendacervomusicalapi.entity");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        manager.setJpaDialect(new HibernateJpaDialect());

        return manager;
    }

}
