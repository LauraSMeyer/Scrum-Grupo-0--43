/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.servicios;

import co.gov.mintic.g43.reto5MinticG43.crud.CategoryRepositorio;
import co.gov.mintic.g43.reto5MinticG43.entidades.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @agus44
 */
@Service
public class CategoryServicio {

    @Autowired
    CategoryRepositorio categoryRepo;

    public void guardarCategory(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> buscarTodoCategory() {
        return (List<Category>) categoryRepo.findAll();
    }

    public Category buscarpoidCategory(Long id) {
        return categoryRepo.findAllById(id);
    }

    public void eliminaridCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
