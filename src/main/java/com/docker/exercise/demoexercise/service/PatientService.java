package com.docker.exercise.demoexercise.service;

import com.docker.exercise.demoexercise.exceptions.PatientNotFoundException;
import com.docker.exercise.demoexercise.repository.Patient;
import com.docker.exercise.demoexercise.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> findPatientById(Long id){
        return patientRepository.findById(id);
    }

    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }

    public void deletePatientById(Long id){
        if (patientRepository.findById(id).isPresent()){
            patientRepository.deleteById(id);
        } else throw new PatientNotFoundException("Patient with id: " + id + " doesn't exist. ");
    }
}
