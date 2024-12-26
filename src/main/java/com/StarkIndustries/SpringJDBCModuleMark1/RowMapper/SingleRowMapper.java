package com.StarkIndustries.SpringJDBCModuleMark1.RowMapper;

import com.StarkIndustries.SpringJDBCModuleMark1.Model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SingleRowMapper implements RowMapper<Customer> {
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
}
