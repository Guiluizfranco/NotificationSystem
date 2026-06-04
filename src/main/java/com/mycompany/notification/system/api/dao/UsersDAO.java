/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.dao;

import com.mycompany.notification.system.api.database.Connection_DB;
import com.mycompany.notificationsystem.api.dto.ValidationUser;
import com.mycompany.notificationsystem.api.dto.UserDTO;
import com.mycompany.notification.system.api.model.User;
import java.sql.*;

/**
 *
 * @author guil_dev
 */
public class UsersDAO {
    
    Connection_DB connection = new Connection_DB(); 
    Connection con = connection.getConnection();    

    
    public boolean SearchUsers(UserDTO user){
        
        String sql = "SELECT email FROM Users WHERE email = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
            
        }catch(SQLException e){
         
            return false;
            
        }
        
        

    }
    
    public boolean CreateUsers(User user){
        
        String sql =  "INSERT INTO Users (nome, email, senha) VALUES (?, ?, ?)";
        
        boolean validation = true;
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            
            ps.executeUpdate();
            
            ps.close();
            

        }catch(SQLException e){
            
            validation = false;
       
        }
        
        return validation;
        
    }
    
    public boolean SearchSenderIDUsers(int id){
        
        String sql = "SELECT * FROM Users WHERE id = ?";
        
        try{
            
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, id);
          ResultSet rs = ps.executeQuery();
            
          return rs.next();
            
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            return false;
            
        }
        
    }
    
    public boolean SearchReceiverIDUsers(int id){
        
        String sql = "SELECT * FROM Users WHERE id = ?";
        
        try{
            
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, id);
          ResultSet rs = ps.executeQuery();
          
            
          return rs.next();
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            return false;
            
        }
        
    }
    
}
