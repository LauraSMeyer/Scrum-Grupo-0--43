package com.mac.Ciclo3.controladores;

import com.mac.Ciclo3.modelos.Lib;
import com.mac.Ciclo3.servicios.LibCliente;
import com.mac.Ciclo3.servicios.ServicioGenericoAbstracto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lib")
@CrossOrigin("*")
public class LibApiRest extends ControladorGenericoAbstracto<Lib, Long> {
    @Autowired
    private LibCliente servicio;

    @Override
    public ServicioGenericoAbstracto<Lib, Long> getService() {
        return servicio;
    }
}
