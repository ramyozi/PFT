package com.patientQR.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientQR.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	 // Method to find a patient by ID
    Patient findById(long id);

    // Method to find a Patient by first name and date of birth
    Patient findByFirstNameAndDateOfBirth(String firstName, String dateOfBirth);
    
    // Method to find patients by first name
    List<Patient> findByFirstName(String firstName);

    // Method to find patients by last name
    List<Patient> findByLastName(String lastName);

    // Method to find patients by gender
    List<Patient> findByGender(String gender);

    // Method to find patients by date of birth
    List<Patient> findByDateOfBirth(String dateOfBirth);

    // Method to find patients by blood group
    List<Patient> findByBloodGroup(String bloodGroup);

    // Method to find patients with a specific chronic disease
    List<Patient> findByChronicDiseasesContaining(String disease);

    // Method to find patients without any chronic diseases
    List<Patient> findByChronicDiseasesEmpty();

    // Method to find patients with medication allergies
    List<Patient> findByHasMedicationAllergyTrue();

    // Method to find patients with no medication allergies
    List<Patient> findByHasMedicationAllergyFalse();
}
