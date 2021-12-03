/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.servicios;

import Custom.CountClient;
import Custom.StatusRes;
import co.gov.mintic.g43.reto5MinticG43.crud.ReportesRepositorio;
import co.gov.mintic.g43.reto5MinticG43.crud.ReservationRepositorio;
import co.gov.mintic.g43.reto5MinticG43.entidades.Client;
import co.gov.mintic.g43.reto5MinticG43.entidades.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @agus44
 */
@Service
public class ReservationServicio {

    @Autowired
    ReservationRepositorio reservationRepo;
    @Autowired
    ReportesRepositorio reporteRepo;

    public void guardarReservation(Reservation reservation) {
        reservationRepo.save(reservation);
    }

    public List<Reservation> buscarTodoReservation() {
        return (List<Reservation>) reservationRepo.findAll();
    }

    public Reservation buscarpoidReservation(Long id) {
        return reservationRepo.buscarReservasUno(id);
    }

    public void eliminaridReservation(Long id) {
        reservationRepo.deleteReservas(id);
    }
    
   public List<CountClient> getTopClientesReport(){
     return reporteRepo.getTopClientes();
   }
    
    public StatusRes getStatusReport(){
        List<Reservation> completed= reporteRepo.getReservationByStatus("completed");
        List<Reservation> cancelled= reporteRepo.getReservationByStatus("cancelled");
        
        StatusRes statusres = new StatusRes(completed.size(),cancelled.size());
        return statusres;
    }
    
    public List<Reservation> getReservationPeriodReport(String d1, String d2){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        
        try{
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reporteRepo.getReservationFecha(dateOne, dateTwo);
        }else{
           return new ArrayList<>();
        }
        
        
    }
}
