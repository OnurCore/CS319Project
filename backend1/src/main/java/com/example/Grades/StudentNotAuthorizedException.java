package com.example.Grades;

class StudentNotAuthorizedException extends RuntimeException {

	public StudentNotAuthorizedException() {
        super("You are not authorized to make it");
    }
}