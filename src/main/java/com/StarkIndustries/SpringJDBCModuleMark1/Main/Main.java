package com.StarkIndustries.SpringJDBCModuleMark1.Main;

import com.StarkIndustries.SpringJDBCModuleMark1.DataAcessObject.DataAcessObject;
import com.StarkIndustries.SpringJDBCModuleMark1.Model.Customer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        DataAcessObject dataAcessObject = new DataAcessObject();

        // Insert Query:
        var conetxt = new ClassPathXmlApplicationContext("com/StarkIndustries/SpringJDBCModuleMark1/Configurations/JdbcConfiguration.xml");
        Customer customer = new Customer(30,"Aditya",22,"8591059220","Indian");
        conetxt.getBean(DataAcessObject.class).insertEntity(customer);
//        if(dataAcessObject.insertEntity(customer)==1)
//            System.out.println("Customer Added Successfully");
//        else
//            System.out.println("Failed to Add Customer to Database");




    }
}
