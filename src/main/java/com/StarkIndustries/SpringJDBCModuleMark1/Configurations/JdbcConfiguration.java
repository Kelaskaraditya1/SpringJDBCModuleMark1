package com.StarkIndustries.SpringJDBCModuleMark1.Configurations;
import com.StarkIndustries.SpringJDBCModuleMark1.DataAcessObject.DataAcessObject;
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
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Keys.JDBC_DRIVER);
        dataSource.setUrl(Keys.DATABASE_URL);
        dataSource.setUsername(Keys.USERNAME);
        dataSource.setPassword(Keys.PASSWORD);
        return dataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DriverManagerDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean(name = "dataAccessObject")
    public DataAcessObject getDataAccessObject(JdbcTemplate jdbcTemplate){
        DataAcessObject dataAcessObject = new DataAcessObject();
        dataAcessObject.setJdbcTemplate(jdbcTemplate);
        return dataAcessObject;
    }
}
