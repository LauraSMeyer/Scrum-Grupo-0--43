package com.mac.Ciclo3.controladores;

import com.mac.Ciclo3.modelos.Cliente;
import com.mac.Ciclo3.servicios.ClienteServicio;
import com.mac.Ciclo3.servicios.ServicioGenericoAbstracto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class ClienteApiRest extends ControladorGenericoAbstracto<Cliente, Long> {

    @Autowired
    private ClienteServicio servicio;

    @Override
    public ServicioGenericoAbstracto<Cliente, Long> getService() {
        return servicio;
    }
}
