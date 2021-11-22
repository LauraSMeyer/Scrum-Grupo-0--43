package com.mac.Ciclo3.modelos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "lib_x_message")
public class LibXMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "id_lib")
    private Message message;
    @ManyToOne
    @JoinColumn(name = "id_message")
    private Lib lib;
}
