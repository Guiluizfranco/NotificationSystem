/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.service;
import com.mycompany.notificationsystem.api.dto.NotificationResponseDTO;
import com.mycompany.notificationsystem.api.dto.NotificationDTO;
import com.mycompany.notification.system.api.dao.NotificationDAO;
import com.mycompany.notification.system.api.dao.UsersDAO;
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
    UsersDAO daoUser = new UsersDAO();
    Notification notification = new Notification();
    
    public NotificationListResponseDTO SelectAllNotifications(){
        
        List<Notification> list = new ArrayList<>();
        
        validationListResponse.setValidation(true);
        validationListResponse.setMessageValidation("Funcionou");
        validationListResponse.setList(dao.SearchAllNotification(list));
        
        System.out.println(list);
        
        return validationListResponse;
    }
    
    public NotificationListResponseDTO SelectNotificationsFilter(Integer id, Integer sender_id, Integer receiver_id, String title, Boolean read){
        
        List<Notification> list = new ArrayList<>();
        
        if(id != null){
            validationListResponse.setValidation(true);
            
            validationListResponse.setList(dao.SearchNotificationID(list, id));

        }
        else if(sender_id != null){
            validationListResponse.setValidation(true);
            
            validationListResponse.setList(dao.SearchNotificationSenderID(list, sender_id));
        }
        else if(receiver_id != null){
            validationListResponse.setValidation(true);
            
            validationListResponse.setList(dao.SearchNotificationReceiverID(list, receiver_id));
        }
        else if(title != null){
            validationListResponse.setValidation(true);
            
            validationListResponse.setList(dao.SearchNotificationTitle(list, title));
        }
        else if(read != null){
            validationListResponse.setValidation(true);
            
            validationListResponse.setList(dao.SearchNotificationRead(list, read));
        }
        
        if(validationListResponse.getList().isEmpty()){
            
            validationListResponse.setMessageValidation("Nenhuma notificação foi encontrada");
            
        }else{
            
            validationListResponse.setMessageValidation("Notificações encontradas");
        }
        
        return validationListResponse;
    }
    
    public NotificationResponseDTO SendNotification(NotificationDTO dto){
                
        if(!ValidationNull(dto)){
            
            validationNotification.setValidation(false);
            validationNotification.setMessageValidation("Todos os campos precisam serem preenchidos");
            
        }
        else if(!daoUser.SearchReceiverIDUsers(dto.getSenderID())){
            
            validationNotification.setValidation(false);
            validationNotification.setMessageValidation("O ID do remetente não foi encontrado");
            
        }
        else if(!daoUser.SearchReceiverIDUsers(dto.getReceiverID())){
            
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
    
    public NotificationResponseDTO MarkAsRead(int id){
        
        if(dao.SearchNotificationID(id)){
            
            if(dao.isRead(id)){
                
                validationNotification.setValidation(false);
                validationNotification.setMessageValidation("A notificação já está marcada como lida");
                
            }
            else if(dao.UpdateNotificationRead(id)){
                
                validationNotification.setValidation(true);
                validationNotification.setMessageValidation("Mensagem lida!");
                
            }else{
                
                validationNotification.setValidation(false);
                validationNotification.setMessage("Não foi possível marcar lida a notification");
            }
        }else{
            
            validationNotification.setValidation(false);
            validationNotification.setMessage("Não foi encontrado a notificação");
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

}
