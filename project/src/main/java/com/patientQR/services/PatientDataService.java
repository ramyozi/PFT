package com.patientQR.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patientQR.entities.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class PatientDataService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void savePatientsFromParser(DataParser dataParser) {
        dataParser.parseCSVAndSavePatients();

        for (Patient patient : dataParser.getPatients()) {
            entityManager.persist(patient);
        }
    }
}
