/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.controladores;

import co.gov.mintic.g43.reto5MinticG43.entidades.Library;
import co.gov.mintic.g43.reto5MinticG43.servicios.LibraryServicio;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @agus44
 */
@RestController
@RequestMapping("/api/Lib")
public class ControladorLibrary {
    
    @Autowired
    LibraryServicio libraryServicio;
            
    @GetMapping("/all")
    public List<Library> buscartodo() {
        return libraryServicio.buscarTodoLibrary();
    }
    
    @GetMapping("/{id}")
    public Library get(@PathVariable("id") Long id) {
        return libraryServicio.buscarpoidLibrary(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity post(@RequestBody Library library) {
        libraryServicio.guardarLibrary(library);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity put(@RequestBody Library library) {
        libraryServicio.actualizarLib(library);
        return ResponseEntity.status(201).build();
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        libraryServicio.eliminaridLibrary(id);
        return ResponseEntity.status(204).build();
    }
    
}
