package com.example.GetJabbed.model;

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

    @OneToOne(mappedBy = "vaccine",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "appointmentId")
    private Appointment appointment;

    public Vaccine(){

    }
    public Vaccine(String type,Appointment appointment){
        this.type = type;
        this.appointment = appointment;
    }
}
