package com.pluralsight.NorthwindTradersSpringBoot;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    BasicDataSource ds;

    public DatabaseConfiguration(@Value("${spring.datasource.url}") String url,
                                 @Value("${spring.datasource.user}") String user,
                                 @Value("${spring.datasource.pass}") String pass) {
        ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(pass);
    }

    @Bean
    DataSource getDatasource(){
        return ds;
    }
}
