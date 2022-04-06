package com.example.GetJabbed.controller;

import com.example.GetJabbed.model.Appointment;
import com.example.GetJabbed.repository.AppointmentRepository;
import com.example.GetJabbed.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    @PostMapping("/appointment")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/appointment")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }


    @PostMapping("/cancel")
    public Appointment cancelAppointment(@RequestBody Appointment appointment) {
        appointment.setStatus("Cancelled");
        return appointmentRepository.save(appointment);

    }


    @PostMapping("/reschedule")
    public Appointment rescheduleappoinment(@RequestBody Appointment appointment) {
        appointmentRepository.findById(appointment.getId());
        appointment.setStatus("Cancelled");
        Appointment appointment2 = new Appointment();
        return appointmentRepository.save(appointment2);


    }


}
