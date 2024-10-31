package com.example.NewProject.controllers;

import com.example.NewProject.Domain.Person;
import com.example.NewProject.Domain.TransactionDetails;
import com.example.NewProject.Services.PersonDetailsService;
import com.example.NewProject.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/person")
public class PersonDetailsController {

    @Autowired
    private PersonDetailsService personDetailsService;

    @PostMapping("/create")
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO personDTO) throws Exception {

        Person person = new Person();

        person.setName(personDTO.getName());
        person.setDob(personDTO.getDob());


        personDetailsService.PersonDetail(person);
        return ResponseEntity.ok("Person details inserted successfully");
    }
}

