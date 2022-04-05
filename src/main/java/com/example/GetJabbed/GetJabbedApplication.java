package com.example.GetJabbed;

import com.example.GetJabbed.model.Appointment;
import com.example.GetJabbed.model.Vaccine;
import com.example.GetJabbed.repository.AppointmentRepository;
import com.example.GetJabbed.repository.PersonRepository;
import com.example.GetJabbed.repository.VaccineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class GetJabbedApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetJabbedApplication.class, args);
	}

	@Bean
	public CommandLineRunner testData(PersonRepository personRepository, AppointmentRepository appointmentRepository, VaccineRepository vaccineRepository){
		return args ->{
			Calendar calendar = Calendar.getInstance();
			calendar.set(2022,4,5);
			Appointment appointment = new Appointment(new Date(calendar.getTimeInMillis()),null,"location",false);
			Vaccine vaccine = new Vaccine("Pfizer",appointment);
			vaccineRepository.save(vaccine);
			appointmentRepository.save(appointment);
		};
	}
}
