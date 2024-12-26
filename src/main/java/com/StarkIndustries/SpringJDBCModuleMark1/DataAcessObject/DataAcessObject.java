package com.StarkIndustries.SpringJDBCModuleMark1.DataAcessObject;

import com.StarkIndustries.SpringJDBCModuleMark1.Configurations.JdbcConfiguration;
import com.StarkIndustries.SpringJDBCModuleMark1.Keys.Keys;
import com.StarkIndustries.SpringJDBCModuleMark1.Model.Customer;
import com.StarkIndustries.SpringJDBCModuleMark1.RowMapper.SingleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.rmi.StubNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public int insertQuery(Customer customer){
        return this.jdbcTemplate.update(Keys.INSERT_QUERY,customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAge(),customer.getCustomerContact(),customer.getCustomerNationality());
    }

    @Override
    public int updateQuery(Customer customer) {
        return this.jdbcTemplate.update(Keys.UPDATE_QUERY,customer.getCustomerName(),customer.getCustomerAge(),customer.getCustomerContact(),customer.getCustomerNationality(),customer.getCustomerId());
    }

    @Override
    public int deleteQuery(int customerId) {
        return this.jdbcTemplate.update(Keys.DELETE_QUERY,customerId);
    }

    @Override
    public Customer getCustomerDetail(int customerId) {
        Customer customer = this.getJdbcTemplate().queryForObject(Keys.SINGLE_SELECT_QUERY, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("CustomerId"));
                customer.setCustomerName(resultSet.getString("CustomerName"));
                customer.setCustomerAge(resultSet.getInt("CustomerAge"));
                customer.setCustomerContact(resultSet.getString("CustomerContact"));
                customer.setCustomerNationality(resultSet.getString("CustomerNationality"));
                return customer;
            }
        },customerId);
        return customer;
    }


    // Can the pass the Same Row mapper Implementation in Select All Query as well.


    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<Customer>();
        list=this.getJdbcTemplate().query(Keys.SELECT_QUERY,new SingleRowMapper());
        return list;
    }

    // Simple RowMapper Implementation.

//    @Override
//    public Customer getCustomerDetail(int customerId) {
//        RowMapper<Customer> rowMapper = new SingleRowMapper();
//        Customer customer = this.getJdbcTemplate().queryForObject(Keys.SINGLE_SELECT_QUERY,rowMapper,customerId);
//        return customer;
//    }

    // Retriving single customer with , RowMapper Implementation by Anonymous Class.


}
