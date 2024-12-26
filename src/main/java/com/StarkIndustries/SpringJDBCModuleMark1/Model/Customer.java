package com.StarkIndustries.SpringJDBCModuleMark1.Model;

public class Customer  {
    private int customerId;
    private String customerName;
    private int customerAge;
    private String customerContact;
    private String customerNationality;

    public Customer(int customerId,String customerName,int customerAge,String customerContact,String customerNationality){
        this.customerId=customerId;
        this.customerName=customerName;
        this.customerAge=customerAge;
        this.customerContact=customerContact;
        this.customerNationality=customerNationality;
    }

    public Customer(){

    }

    public Customer(String customerName,int customerAge,String customerContact,String customerNationality){
        this.customerName=customerName;
        this.customerAge=customerAge;
        this.customerContact=customerContact;
        this.customerNationality=customerNationality;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerNationality() {
        return customerNationality;
    }

    public void setCustomerNationality(String customerNationality) {
        this.customerNationality = customerNationality;
    }

    @Override
    public String toString() {
        return "customerId: "+this.getCustomerId()+"\ncustomerName: "+this.getCustomerName()+"\ncustomerContact: "+this.getCustomerContact()+"\ncustomerAge: "+this.getCustomerAge()+"\ncustomerNationality: "+this.getCustomerNationality();
    }
}
