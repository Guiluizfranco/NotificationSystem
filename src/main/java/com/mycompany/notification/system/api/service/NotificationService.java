/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.service;
import com.mycompany.notificationsystem.api.dto.NotificationResponseDTO;
import com.mycompany.notificationsystem.api.dto.NotificationDTO;
import com.mycompany.notification.system.api.dao.NotificationDAO;
import com.mycompany.notification.system.api.model.Notification;
import com.mycompany.notificationsystem.api.dto.NotificationListResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guil_dev
 */
public class NotificationService {
    
    NotificationResponseDTO validationNotification = new NotificationResponseDTO();
    NotificationListResponseDTO validationListResponse = new NotificationListResponseDTO();
    NotificationDAO dao = new NotificationDAO();
    Notification notification = new Notification();
    
    public NotificationListResponseDTO SelectAllNotifications(){
        
        List<Notification> list = new ArrayList<>();
        
        validationListResponse.setValidation(true);
        validationListResponse.setMessageValidation("Funcionou");
        validationListResponse.setList(dao.SearchAllNotification(notification, list));
        
        System.out.println(list);
        
        return validationListResponse;
    }
    
    public NotificationListResponseDTO SelectNotificationsFilter(Integer id, Integer sender_id, Integer receiver_id, String titulo, Boolean read){
        
        if(id != null){
            validationListResponse.setValidation(true);
            dao.SearchNotificationID(id);
        }
        else if(sender_id != null){
            dao.SearchNotificationSenderID(sender_id);
        }
        else if(receiver_id != null){
            dao.SearchNotificationReceiverID(receiver_id);
        }
        else if(titulo != null){
            dao.SearchNotificationTitle(titulo);
        }
        else if(read != null){
            dao.SearchNotificationRead(read);
        }
        
        return validationListResponse;
    }
    
    public NotificationResponseDTO SendNotification(NotificationDTO dto){
                
        if(!ValidationNull(dto)){
            
            validationNotification.setValidation(false);
            validationNotification.setMessageValidation("Todos os campos precisam serem preenchidos");
            
        }
        else if(!ValidationExistisSenderID(dto)){
            
            validationNotification.setValidation(false);
            validationNotification.setMessageValidation("O ID do remetente não foi encontrado");
            
        }
        else if(!ValidationExistisReceiverID(dto)){
            
            validationNotification.setValidation(false);
            validationNotification.setMessageValidation("O ID do destinatário não foi encontrado");
        }
        else{
            
            notification.setTitle(dto.getTitle());
            notification.setMessage(dto.getMessage());
            notification.setRead(false);
            notification.setSenderID(dto.getSenderID());
            notification.setReceiverID(dto.getReceiverID());
   
            dao.CreateNotification(notification);
            
            validationNotification.setValidation(true);
            validationNotification.setMessageValidation("Notificação enviada com sucesso");
            
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
        
        if(dao.SearchSenderIDUsers(dto)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean ValidationExistisReceiverID(NotificationDTO dto){
        
        if(dao.SearchReceiverIDUsers(dto)){
            return true;
        }else{
            return false;
        }
        
    }
}
