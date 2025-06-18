package com.pluralsight.NorthwindTradersAPI.configurations;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
public class DbConfiguration {

    private BasicDataSource dataSource;

    @Bean
    public DataSource dataSource() {
        return this.dataSource;
    }

    public DbConfiguration(@Value("${datasource.url}") String url,
                           @Value("${datasource.username}") String username,
                           @Value("${datasource.password}") String password
    ) {
        dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }
}
