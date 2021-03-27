package com.andremoresco.restapi.respository;

import com.andremoresco.restapi.exceptions.PersonNotFoundException;
import com.andremoresco.restapi.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class PersonRepository {

    private List<Person> people;

    public PersonRepository() {
        this.people = Stream.of(
                new Person(1, "Andre Moresco", LocalDate.of(1994, 4, 28)),
                new Person(2, "Fernanda", LocalDate.of(1992, 3, 7))
        ).collect(Collectors.toList());
    }

    public List<Person> all() {
        return people;
    }

    public Person findById(Integer id) {
        return people
                .stream()
                .filter(person -> Objects.equals(person.id, id))
                .findAny()
                .orElse(null);
    }

    public Person insert(Person person) {
        int maxId = getLastId();
        person.id = maxId+1;
        people.add(person);
        return person;
    }

    private int getLastId() {
        return people
                .stream()
                .mapToInt(value -> value.id)
                .max()
                .orElse(0);
    }

    public Person save(Person person) throws PersonNotFoundException {
        if (person.id == null) {
            return this.insert(person);
        } else {
            Person byId = findById(person.id);
            byId.birthdate = person.birthdate;
            byId.name = person.name;
            return byId;
        }
    }
}
