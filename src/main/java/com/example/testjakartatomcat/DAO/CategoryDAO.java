 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.DAO;
import com.example.testjakartatomcat.Model.Category;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class CategoryDAO {
    Connection connect;

    public CategoryDAO(Connection connect) {
        this.connect = connect;
    }
    
    public ArrayList<Category> selectAll(){
        PreparedStatement state;
        ArrayList<Category> list = new ArrayList<Category>();
        try{
            state = connect.prepareStatement("select * from category");
            ResultSet result = state.executeQuery();
            while(result.next()){
                Category category = new Category();
                category.setId(result.getInt("id"));
                category.setMultiplayer(result.getBoolean("multiplayer"));
                category.setSingleplayer(result.getBoolean("singleplayer"));
                category.setNot_for_all(result.getBoolean("not_for_all"));
                category.setTitle(result.getString("title"));
                list.add(category);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Category getCategory(int id){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("select * from category where id=?");
            state.setInt(1, id);
            ResultSet result = state.executeQuery();
            Category category = new Category();
            if(result.next()){
                category.setId(result.getInt("id"));
                category.setTitle(result.getString("title"));
                category.setMultiplayer(result.getBoolean("multiplayer"));
                category.setNot_for_all(result.getBoolean("not_for_all"));
                category.setSingleplayer(result.getBoolean("singleplayer"));
                return category;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void delete(int id){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("delete from category where id=?");
            state.setInt(1, id);
            state.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void redact(Category category){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("update category set title = ?, not_for_all= ?,singleplayer= ?,multiplayer= ? where id=?");
            state.setString(1, category.getTitle());
            state.setBoolean(2,category.getNot_for_all());
            state.setBoolean(3,category.getSingleplayer());
            state.setBoolean(4, category.getMultiplayer());
            state.setInt(5, category.getId());
            state.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(Category category){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("insert into category (title,not_for_all,singleplayer, multiplayer) values (?,?,?,?)");
            state.setString(1, category.getTitle());
            state.setBoolean(2,category.getNot_for_all());
            state.setBoolean(3,category.getSingleplayer());
            state.setBoolean(4, category.getMultiplayer());
            state.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
