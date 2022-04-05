package com.example.GetJabbed.model;

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
    @JoinColumn(name = "vaccineId",referencedColumnName = "id")
    private Vaccine vaccine;

    @ManyToOne
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
