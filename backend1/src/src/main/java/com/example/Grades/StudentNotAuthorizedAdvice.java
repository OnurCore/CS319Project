package com.example.Grades;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class StudentNotAuthorizedAdvice {

    @ResponseBody
    @ExceptionHandler(StudentNotAuthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String StudentNotAuthorizedHandler(StudentNotAuthorizedException ex) {
        return ex.getMessage();
    }
}