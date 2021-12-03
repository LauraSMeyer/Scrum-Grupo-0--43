/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.crud;


import co.gov.mintic.g43.reto5MinticG43.entidades.Reservation;
import java.util.Date;
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
public interface ReservationRepositorio extends CrudRepository<Reservation, Long> {
    //public Reservation findAllByIdReservation(Long idReservation);
    //public Reservation deleteByIdReservation(Long idReservation);
    
      
    
    @Query("SELECT u FROM Reservation u")
    public List<Reservation> buscarreservas();
    
    @Query("SELECT u FROM Reservation u Where u.idReservation= ?1")
    public Reservation buscarReservasUno(Long idReservation);
    
    /*@Query("SELECT u FROM Reservation u Where u.startDate>= ?1 and u.startDate<= ?2")
    public Reservation buscarReservasFechas(String f1, String f2);
    
    @Query("SELECT COUNT(u.status) FROM Reservation u Where u.status= 'cancelled' and u.status='completed' ORDER BY u.status")
    public Reservation buscarReservasStatus(String f1, String f2);
    */
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    public List<Reservation> findAllByStatus(String status);
    
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();
       
    @Transactional
    @Modifying
    @Query("DELETE Reservation c WHERE c.idReservation = ?1")
    public void deleteReservas(Long idReservation);
    
    
    ////
     
}
