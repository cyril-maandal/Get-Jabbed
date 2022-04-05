package com.example.GetJabbed.controller;

import com.example.GetJabbed.model.Appointment;
import com.example.GetJabbed.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/appointment")
    public Appointment addAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/appointment")
    public List<Appointment> getAllAppointments(){return appointmentRepository.findAll();}
}