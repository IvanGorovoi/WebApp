/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.View;

import com.example.testjakartatomcat.DAO.GamesDAO;
import com.example.testjakartatomcat.DAO.UsersDAO;
import com.example.testjakartatomcat.DBSQL.DBConnect;
import com.example.testjakartatomcat.Model.Games;
import com.example.testjakartatomcat.Model.Users;

import java.util.ArrayList;
/**
 *
 * @author Lenovo               
 */
public class Main {
    public static void main(String args[]){
        DBConnect con = new DBConnect();
        if (con.connect() != null) {
            System.out.println("Nice");
        }
    }
}
