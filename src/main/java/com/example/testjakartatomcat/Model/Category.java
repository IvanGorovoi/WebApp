/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.Model;

/**
 *
 * @author Lenovo
 */
public class Category{
    private int id;
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    private String title;
    public void setTitle(String title){this.title = title;}
    public String getTitle(){return title;}

    private boolean singleplayer;
    public void setSingleplayer(boolean singleplayer){this.singleplayer = singleplayer;}
    public boolean getSingleplayer(){return singleplayer;}

    private boolean multiplayer;
    public void setMultiplayer(boolean multiplayer){this.multiplayer = multiplayer;}
    public boolean getMultiplayer(){return multiplayer;}

    private boolean not_for_all;
    public void setNot_for_all(boolean not_for_all){this.not_for_all = not_for_all;}
    public boolean getNot_for_all(){return not_for_all;}
}