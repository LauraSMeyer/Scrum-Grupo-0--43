/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.gov.mintic.g43.reto5MinticG43.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
/**
 *
 * @agus44
 */
@Entity
@Data
public class Library implements Serializable {
    /*
    *
    *Definir tabla
    */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 250)
    private String name;
    @Column(length = 45)
    private String target;
    private Integer capacity;
    @Column(length = 250)
    private String description;
    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnoreProperties("libs")
    private Category category;
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="lib")
    @JsonIgnoreProperties({"category","lib","client"})
    private List<Message> messages;
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="lib")
    @JsonIgnoreProperties("lib")
    private List<Reservation> reservations;
    
    /*
    *
    *Constructor
    */
    public Library(Long id, String target, Integer capacity, Category category, String name, String description) {
        this.id = id;
        this.target = target;
        this.capacity = capacity;
        this.category = category;
        this.name = name;
        this.description = description;
    }

    /*
    *
    *Constructor vacio
    */
    public Library() {
    }

    /*
    *
    *Metodos
    */
    public Long getId() {
        return id;
    }
    //Set id
    public void setId(Long id) {
        this.id = id;
    }
    //Get target
    public String getTarget() {
        return target;
    }
    //Set target
    public void setTarget(String target) {
        this.target = target;
    }
    //Get capacity
    public Integer getCapacity() {
        return capacity;
    }
    //Set capacity
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    //Get category
    public Category getCategory() {
        return category;
    }
    //Set category
    public void setCategory(Category category) {
        this.category = category;
    }
    //Get name
    public String getName() {
        return name;
    }
    //Set name
    public void setName(String name) {
        this.name = name;
    }
    //Get descripcion
    public String getDescription() {
        return description;
    }
    //Set descripcion
    public void setDescription(String description) {
        this.description = description;
    }
    //Get message
    public List<Message> getMessages() {
        return messages;
    }
    //Set message
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    //Get reserva
    public List<Reservation> getReservations() {
        return reservations;
    }
    //Set reserva
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    //Metodo hashcode
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    //Metodo equals
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Library)) {
            return false;
        }
        Library other = (Library) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    //Metodo tostring
    @Override
    public String toString() {
        return "co.gov.mintic.g43.reto3MinticG43.entidades.Library[ id=" + id + " ]";
    }
    
}
