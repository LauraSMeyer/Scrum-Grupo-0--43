package com.mac.Ciclo3.controladores;

import com.mac.Ciclo3.modelos.Message;
import com.mac.Ciclo3.servicios.MessageCliente;
import com.mac.Ciclo3.servicios.ServicioGenericoAbstracto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
@CrossOrigin("*")
public class PedidoApiRest extends ControladorGenericoAbstracto<Message, Long> {
    @Autowired
    private MessageCliente cliente;

    @Override
    public ServicioGenericoAbstracto<Message, Long> getService() {
        return cliente;
    }
}
