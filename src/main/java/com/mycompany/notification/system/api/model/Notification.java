/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notification.system.api.model;

/**
 *
 * @author guil_dev
 */
public class Notification {
    
    protected int id;
    protected String titulo;
    protected String mensagem;
    protected boolean lida;
    protected int sender_id;
    protected int receiver_id;
    
    public Notification(){     
    
    }
    
    public int get_idNot(){
        return id;
    }
    public String get_tituloNot(){
        return titulo;
    }
    public String get_mensagemNot(){
        return mensagem;
    }
    public boolean get_lidaNot(){
        return lida;
    }
    public int get_senderNot(){
        return sender_id;
    }
    public int get_receiverNot(){
        return receiver_id;
    }
            
}
