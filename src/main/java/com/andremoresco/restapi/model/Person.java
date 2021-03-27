package com.andremoresco.restapi.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Person {

    public Person() {
    }

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public Person(Integer id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Integer id;

    @NotNull(message = "The field \"name\" is required")
    public String name;

    @NotNull(message = "The field \"brthdate\" is required")
    public LocalDate birthdate;

}
