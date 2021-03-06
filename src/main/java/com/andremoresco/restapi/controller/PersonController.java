package com.andremoresco.restapi.controller;

import com.andremoresco.restapi.exceptions.PersonNotFoundException;
import com.andremoresco.restapi.model.Person;
import com.andremoresco.restapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/person", produces = "application/json", consumes = "application/json")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> find() {
        return personService.all();
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable("id") Integer id) {
        return personService.get(id);
    }

    @PostMapping
    public Person insert(@RequestBody @Valid Person person) {
        return personService.insert(person);
    }

    @PutMapping("/{id}")
    public Person change(@PathVariable("id") Integer id, @RequestBody @Valid Person person) throws PersonNotFoundException {
        return personService.change(id, person);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer id) throws PersonNotFoundException {
        return personService.delete(id);
    }

}
