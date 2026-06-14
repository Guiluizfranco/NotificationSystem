/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.service;

import com.mycompany.notification.system.api.dao.UsersDAO;
import com.mycompany.notification.system.api.model.User;
import com.mycompany.notificationsystem.api.dto.UserDTO;
import com.mycompany.notificationsystem.api.dto.UserListResponseDTO;
import com.mycompany.notificationsystem.api.dto.UserResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guil_dev
 */
public class UserService {
    
    User user = new User();
    UsersDAO userDAO = new UsersDAO();
    UserResponseDTO validationUser = new UserResponseDTO();
    UserListResponseDTO userValidationList = new UserListResponseDTO();
    
    public UserResponseDTO ValidationUser(UserDTO dto){
        
        if(!ValidationName(dto)){            
            validationUser.setValidation(false);
            validationUser.setMessageValidation("O nome inserido não é válido");
        }
        
        else if(!ValidationEmail(dto)){
            validationUser.setValidation(false);
            validationUser.setMessageValidation("O email inserido não é válido");
        }
        
        else if(!ValidationExistsEmail(dto)){
            validationUser.setValidation(false);
            validationUser.setMessageValidation("O email já existe");  
        }
        
        else {
            
            user.setNome(dto.getNome());
            user.setEmail(dto.getEmail());
            user.setSenha(dto.getSenha());
            
            userDAO.CreateUsers(user);
            validationUser.setValidation(true);
            validationUser.setMessageValidation("Usuario cadastrado com sucesso");

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
     
        if(userDAO.ValidationExistsEmailUsers(user)){
            return false;
        
        }else{
            
            return true;
        }
        
    }
    
    public UserListResponseDTO SelectAllUsers(){
        
        List<User> list = new ArrayList<>();

        userValidationList.setList(userDAO.SearchAllUsers(list));
        
        if(userValidationList.getList().isEmpty()){
            
        userValidationList.setValidation(false);
        userValidationList.setMessageValidation("Nenhum usuário encontrado");
            
        }else{
            
        userValidationList.setValidation(true);
        userValidationList.setMessageValidation("Usuarios encontrados");
            
        }
        
        
        return userValidationList;
    }
    
    public UserListResponseDTO SelectFilterUsers(Integer id, String nome, String email){
        
        List<User> list = new ArrayList<>();
        
        if(id != null){
            userValidationList.setList(userDAO.SearchUserId(id, list));
        }
        else if(nome != null){
            userValidationList.setList(userDAO.SearchUserNome(nome, list));
        }
        else if(email != null){   
            userValidationList.setList(userDAO.SearchUserEmail(email, list));         
        }
        
        if(userValidationList.getList().isEmpty()){
            
            userValidationList.setValidation(false);
            userValidationList.setMessageValidation("Nenhum usuário encontrado");
            
        }else{
            
            userValidationList.setValidation(true);
            userValidationList.setMessageValidation("Usuários encontrados");
            
        }

        return userValidationList;
    }
    
    public UserResponseDTO UpdateUser(int id, UserDTO userDTO){
        
        List<User> list = new ArrayList<>();
        
        user.setNome(userDTO.getNome());
        user.setEmail(userDTO.getEmail());
        user.setSenha(userDTO.getSenha());
        
        userDAO.SearchUserId(id, list);
        
        if(list.isEmpty()){
            
            validationUser.setValidation(false);
            validationUser.setMessageValidation("Nenhum usuário encontrado com esse id!");
            
        }else{
                
        if(user.getNome()!= null){

            if(userDAO.UpdateUserName(user.getNome(), id)){
                validationUser.setValidation(true);
                validationUser.setMessageValidation("Dados atualizados!");
                list.clear();
            }
            else{
                validationUser.setValidation(false);
                validationUser.setMessageValidation("Não foi possível atualizar os dados!");
            }
        }
        
        if(user.getSenha()!= null){
            
            if(userDAO.UpdateUserSenha(user.getSenha(), id)){
                validationUser.setValidation(true);
                validationUser.setMessageValidation("Dados atualizados!");
            }
            else{
                validationUser.setValidation(false);
                validationUser.setMessageValidation("Não foi possível atualizar os dados!");
            }
                
        }
        
        if(user.getEmail()!= null){
            
            userDAO.SearchUserEmail(user.getEmail(), list);
            
            if(list.isEmpty()){

               if(userDAO.UpdateUserEmail(user.getEmail(), id)){
                   
                   validationUser.setValidation(true);
                   validationUser.setMessageValidation("Dados atualizados!");
                   
               }else{
                   
                   validationUser.setValidation(false);
                   validationUser.setMessageValidation("Não foi possível atualizar o e-mail!");
                   
               }
               
            
            }else{
                validationUser.setValidation(false);
                validationUser.setMessageValidation("E-mail já utilizado. Insira outro e-mail!");
            }
        }
        
        if(user.getNome() == null && user.getEmail() == null && user.getSenha() == null){
            validationUser.setValidation(false);
            validationUser.setMessageValidation("Insira algum valor");
        }
        
        }
      
        
        return validationUser;
    }
    
    public UserResponseDTO DeleteUser(int id){
        
       List<User> list = new ArrayList<>();

       userDAO.SearchUserId(id, list);
  
        if(list.isEmpty()){
            
            validationUser.setValidation(false);
            validationUser.setMessageValidation("Usuário não encontrado");
            
        }
        
        else if(userDAO.DeleteUser(id)){
         
            validationUser.setValidation(true);
            validationUser.setMessageValidation("Usuário deletado");
            
        }else{
            
            validationUser.setValidation(false);
            validationUser.setMessageValidation("Não foi possível deletar o usuário");
            
        }
        
        return validationUser;
        
    }
        
    
}
