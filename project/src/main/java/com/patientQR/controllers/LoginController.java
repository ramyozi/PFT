package com.patientQR.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patientQR.entities.Patient;
import com.patientQR.models.UserCredentials;
import com.patientQR.repositories.PatientRepository;

@RestController
public class LoginController {

    @Autowired
    private PatientRepository patientRepository; // Assuming you have a PatientRepository

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials userCredentials) {
        // Retrieve patient by name and date of birth
        Patient patient = patientRepository.findByFirstNameAndDateOfBirth(
            userCredentials.getUsername(), userCredentials.getDateOfBirth());

        // Check if patient exists and allow login
        if (patient != null) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }
}