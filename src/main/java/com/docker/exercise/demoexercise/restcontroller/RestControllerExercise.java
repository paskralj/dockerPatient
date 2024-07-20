package com.docker.exercise.demoexercise.restcontroller;

import com.docker.exercise.demoexercise.repository.Patient;
import com.docker.exercise.demoexercise.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestControllerExercise {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add/patient")
    public ResponseEntity<HttpStatus> addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
