/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.mycompany.notificationsystem.api.dto.ValidationNotification;
import com.mycompany.notification.system.api.service.NotificationService;
import com.mycompany.notificationsystem.api.dto.NotificationDTO;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    
    NotificationService service = new NotificationService();
    
    @GetMapping
    public String GetMapping(){
        return "API está funcionando";
    }
    
    //@PostMapping
    public NotificationDTO teste(@RequestBody NotificationDTO notificaion){
       
        return notificaion;
    }
    
   @PostMapping
    public ValidationNotification SendNotification(@RequestBody NotificationDTO notification){
        
        return service.SendNotification(notification);
    }
    
}
