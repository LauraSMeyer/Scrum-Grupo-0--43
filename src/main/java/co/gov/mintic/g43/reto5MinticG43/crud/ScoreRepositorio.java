/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.crud;

import co.gov.mintic.g43.reto5MinticG43.entidades.Reservation;
import co.gov.mintic.g43.reto5MinticG43.entidades.Score;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @agus44
 */
@Repository
public interface ScoreRepositorio extends CrudRepository<Score, Long> {
    public Score findAllById(Long id);

    @Query("SELECT u FROM Score u")
    public List<Score> buscarreservas();
}
