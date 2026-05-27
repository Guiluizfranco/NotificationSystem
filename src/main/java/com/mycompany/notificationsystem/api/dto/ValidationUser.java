/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificationsystem.api.dto;

/**
 *
 * @author guil_dev
 */
public class ValidationUser {
    
    protected boolean validation;
    protected String message;
    
    public void ValidationUser(boolean validation, String message){
        this.validation = validation;
        this.message = message;
    }
    
    public boolean getValidation(){
        return validation;
    }
    public String getMessage(){
        return message;
    }
    
}
