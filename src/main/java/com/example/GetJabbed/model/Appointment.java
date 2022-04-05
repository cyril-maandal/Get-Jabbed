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

    @OneToOne
    @JoinColumn(name = "vaccineId")
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    private String location;
    private boolean completed;

}
