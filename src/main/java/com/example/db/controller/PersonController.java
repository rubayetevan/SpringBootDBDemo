package com.example.db.controller;

import com.example.db.model.Person;
import com.example.db.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v2/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person getPersonByID(@PathVariable Long id) {
        return personService.getPersonByID(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Person updatePersonByID(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePersonByID(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePersonByID(@PathVariable Long id) {
        personService.deletePersonByID(id);
    }


}
