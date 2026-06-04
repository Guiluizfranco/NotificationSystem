/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.dao;

import com.mycompany.notification.system.api.database.Connection_DB;
import com.mycompany.notification.system.api.model.Notification;
import com.mycompany.notificationsystem.api.dto.NotificationDTO;
import com.mycompany.notificationsystem.api.dto.NotificationListResponseDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guil_dev
 */
public class NotificationDAO {
    
    Connection_DB conn = new Connection_DB();
    Connection con = conn.getConnection();
    
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
    
    public List SearchAllNotification(List<Notification> list){
        
        String sql = "SELECT * FROM Notification";
        
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Notification notification = new Notification();
                
                notification.setId(rs.getInt("id"));
                notification.setTitle(rs.getString("titulo"));
                notification.setMessage(rs.getString("mensagem"));
                notification.setRead(rs.getBoolean("lida"));
                notification.setSenderID(rs.getInt("sender_id"));
                notification.setReceiverID(rs.getInt("receiver_id"));
                
                list.add(notification);
                
                
            }
            
            
        }catch(SQLException e){       
            
            
        }
        
        return list;
        
    }
    
    public List SearchNotificationID(List<Notification> list, int id){
        
        String sql = "SELECT * FROM Notification WHERE id = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Notification notification = new Notification();

                notification.setId(rs.getInt("id"));
                notification.setTitle(rs.getString("titulo"));
                notification.setMessage(rs.getString("mensagem"));
                notification.setRead(rs.getBoolean("lida"));
                notification.setSenderID(rs.getInt("sender_id"));
                notification.setReceiverID(rs.getInt("receiver_id"));
                
                list.add(notification);
                
                
            }
            
            
        }catch(SQLException e){       
            
            
        }
        
        return list;
        
    }
    
    public List SearchNotificationSenderID(List<Notification> list, int sender_id){
        
        String sql = "SELECT * FROM Notification WHERE sender_id = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sender_id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Notification notification = new Notification();
                
                notification.setId(rs.getInt("id"));
                notification.setTitle(rs.getString("titulo"));
                notification.setMessage(rs.getString("mensagem"));
                notification.setRead(rs.getBoolean("lida"));
                notification.setSenderID(rs.getInt("sender_id"));
                notification.setReceiverID(rs.getInt("receiver_id"));
                
                list.add(notification);
                
                
            }
            
            
        }catch(SQLException e){       
            
            
        }
        
        return list;
        
    }
    
    public List SearchNotificationReceiverID(List<Notification> list, int receiver_id){
        
        String sql = "SELECT * FROM Notification WHERE receiver_id = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, receiver_id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Notification notification = new Notification();
                
                notification.setId(rs.getInt("id"));
                notification.setTitle(rs.getString("titulo"));
                notification.setMessage(rs.getString("mensagem"));
                notification.setRead(rs.getBoolean("lida"));
                notification.setSenderID(rs.getInt("sender_id"));
                notification.setReceiverID(rs.getInt("receiver_id"));
                
                list.add(notification);
                
                
            }
            
            
        }catch(SQLException e){       
            
            
        }
        
        return list;
        
    }
    
    public List SearchNotificationTitle(List<Notification> list, String title){
        
        String sql = "SELECT * FROM Notification WHERE titulo = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Notification notification = new Notification();
                
                notification.setId(rs.getInt("id"));
                notification.setTitle(rs.getString("titulo"));
                notification.setMessage(rs.getString("mensagem"));
                notification.setRead(rs.getBoolean("lida"));
                notification.setSenderID(rs.getInt("sender_id"));
                notification.setReceiverID(rs.getInt("receiver_id"));
                
                list.add(notification);
                
                
            }
            
            
        }catch(SQLException e){       
            
            
        }
        
        return list;
        
    }
    
    public List SearchNotificationRead(List<Notification> list, Boolean read){
        
        String sql = "SELECT * FROM Notification WHERE lida = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, read);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Notification notification = new Notification();
                
                notification.setId(rs.getInt("id"));
                notification.setTitle(rs.getString("titulo"));
                notification.setMessage(rs.getString("mensagem"));
                notification.setRead(rs.getBoolean("lida"));
                notification.setSenderID(rs.getInt("sender_id"));
                notification.setReceiverID(rs.getInt("receiver_id"));
                
                list.add(notification);
                
                
            }
            
            
        }catch(SQLException e){       
            
            
        }
        
        return list;
        
    }
    
    
    public boolean UpdateNotificationRead(int id){
        
        String sql = "UPDATE Notification SET lida = ? WHERE id = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            
            ps.executeUpdate();
            
            return true;
            
        }catch(SQLException e){
            
            return false;
        }
        
    }
    
    public boolean SearchNotificationID(int id){
        
        String sql = "SELECT * FROM Notification WHERE id = ?";
        
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
    
    public boolean isRead(int id){
        
        String sql = "SELECT lida FROM Notification WHERE id = ?";
        
        Boolean validationRead = null;
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                validationRead = rs.getBoolean("lida");
                
            }
            
            
 
        }catch(SQLException e){
            
            
        }

        return validationRead;
    }
    
}
