package com.example.Form;

class AssignmentNotFoundException extends RuntimeException {

    AssignmentNotFoundException(Long id) {
        super("Could not find assignment " + id);
    }
}