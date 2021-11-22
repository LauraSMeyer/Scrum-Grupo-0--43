package com.mac.Ciclo3.controladores;

import com.mac.Ciclo3.modelos.LibXMessage;
import com.mac.Ciclo3.servicios.LibXMessageServicio;
import com.mac.Ciclo3.servicios.ServicioGenericoAbstracto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lib-x-message")
@CrossOrigin("*")
public class LibXMessageApiRest extends ControladorGenericoAbstracto<LibXMesagge, Long> {
    @Autowired
    private LibXMessageServicio servicio;

    @Override
    public ServicioGenericoAbstracto<LibXMesagge, Long> getService() {
        return servicio;
    }
}
