package com.example.GetJabbed.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;
@Table
@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(unique = true)
    private String ssn;

    private boolean vaccinated;
    private int doses;

    @OneToMany(mappedBy = "person",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Appointment> appointmentList;

    public Person(){

    }
    public Person(String ssn, boolean vaccinated,int doses,List<Appointment> appointmentList){
        this.ssn = ssn;
        this.vaccinated = vaccinated;
        this.doses = doses;
        this.appointmentList = appointmentList;
    }
}
