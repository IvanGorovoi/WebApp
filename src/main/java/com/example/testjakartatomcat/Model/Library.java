/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.Model;


/**
 *
 * @author Lenovo
 */
public class Library {

    public int getGame_id() {
        return game_id;
    }
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getPurchare_date() {
        return purchare_date;
    }
    public void setPurchare_date(String purchare_date) {
        this.purchare_date = purchare_date;
    }

    public float getActivity() {
        return activity;
    }
    public void setActivity(float activity) {
        this.activity = activity;
    }
    
    private int user_id;

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    private String purchare_date;
    private float activity;
    private int game_id;
}
