/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.mycompany.notificationsystem.api.dto.NotificationResponseDTO;
import com.mycompany.notification.system.api.service.NotificationService;
import com.mycompany.notificationsystem.api.dto.NotificationDTO;
import com.mycompany.notificationsystem.api.dto.NotificationListResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    
    NotificationService service = new NotificationService();
   
   @GetMapping
   public NotificationListResponseDTO GetAllNotifications(){
       return service.SelectAllNotifications();
   } 

   @GetMapping("/filter")
   public NotificationListResponseDTO SelectNotification(
           @RequestParam(required = false) Integer id,
           @RequestParam(required = false) Integer senderId,
           @RequestParam(required = false) Integer receiverId,
           @RequestParam(required = false) String title,
           @RequestParam(required = false) Boolean read){
       
           return service.SelectNotificationsFilter(id, senderId, receiverId, title, read);
   }
    
   @PostMapping
    public NotificationResponseDTO SendNotification(@RequestBody NotificationDTO notification){
        
        return service.SendNotification(notification);
    }
    
    @PutMapping("/read/{id}")
    public NotificationResponseDTO MarkAsRead(@PathVariable int id){
        
        return service.MarkAsRead(id);
    }
    
}
