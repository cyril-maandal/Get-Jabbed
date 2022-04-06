package com.example.GetJabbed.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
@NoArgsConstructor
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

    private String status;

    private Date reschedule;

    public Appointment(Date date, Person person, String location, boolean completed,String status,Date reschedule) {
        this.date = date;
        this.person = person;
        this.location = location;
        this.completed = completed;
        this.status=status;
        this.reschedule=reschedule;
    }


}
