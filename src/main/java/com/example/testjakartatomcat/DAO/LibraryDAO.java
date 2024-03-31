/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.DAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.testjakartatomcat.Model.Library;

import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class LibraryDAO {
    Connection connect;
    
    public LibraryDAO(Connection connect){
        this.connect = connect;
    }
    public ArrayList<Library> selectAll(){
        PreparedStatement state;
        ArrayList<Library>list = new ArrayList<Library>();
        try{
            state = connect.prepareStatement("select * from library");
            ResultSet result = state.executeQuery();
            while (result.next()){
                Library lib = new Library();
                lib.setGame_id(result.getInt("game_id"));
                lib.setActivity(result.getFloat("activity"));
                lib.setPurchare_date(result.getString("purchare_date"));
                lib.setUser_id(result.getInt("user_id"));
                list.add(lib);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Library getLibrary(int game_id, int user_id){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("select * from library where game_id=? and user_id=?");
            state.setInt(1, game_id);
            state.setInt(2, user_id);
            ResultSet result = state.executeQuery();
            Library library = new Library();
            if(result.next()){
                library.setGame_id(result.getInt("game_id"));
                library.setActivity(result.getFloat("activity"));
                library.setPurchare_date(result.getString("purchare_date"));
                library.setUser_id(result.getInt("user_id"));
                return library;
            }
        }
        catch (SQLException ex){
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void delete(int game_id, int user_id){
        PreparedStatement state;
        try{
            if(getLibrary(game_id,user_id)==null) return;
            state = connect.prepareStatement("delete from library where game_id=? and user_id=?");
            state.setInt(1, game_id);
            state.setInt(2, user_id);
            state.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(Library library){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("insert into library (game_id,user_id,purchare_date, activity) values (?,?,?,?)");
            state.setInt(1,library.getGame_id());
            state.setInt(2,library.getUser_id());
            state.setTimestamp(3, Timestamp.valueOf(library.getPurchare_date()));
            state.setFloat(4,library.getActivity());
            state.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void redact(Library library){
        PreparedStatement state;
        try{
            state = connect.prepareStatement("update library set activity =? , purchare_date =? where game_id=? and user_id=?");
            state.setFloat(1,library.getActivity());
            state.setTimestamp(2,Timestamp.valueOf(library.getPurchare_date()));
            state.setInt(3, library.getGame_id());
            state.setInt(4, library.getUser_id());
            state.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getNumsGames(int user_id){
        PreparedStatement state;
        int x = 0;
        try{
            state = connect.prepareStatement("select * from library where user_id =?");
            state.setInt(1,user_id);
            ResultSet result = state.executeQuery();
            while (result.next()){
                Library lib = new Library();
                lib.setGame_id(result.getInt("game_id"));
                lib.setActivity(result.getFloat("activity"));
                lib.setPurchare_date(result.getString("purchare_date"));
                lib.setUser_id(result.getInt("user_id"));
                x++;
            }
            return x;
        }
        catch(SQLException ex){
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getNumsUsers(int game_id){
        PreparedStatement state;
        int x = 0;
        try{
            state = connect.prepareStatement("select * from library where game_id =?");
            state.setInt(1,game_id);
            ResultSet result = state.executeQuery();
            while (result.next()){
                Library lib = new Library();
                lib.setGame_id(result.getInt("game_id"));
                lib.setActivity(result.getFloat("activity"));
                lib.setPurchare_date(result.getString("purchare_date"));
                lib.setUser_id(result.getInt("user_id"));
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
