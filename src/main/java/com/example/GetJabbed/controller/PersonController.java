package com.example.GetJabbed.controller;

import com.example.GetJabbed.model.Person;
import com.example.GetJabbed.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
@Slf4j
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    //Register Person
    @PostMapping("/register")
    public Person registerPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

}
