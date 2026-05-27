/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.controller;

import com.mycompany.notification.system.api.service.User_Service;
import com.mycompany.notificationsystem.api.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.notificationsystem.api.dto.ValidationUser;

@RestController
@RequestMapping("/users")
public class UserController {
    
    User_Service userService = new User_Service();
    
    @GetMapping
    public String Conectar(){
        return "API funcionando";
    }

    @PostMapping
    public ValidationUser CreateUser(@RequestBody UserDTO user){
        
        return userService.ValidationUser(user);
        
    }
    
}
