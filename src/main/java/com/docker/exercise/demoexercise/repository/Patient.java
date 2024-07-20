package com.docker.exercise.demoexercise.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String medicalExamination;
    private int daysUntilMedicalExamination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMedicalExamination() {
        return medicalExamination;
    }

    public void setMedicalExamination(String medicalExamination) {
        this.medicalExamination = medicalExamination;
    }

    public int getDaysUntilMedicalExamination() {
        return daysUntilMedicalExamination;
    }

    public void setDaysUntilMedicalExamination(int daysUntilMedicalExamination) {
        this.daysUntilMedicalExamination = daysUntilMedicalExamination;
    }
}
