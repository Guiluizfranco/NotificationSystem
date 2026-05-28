/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.service;
import com.mycompany.notificationsystem.api.dto.ValidationNotification;
import com.mycompany.notificationsystem.api.dto.NotificationDTO;
import com.mycompany.notification.system.api.dao.NotificationDAO;
import com.mycompany.notification.system.api.model.Notification;

/**
 *
 * @author guil_dev
 */
public class NotificationService {
    
    ValidationNotification validationNotification = new ValidationNotification();
    NotificationDTO dto = new NotificationDTO();
    NotificationDAO dao = new NotificationDAO();
    Notification notification = new Notification();
    
    public ValidationNotification SendNotification(NotificationDTO dto){
                
        if(!ValidationNull(dto)){
            
            validationNotification.setValidation(false);
            validationNotification.setMessage("Todos os campos precisam serem preenchidos");
            
        }
        else if(!ValidationExistisSenderID(dto)){
            
            validationNotification.setValidation(false);
            validationNotification.setMessage("O ID do remetente não foi encontrado");
            
        }
        else if(!ValidationExistisReceiverID(dto)){
            
            validationNotification.setValidation(false);
            validationNotification.setMessage("O ID do destinatário não foi encontrado");
        }
        else{
            
            notification.setTitle(dto.getTitle());
            notification.setMessage(dto.getMessage());
            notification.setRead(false);
            notification.setSenderID(dto.getSenderID());
            notification.setReceiverID(dto.getReceiverID());
   
            dao.CreateNotification(notification);
            
            validationNotification.setValidation(true);
            validationNotification.setMessage("Notificação enviada com sucesso");
            
        }
        
        
        return validationNotification;
    }
    
    public boolean ValidationNull(NotificationDTO dto){
        
        if(dto.getTitle() == null || dto.getMessage() == null || dto.getReceiverID() == 0 || dto.getSenderID() == 0){
            
            return false;
            
        }else{
            
            return true;
        }
        
    }
    
    public boolean ValidationExistisSenderID(NotificationDTO dto){
        
        if(dao.SearchSenderID(dto)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean ValidationExistisReceiverID(NotificationDTO dto){
        
        if(dao.SearchReceiverID(dto)){
            return true;
        }else{
            return false;
        }
        
    }
}
