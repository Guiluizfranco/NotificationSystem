/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.dao;

import com.mycompany.notification.system.api.database.Connection_DB;
import com.mycompany.notification.system.api.model.Notification;
import com.mycompany.notificationsystem.api.dto.NotificationDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guil_dev
 */
public class NotificationDAO {
    
    Connection_DB conn = new Connection_DB();
    Connection con = conn.getConnection();
    Notification notification = new Notification();
    
    public void CreateNotification(Notification notification){
        
        String sql = "INSERT INTO Notification (titulo, mensagem, lida, sender_id, receiver_id) VALUES (?, ?, ?, ?, ?)";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, notification.getTitle());
            ps.setString(2, notification.getMessage());
            ps.setBoolean(3, false);
            ps.setInt(4, notification.getSenderID());
            ps.setInt(5, notification.getReceiverID());
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            
            
        }
        
    }
    
    public boolean SearchSenderID(NotificationDTO dto){
        
        String sql = "SELECT * FROM Users WHERE id = ?";
        
        try{
            
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, dto.getSenderID());
          ResultSet rs = ps.executeQuery();
            
          return rs.next();
            
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            return false;
            
        }
        
    }
    
    public boolean SearchReceiverID(NotificationDTO dto){
        
        String sql = "SELECT * FROM Users WHERE id = ?";
        
        try{
            
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, dto.getReceiverID());
          ResultSet rs = ps.executeQuery();
          
            
          return rs.next();
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            return false;
            
        }
        
    }
    
}
