package com.mac.Ciclo3.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private Long celular;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("cliente")
    List<Lib> lib;

}
