package com.StarkIndustries.SpringJDBCModuleMark1.Keys;

public class Keys {
    public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL="jdbc:mysql://localhost:3306/grocery";
    public static final String USERNAME="root";
    public static final String PASSWORD="9819375722Aditya";
    public static final String INSERT_QUERY="insert into customer values(?,?,?,?,?)";
    public static final String UPDATE_QUERY="update customer set CustomerName = ?,CustomerAge=?,CustomerContact=?,CustomerNationality=? where CustomerId=?";
    public static final String DELETE_QUERY="delete from customer where CustomerId=?";
    public static final String SINGLE_SELECT_QUERY="select * from customer where CustomerId=?";
    public static final String SELECT_QUERY="select * from customer";
}
