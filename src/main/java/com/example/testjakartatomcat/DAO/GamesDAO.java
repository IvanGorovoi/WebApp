/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.DAO;
import com.example.testjakartatomcat.Model.Games;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class GamesDAO {
    Connection connect;
    
    public GamesDAO(Connection connect){
        this.connect = connect;
    }
    
    public ArrayList<Games> selectAll(){
        PreparedStatement state;
        ArrayList<Games> list = new ArrayList<Games>();
        try{
            state = connect.prepareStatement("select * from games");
            ResultSet result = state.executeQuery();
            while(result.next()){
                Games game = new Games();
                game.setId(result.getInt("id"));
                game.setPrice(result.getInt("price"));
                game.setCategory_id(result.getInt("category_id"));
                game.setDeveloper(result.getString("developer"));
                game.setPublisher(result.getString("publisher"));
                game.setTitle(result.getString("title"));
                game.setAbout_game(result.getString("about_game"));
                list.add(game);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(GamesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Games getGame(int id){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("select * from games where id=?");
            state.setInt(1, id);
            ResultSet result = state.executeQuery();
            Games game = new Games();
            if(result.next()){
                game.setId(result.getInt("id"));
                game.setPrice(result.getInt("price"));
                game.setCategory_id(result.getInt("category_id"));
                game.setDeveloper(result.getString("developer"));
                game.setPublisher(result.getString("publisher"));
                game.setTitle(result.getString("title"));
                game.setAbout_game(result.getString("about_game"));
                return game;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(GamesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void insert(Games game){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("insert into games (title, price,category_id,publisher,developer,about_game) values (?,?,?,?,?,?)");
            state.setString(1, game.getTitle());
            state.setInt(2,game.getPrice());
            state.setInt(3,game.getCategory_id());
            state.setString(4, game.getPublisher());
            state.setString(5, game.getDeveloper());
            state.setString(6, game.getAbout_game());
            state.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(GamesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(int id){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("delete from games where id=?");
            state.setInt(1, id);
            state.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(GamesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void redact(Games game){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("update games set title = ?, price= ?,category_id= ?,publisher= ?,developer= ?,about_game= ? where id=?");
            state.setString(1, game.getTitle());
            state.setInt(2,game.getPrice());
            state.setInt(3,game.getCategory_id());
            state.setString(4, game.getPublisher());
            state.setString(5, game.getDeveloper());
            state.setString(6, game.getAbout_game());
            state.setInt(7,game.getId());
            state.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(GamesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getNumsCategory(int category_id){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("select * from games where category_id =?");
            state.setInt(1,category_id);
            ResultSet result = state.executeQuery();
            int x = 0;
            while (result.next()){
                Games game = new Games();
                game.setId(result.getInt("id"));
                game.setCategory_id(result.getInt("category_id"));
                x++;
            }
            return x;
        }
        catch(SQLException ex){
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
