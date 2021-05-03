package com.example.People;

class PeopleNotFoundException extends RuntimeException {

    PeopleNotFoundException(Long id) {
        super("Could not find people " + id);
    }
}