/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.DAO;

import com.example.testjakartatomcat.Model.Users;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class UsersDAO {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    Connection connect;

    public UsersDAO(Connection connect) {
        this.connect = connect;
    }

    public ArrayList<Users> selectAll() {
        PreparedStatement state;
        ArrayList<Users> list = new ArrayList<Users>();
        try {
            state = connect.prepareStatement("select * from users");
            ResultSet result = state.executeQuery();
            while (result.next()) {
                Users user = new Users();
                user.setId(result.getInt("id"));
                user.setRegistration_date(result.getString("registration_date"));
                user.setBalance(result.getFloat("balance"));
                user.setNickname(result.getString("nickname"));
                user.setNative_country(result.getString("native_country"));
                user.setExtra_guard(result.getBoolean("extra_guard"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Users getUser(int id){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("select * from users where id=?");
            state.setInt(1, id);
            ResultSet result = state.executeQuery();
            Users user = new Users();
            if(result.next()){
                user.setId(result.getInt("id"));
                user.setRegistration_date(result.getString("registration_date"));
                user.setBalance(result.getFloat("balance"));
                user.setNickname(result.getString("nickname"));
                user.setNative_country(result.getString("native_country"));
                user.setExtra_guard(result.getBoolean("extra_guard"));
            }
            return user;
        }
        catch (SQLException ex){
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void delete(int id){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("delete from users where id=?");
            state.setInt(1, id);
            state.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(Users user){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("insert into users (nickname,balance,registration_date, native_country,extra_guard) values (?,?,?,?,?)");
            state.setString(1,user.getNickname());
            state.setFloat(2,user.getBalance());
            state.setTimestamp(3, Timestamp.valueOf(LocalDateTime.parse(user.getRegistration_date(), formatter)));
            state.setString(4,user.getNative_country());
            state.setBoolean(5,user.getExtra_guard());
            state.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void redact(Users user){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("update users set nickname=?,balance=?,registration_date=?, native_country=?,extra_guard=? where id=?");
            Timestamp ts = Timestamp.valueOf(user.getRegistration_date());
            state.setString(1,user.getNickname());
            state.setFloat(2,user.getBalance());
            state.setTimestamp(3, Timestamp.valueOf(LocalDateTime.parse(user.getRegistration_date(), formatter)));
            state.setString(4,user.getNative_country());
            state.setBoolean(5,user.getExtra_guard());
            state.setInt(6, user.getId());
            state.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
