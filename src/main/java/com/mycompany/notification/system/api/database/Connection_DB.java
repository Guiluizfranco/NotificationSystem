/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guil_dev
 */
public class Connection_DB {
    
    public Connection getConnection(){
     
        String url = "jdbc:mysql://localhost:3306/NotificationSystem";
        String user = "root";
        String senha = "root";

        try{
            
         Connection con = DriverManager.getConnection(url, user, senha);
         return con;
            
        }catch(SQLException e){
            
          e.getMessage();
          return null;
            
        }
    }
    
    
    
}
