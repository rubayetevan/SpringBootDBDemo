package com.example.db.service;

import com.example.db.model.Person;
import com.example.db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void deletePersonByID(Long id) {
        personRepository.deleteById(id);
    }

    public Person updatePersonByID(Long id, Person newPerson) {
        Optional<Person> personMayBe = getPersonByID(id);
        if (!personMayBe.isPresent()) {
            throw new IllegalStateException("Person not found");
        }
        Person personToBeUpdated = personMayBe.get();
        personToBeUpdated.setEmail(newPerson.getEmail());
        personToBeUpdated.setMobileNumber(newPerson.getMobileNumber());
        personToBeUpdated.setName(newPerson.getName());
        return personRepository.save(personToBeUpdated);
    }

    public Optional<Person> getPersonByID(Long id) {
        return personRepository.findById(id);
    }


}
