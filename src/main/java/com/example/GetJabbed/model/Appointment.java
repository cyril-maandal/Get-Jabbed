package com.example.GetJabbed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "vaccineId")
    private Vaccine vaccine;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "personId")
    private Person person;

    private String location;

    private boolean completed;

    public Appointment(){}


    public Appointment(Date date, Person person, String location, boolean completed) {
        this.date = date;
        this.person = person;
        this.location = location;
        this.completed = completed;
    }

}
