package com.example.GetJabbed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    @OneToOne(mappedBy = "vaccine",cascade = {CascadeType.ALL})
    @JsonBackReference
    private Appointment appointment;

    public Vaccine(){

    }
    public Vaccine(String type,Appointment appointment){
        this.type = type;
        this.appointment = appointment;
    }
}
