/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.controladores;

import Custom.CountClient;
import Custom.StatusRes;
import co.gov.mintic.g43.reto5MinticG43.entidades.Reservation;
import co.gov.mintic.g43.reto5MinticG43.servicios.ReservationServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @agus44
 */
@RestController
@RequestMapping("/api/Reservation")
public class ControladorReservation {
    @Autowired
    ReservationServicio reservationServicio;
            
    @GetMapping("/all")
    public List<Reservation> buscartodo() {
        return reservationServicio.buscarTodoReservation();
    }
    
    @GetMapping("/{id}")
    public Reservation get(@PathVariable("id") Long id) {
        return reservationServicio.buscarpoidReservation(id);
    }
    
    @GetMapping("/report-status")
    public StatusRes reporStatus() {
        return reservationServicio.getStatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> reporClient() {
        return reservationServicio.getTopClientesReport();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> reporDate(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2){
        return reservationServicio.getReservationPeriodReport(d1, d2);
    }
    
    @PostMapping("/save")
    public ResponseEntity post(@RequestBody Reservation reservation) {
        reservationServicio.guardarReservation(reservation);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity put(@RequestBody Reservation reservation) {
        reservationServicio.guardarReservation(reservation);
        return ResponseEntity.status(201).build();
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        reservationServicio.eliminaridReservation(id);
        return ResponseEntity.status(204).build();
    }
}
