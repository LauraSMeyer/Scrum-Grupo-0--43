/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.crud;

import Custom.CountClient;
import co.gov.mintic.g43.reto5MinticG43.entidades.Client;
import co.gov.mintic.g43.reto5MinticG43.entidades.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @agus44
 */
@Repository
public class ReportesRepositorio {
    @Autowired
    private ReservationRepositorio reservationRepo;
    
     public List<Reservation> getReservationByStatus(String status){
        return reservationRepo.findAllByStatus(status);
    
    }
    
    public List<Reservation> getReservationFecha(Date dateOne, Date dateTwo){
        return reservationRepo.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<CountClient> getTopClientes(){
        List<CountClient> res = new ArrayList<>();
        
        List<Object[]> report=reservationRepo.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            Client cli = (Client) report.get(i)[0];
            Long cantidad=(Long) report.get(i)[1];
            CountClient cc = new CountClient(cantidad, cli);
            res.add(cc);
        }
        return res;
    }
    
}
