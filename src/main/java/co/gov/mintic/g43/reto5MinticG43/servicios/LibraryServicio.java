/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.servicios;

import co.gov.mintic.g43.reto5MinticG43.crud.LibraryRepositorio;
import co.gov.mintic.g43.reto5MinticG43.entidades.Library;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @agus44
 */
@Service
public class LibraryServicio {
    @Autowired
    LibraryRepositorio libraryRepo;
    
    public void guardarLibrary(Library library){
        libraryRepo.save(library);
    }
    
    public List<Library> buscarTodoLibrary(){
        return (List<Library>)libraryRepo.findAll();
    }
    
    public Library buscarpoidLibrary(Long id){
        return libraryRepo.findAllById(id);
    }
    
    public void eliminaridLibrary(Long id){
        libraryRepo.deleteById(id);
    }
    
    public Library actualizarLib(Library lib){
        if(lib.getId()!=null){
            Optional<Library>g=libraryRepo.findById(lib.getId());
            if(!g.isEmpty()){
                if(lib.getName()!=null){
                    g.get().setName(lib.getName());
                }
                
                if(lib.getCapacity()!=null){
                    g.get().setCapacity(lib.getCapacity());
                }
                
                if(lib.getTarget()!=null){
                    g.get().setTarget(lib.getTarget());
                }
                
                if(lib.getDescription()!=null){
                    g.get().setDescription(lib.getDescription());
                }
                libraryRepo.save(g.get());
            }
        }
        return lib;
    }
    
}
