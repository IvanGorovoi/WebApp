/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.DBSQL;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Lenovo
 */
public class DBConnect {
    private Connection con = null;
    public Connection getCon() {
        return con;
    }
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/steem", "root", "Connect11");
            return con;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return con;
        }
    } 
}
