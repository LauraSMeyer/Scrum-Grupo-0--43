/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.servicios;

import co.gov.mintic.g43.reto5MinticG43.crud.AdminRepositorio;
import co.gov.mintic.g43.reto5MinticG43.entidades.Admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @agus44
 */
@Service
public class AdminServicio {
    @Autowired
    AdminRepositorio adminRepo;
    
    public void guardarAdmin(Admin admin){
        adminRepo.save(admin);
    }
    
    public List<Admin> buscarTodoAdmin(){
        return (List<Admin>)adminRepo.findAll();
    }
    
    public Admin buscarpoidAdmin(Long id){
        return adminRepo.findAllById(id);
    }
    
    public void eliminaridAdmin(Long id){
        adminRepo.deleteById(id);
    } 
}
