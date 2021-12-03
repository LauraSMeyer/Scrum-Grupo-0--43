/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.crud;

import co.gov.mintic.g43.reto5MinticG43.entidades.Client;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @agus44
 */
@Repository
public interface ClientRepositorio extends CrudRepository<Client, Long> {
    //public Client findAllById(Long id);
    //public Client deleteByIdClient(Long idClient);
    
    @Query("SELECT u FROM Client u")
    public List<Client> buscarclientes();
    
    @Query("SELECT u FROM Client u Where u.idClient= ?1")
    public Client buscarclientesUno(Long idClient);
    
    @Transactional
    @Modifying
    @Query("DELETE Client c WHERE c.idClient = ?1")
    public void deleteClient(Long idClient);
}
