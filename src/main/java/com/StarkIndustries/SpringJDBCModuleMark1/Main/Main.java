package com.StarkIndustries.SpringJDBCModuleMark1.Main;

import com.StarkIndustries.SpringJDBCModuleMark1.Configurations.JdbcConfiguration;
import com.StarkIndustries.SpringJDBCModuleMark1.DataAcessObject.DataAcessObject;
import com.StarkIndustries.SpringJDBCModuleMark1.Model.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

//        var conetxt = new ClassPathXmlApplicationContext("com/StarkIndustries/SpringJDBCModuleMark1/Configurations/JdbcConfiguration.xml");
//        DataAcessObject dataAcessObject =(DataAcessObject) conetxt.getBean(DataAcessObject.class);

        var context = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
        DataAcessObject dataAcessObject = context.getBean(DataAcessObject.class);

        // Insert Query:

//        Customer customer = new Customer(29,"Saurav",22,"9845654565","Indian");
//        dataAcessObject.insertQuery(customer);

        // Update Query:

//        Customer customer = new Customer(30,"Aditya",22,"8591059220","Indian");
//        dataAcessObject.updateQuery(customer);

        // Delete Query:

//        System.out.println("Enter the CustomerId of the Customer to be deleted");
//        int customerId=s.nextInt();
//        dataAcessObject.deleteQuery(customerId);

        // Single Customer Query:

//        Customer customer = dataAcessObject.getCustomerDetail(30);
//        System.out.println(customer);

        // getting List of Customers.

        List<Customer> list = dataAcessObject.getAllCustomers();
        list.stream().forEach(value->{
            System.out.println(value);;
        });



    }
}
