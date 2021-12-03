/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.servicios;

import co.gov.mintic.g43.reto5MinticG43.crud.ScoreRepositorio;
import co.gov.mintic.g43.reto5MinticG43.entidades.Score;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @agus44
 */
@Service
public class ScoreServicio {

    @Autowired
    ScoreRepositorio scoreRepo;

    public void guardarScore(Score score) {
        scoreRepo.save(score);
    }

    public List<Score> buscarTodoScore() {
        return (List<Score>) scoreRepo.findAll();
    }

    public Score buscarpoidScore(Long id) {
        return scoreRepo.findAllById(id);
    }

    public void eliminaridScore(Long id) {
        scoreRepo.deleteById(id);
    }
}
