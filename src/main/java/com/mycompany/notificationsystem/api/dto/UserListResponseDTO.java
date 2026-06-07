/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificationsystem.api.dto;

import com.mycompany.notification.system.api.model.User;
import java.util.List;

/**
 *
 * @author guil_dev
 */
public class UserListResponseDTO extends BaseResponseDTO {
    
    protected List<User> list;
    
    public UserListResponseDTO(){
        
    }
    
    public List<User> getList(){
        return list;
    }
    public void setList(List<User> list){
        this.list = list;
    }
    
}
