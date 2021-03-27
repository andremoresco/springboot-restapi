package com.andremoresco.restapi.service;

import com.andremoresco.restapi.model.Person;
import com.andremoresco.restapi.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> all() {
        return personRepository.all();
    }

    public Person get(Integer id) {
        return personRepository.findById(id);
    }

    public Person insert(Person person) {
        return personRepository.insert(person);
    }
}
