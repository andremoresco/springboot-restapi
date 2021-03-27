package com.andremoresco.restapi.exceptions;

public class PersonNotFoundException extends Exception {

    private String type = "PERSON_NOT_FOUND";

    public PersonNotFoundException() {
        super("Person not found.");
    }

    public String getType() {
        return type;
    }
}
