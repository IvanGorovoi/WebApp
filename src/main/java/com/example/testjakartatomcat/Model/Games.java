/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.Model;

/**
 *
 * @author Lenovo
 */
public class Games{

    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
    private int id;
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    private String title;
    public void setTitle(String title){this.title = title;}
    public String getTitle(){return title;}

    private String developer;
    public void setDeveloper(String developer){this.developer = developer;}
    public String getDeveloper(){return developer;}

    private String publisher;
    public void setPublisher(String publisher){this.publisher = publisher;}
    public String getPublisher(){return publisher;}

    private String about_game;
    public void setAbout_game(String about_game){this.about_game = about_game;}
    public String getAbout_game(){return about_game;}
    
    private int price;
    public void setPrice(int price){this.price = price;}
    public int getPrice(){return this.price;}

    private int category_id;
}