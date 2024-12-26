package com.StarkIndustries.SpringJDBCModuleMark1.Configurations;
import com.StarkIndustries.SpringJDBCModuleMark1.Keys.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class JdbcConfiguration {

    @Bean(name = "dataSource")
    public DriverManagerDataSource getDatasource(){
        return new DriverManagerDataSource(Keys.DATABASE_URL,Keys.USERNAME,Keys.PASSWORD);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DriverManagerDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
