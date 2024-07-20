package com.docker.exercise.demoexercise.exceptions;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(String message){
        super(message);
    }
}
