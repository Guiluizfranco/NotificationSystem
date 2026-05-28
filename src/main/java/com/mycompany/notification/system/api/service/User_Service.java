/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.service;

import com.mycompany.notificationsystem.api.dto.UserDTO;
import com.mycompany.notification.system.api.dao.UsersDAO;
import com.mycompany.notificationsystem.api.dto.ValidationUser;
import com.mycompany.notification.system.api.model.User;

/**
 *
 * @author guil_dev
 */
public class User_Service {
    
    User user = new User();
    UsersDAO userDAO = new UsersDAO();
    ValidationUser validationUser = new ValidationUser();
    
    public ValidationUser ValidationUser(UserDTO dto){
        
        if(!ValidationName(dto)){            
            validationUser.setValidation(false);
            validationUser.setMessage("O nome inserido não é válido");
        }
        
        else if(!ValidationEmail(dto)){
            validationUser.setValidation(false);
            validationUser.setMessage("O email inserido não é válido");
        }
        
        else if(ValidationExistsEmail(dto)){
            validationUser.setValidation(false);
            validationUser.setMessage("O email já existe");  
        }
        
        else {
            
            user.setNome(dto.getNome());
            user.setEmail(dto.getEmail());
            user.setSenha(dto.getSenha());
            
            userDAO.CreateUsers(user);
            validationUser.setValidation(true);
            validationUser.setMessage("Usuario cadastrado com sucesso");

        }
        
        return validationUser;
        
    }
    
    public boolean ValidationName(UserDTO user){
        
        if(user.getNome().matches("\\d+") || user.getNome().length() <= 2 || user.getNome() == null){
            
            return false;
            
        }else{
            
            return true;
        }
        
    }
    
    public boolean ValidationEmail(UserDTO user){
        
        if(user.getEmail().matches("\\d+") || user.getEmail().length() <= 2 || user.getEmail() == null){
            
            return false;
            
        }else{
            
            return true;
        }
    }
    
    public boolean ValidationExistsEmail(UserDTO user){
     
        if(userDAO.SearchUsers(user)){
            return false;
        
        }else{
            
            return true;
        }
        
    }
    
            
    
}
