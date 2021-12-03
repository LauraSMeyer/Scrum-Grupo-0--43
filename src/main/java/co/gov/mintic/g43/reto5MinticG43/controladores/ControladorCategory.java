/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.controladores;

import co.gov.mintic.g43.reto5MinticG43.entidades.Category;
import co.gov.mintic.g43.reto5MinticG43.servicios.CategoryServicio;
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
@RequestMapping("/api/Category")
public class ControladorCategory {
    
    @Autowired
    CategoryServicio categoryServicio;
            
    @GetMapping("/all")
    public List<Category> buscartodo() {
        return categoryServicio.buscarTodoCategory();
    }
    
    @GetMapping("/{id}")
    public Category get(@PathVariable("id") Long id) {
        return categoryServicio.buscarpoidCategory(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity post(@RequestBody Category category) {
        categoryServicio.guardarCategory(category);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity put(@RequestBody Category category) {
        categoryServicio.guardarCategory(category);
        return ResponseEntity.status(201).build();
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        categoryServicio.eliminaridCategory(id);
        return ResponseEntity.status(204).build();
    }
    
}
