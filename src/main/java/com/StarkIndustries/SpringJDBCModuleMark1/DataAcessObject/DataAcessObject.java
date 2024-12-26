package com.StarkIndustries.SpringJDBCModuleMark1.DataAcessObject;

import com.StarkIndustries.SpringJDBCModuleMark1.Configurations.JdbcConfiguration;
import com.StarkIndustries.SpringJDBCModuleMark1.Keys.Keys;
import com.StarkIndustries.SpringJDBCModuleMark1.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataAcessObject implements EntityDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DataAcessObject(){

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Using XMl Configurations

    public JdbcTemplate getJdbcTemplate(){
         var context = new ClassPathXmlApplicationContext("com/StarkIndustries/SpringJDBCModuleMark1/Configurations/JdbcConfiguration.xml");
         return context.getBean(JdbcTemplate.class);
    }

//    public static JdbcTemplate getJdbcTemplate(){
//        var context = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
//        return context.getBean(JdbcTemplate.class);
//    }

    @Override
    public int insertEntity(Customer customer){
        return jdbcTemplate.update(Keys.INSERT_QUERY,customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAge(),customer.getCustomerContact(),customer.getCustomerNationality());
    }
}
