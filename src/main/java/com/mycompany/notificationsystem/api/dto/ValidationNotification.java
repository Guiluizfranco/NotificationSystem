/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificationsystem.api.dto;

/**
 *
 * @author guil_dev
 */
public class ValidationNotification {
    
    protected boolean validation;
    protected String message; 
    
    public ValidationNotification(){
        
    }
    
    public boolean getValidation(){
        return validation;
    }
    public void setValidation(boolean validation){
        this.validation = validation;
    }
    
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    
}
