/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificationsystem.api.dto;

/**
 *
 * @author guil_dev
 */
public class NotificationDTO {
    
    protected String title;
    protected String message;
    protected int sender_id;
    protected int receiver_id;
    
    public NotificationDTO(){
    
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    
    public int getSenderID(){
        return sender_id;
    }
    public void setSenderID(int sender_id){
        this.sender_id = sender_id;
    }
    
    public int getReceiverID(){
        return receiver_id;
    }
    public void setReceiverID(int receiver_id){
        this.receiver_id = receiver_id;
    }
}
