/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.controller;

import com.mycompany.notification.system.api.service.UserService;
import com.mycompany.notificationsystem.api.dto.UserDTO;
import com.mycompany.notificationsystem.api.dto.UserListResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.notificationsystem.api.dto.UserResponseDTO;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {
    
    UserService service = new UserService();
    
    @GetMapping
    public UserListResponseDTO SelectAll(){
        
        return service.SelectAllUsers();
        
    }
    
    @GetMapping("/filter")
    public UserListResponseDTO SelectFilter(
            @RequestParam (required = false) Integer id,
            @RequestParam (required = false) String nome,
            @RequestParam (required = false) String email)
    {
        return service.SelectFilterUsers(id, nome, email);
    }

    @PostMapping
    public UserResponseDTO CreateUser(@RequestBody UserDTO user){
        
        return service.ValidationUser(user);
        
    }
    
}
