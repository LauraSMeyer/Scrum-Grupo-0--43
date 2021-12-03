/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.servicios;

import co.gov.mintic.g43.reto5MinticG43.crud.ClientRepositorio;
import co.gov.mintic.g43.reto5MinticG43.entidades.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @agus44
 */
@Service
public class ClientServicio {
    @Autowired
    ClientRepositorio clientRepo;
    
    public void guardarClient(Client client){
        clientRepo.save(client);
    }
    
    public List<Client> buscarTodoClient(){
        return (List<Client>)clientRepo.findAll();
    }
    
    public Client buscarpoidClient(Long id){
        return clientRepo.buscarclientesUno(id);
    }
    
    public void eliminaridClient(Long id){
        clientRepo.deleteClient(id);
    } 
}
