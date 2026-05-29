/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificationsystem.api.dto;

/**
 *
 * @author guil_dev
 */
public class BaseResponseDTO {
    
    protected boolean validation;
    protected String messageValidation;
    
    public BaseResponseDTO(){
        
    }
    
    public boolean getValidation(){
        return validation;
    }
    public void setValidation(boolean validation){
        this.validation = validation;
    }
    
    public String getMessageValidation(){
        return messageValidation;
    }
    public void setMessageValidation(String messageValidation){
        this.messageValidation = messageValidation;
    }
    
}
