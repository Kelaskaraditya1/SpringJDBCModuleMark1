package com.StarkIndustries.SpringJDBCModuleMark1.DataAcessObject;

import com.StarkIndustries.SpringJDBCModuleMark1.Model.Customer;

import java.util.List;

public interface EntityDao {
    public int insertQuery(Customer customer);
    public int updateQuery(Customer customer);
    public int deleteQuery(int customerId);
    public Customer getCustomerDetail(int customerId);
    public List<Customer> getAllCustomers();
}
