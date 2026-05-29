/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificationsystem.api.dto;

import com.mycompany.notification.system.api.model.Notification;
import java.util.List;

/**
 *
 * @author guil_dev
 */
public class NotificationListResponseDTO extends BaseResponseDTO{
    
    protected List <Notification> list;
    
    
    public NotificationListResponseDTO(){
        
    }
    
    public List<Notification> getList(){
        return list;
    }
    public void setList(List<Notification> list){
        this.list = list;
    }
    
}
