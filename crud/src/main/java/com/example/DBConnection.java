package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static final String url = "jdbc:sqlite:app.db";
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
