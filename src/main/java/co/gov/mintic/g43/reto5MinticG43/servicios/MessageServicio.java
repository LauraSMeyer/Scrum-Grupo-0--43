/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.servicios;

import co.gov.mintic.g43.reto5MinticG43.crud.MessageRepositorio;
import co.gov.mintic.g43.reto5MinticG43.entidades.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @agus44
 */
@Service
public class MessageServicio {
    @Autowired
    MessageRepositorio messageRepo;
    
    public void guardarMessage(Message message){
        messageRepo.save(message);
    }
    
    public List<Message> buscarTodoMessage(){
        return (List<Message>)messageRepo.findAll();
    }
    
    public Message buscarpoidMessage(Long id){
        return messageRepo.findAllByIdMessage(id);
    }
    
    public void eliminaridMessage(Long id){
        messageRepo.deleteByIdMessage(id);
    } 
}
