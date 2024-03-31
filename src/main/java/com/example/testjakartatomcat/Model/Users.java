/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testjakartatomcat.Model;

public class Users{
    private int id;
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    private String registration_date; //?
    public void setRegistration_date(String registration_date){this.registration_date = registration_date;}
    public String getRegistration_date(){return registration_date;}

    private boolean extra_guard;
    public void setExtra_guard(boolean extra_guard){this.extra_guard = extra_guard;}
    public boolean getExtra_guard(){return extra_guard;}
    
    private String nickname;
    public void setNickname(String nickname){this.nickname = nickname;}
    public String getNickname(){return nickname;}

    private String native_country;
    public void setNative_country(String native_country){this.native_country = native_country;}
    public String getNative_country(){return native_country;}

    private float balance;
    public void setBalance(float balance){this.balance = balance;}
    public float getBalance(){return balance;}
}