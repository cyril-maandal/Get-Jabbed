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

    @OneToOne(mappedBy = "vaccine")
    private Appointment appointment;
}
