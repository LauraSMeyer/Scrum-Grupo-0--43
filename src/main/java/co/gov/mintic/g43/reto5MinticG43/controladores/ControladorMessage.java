/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.controladores;

import co.gov.mintic.g43.reto5MinticG43.entidades.Message;
import co.gov.mintic.g43.reto5MinticG43.servicios.MessageServicio;
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
@RequestMapping("/api/Message")
public class ControladorMessage {

    @Autowired
    MessageServicio messageServicio;

    @GetMapping("/all")
    public List<Message> buscartodo() {
        return messageServicio.buscarTodoMessage();
    }

    @GetMapping("/{id}")
    public Message get(@PathVariable("id") Long idMessage) {
        return messageServicio.buscarpoidMessage(idMessage);
    }

    @PostMapping("/save")
    public ResponseEntity post(@RequestBody Message message) {
        messageServicio.guardarMessage(message);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity put(@RequestBody Message message) {
        messageServicio.guardarMessage(message);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long idMessage) {
        messageServicio.eliminaridMessage(idMessage);
        return ResponseEntity.status(204).build();
    }
}
