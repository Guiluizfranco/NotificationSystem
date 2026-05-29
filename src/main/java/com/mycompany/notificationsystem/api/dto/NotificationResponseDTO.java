/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificationsystem.api.dto;

/**
 *
 * @author guil_dev
 */
public class NotificationResponseDTO extends BaseResponseDTO{
    
    
    protected String title;
    protected String message;
    
    public NotificationResponseDTO(){
        
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
    
}
