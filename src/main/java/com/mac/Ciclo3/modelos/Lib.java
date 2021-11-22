package com.mac.Ciclo3.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Lib")
public class Lib implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private Long cantidad;

    @OneToMany(mappedBy = "Message", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"lib", "message"})
    List<LibXMessage> libXmessage;
}
