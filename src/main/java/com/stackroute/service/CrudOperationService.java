package com.stackroute.service;

import com.stackroute.domain.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudOperationService {
    List <Customer> list= new ArrayList<>();

    private Connection con;
    public void displayData() {
        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","Root@123");
            //create statement object
            System.out.println("got connected");

            Statement stmt=con.createStatement();


            //execute query
            ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));

        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Customer> displayCustomerByName(String name) {
//
//        List<Customer> customerList=new ArrayList<Customer>();


        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/customerdb","root","Root@123");
            //create statement object
            System.out.println("got connected");

            PreparedStatement stmt=con.prepareStatement("Select * from customers where name=?");

            stmt.setString(1,name);
            //stmt.setInt(2,age);
            ResultSet rs = stmt.executeQuery();
            //execute query
            //  ResultSet rs=stmt.executeQuery("select * from customers");
            //process result
            while(rs.next()) {
                Customer customer = null;
                customer.setAge(rs.getInt("age"));
                customer.setGender(rs.getString("gender"));
                customer.setName(rs.getString("name"));
                this.list.add(customer);
//                System.out.println(rs.getInt(1) + " " + rs.getString(2) + "  " + rs.getString(3));
            }
        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public void insertCustomer(int id, String name) {

        //PreparedStatement
    }
}
