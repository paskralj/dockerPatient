package com.docker.exercise.demoexercise.restcontroller;

import com.docker.exercise.demoexercise.exceptions.PatientNotFoundException;
import com.docker.exercise.demoexercise.repository.Patient;
import com.docker.exercise.demoexercise.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/show/all")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients,HttpStatus.OK);
    }

    @DeleteMapping("delete/patient/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<HttpStatus> updatePatient(@PathVariable Long id, @RequestBody Patient updatePatient){
        Optional<Patient> optionalPatient = patientService.findPatientById(id);
        if (optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            patient.setFirstName(updatePatient.getFirstName());
            patient.setLastName(updatePatient.getLastName());
            patient.setMedicalExamination(updatePatient.getMedicalExamination());
            patient.setDaysUntilMedicalExamination(updatePatient.getDaysUntilMedicalExamination());
            patientService.addPatient(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } else throw new PatientNotFoundException("Patient not found");
    }

}
