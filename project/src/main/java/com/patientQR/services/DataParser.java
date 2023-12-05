package com.patientQR.services;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.patientQR.entities.Patient;

import jakarta.annotation.PostConstruct;

@Component
public class DataParser {

	private final PatientService patientService;
	private final ResourceLoader resourceLoader;
	private List<Patient> patients;

	@Autowired
	public DataParser(PatientService patientService,
			ResourceLoader resourceLoader) {
		this.patientService = patientService;
		this.resourceLoader = resourceLoader;
		this.patients = new ArrayList<>();

	}

	@PostConstruct
	@Transactional
	public void parseCSVAndSavePatients() {
		try {
			var resource = resourceLoader
					.getResource("classpath:data/patients.csv");
			System.out.println("ressource: " + resource);
			var inputStream = resource.getInputStream();
			var br = new BufferedReader(
					new InputStreamReader(inputStream));
			String line;
			String delimiter = ";";
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] data = line.split(delimiter);

				Patient patient = new Patient();
				patient.setFirstName(data[1]);
				patient.setLastName(data[0]);
				patient.setDateOfBirth(data[2]);
				patient.setAddress(data[3]);
				patient.setGender(data[4]);
				patient.setPhoneNumber(data[5]);
				patient.setSocialSecurityNumber(data[6]);
				patient.setBloodGroup(data[7]);
				patient.setLifestyle(data[8]);
				patient.setFamilyHistory(data[9]);
//--------------------------------------------------------------

//	            String[] radiologyExamsData = data[10].split(",");
//	            Map<String, String> radiologyExams = new HashMap<>();
//
//	            for (String exam : radiologyExamsData) {
//	                String[] examParts = exam.split(":");
//	                if (examParts.length == 2) {
//	                    radiologyExams.put(examParts[0].trim(), examParts[1].trim());
//	                }
//	            }
//	            patient.setRadiologyExams(radiologyExams);

	            patient.setRadiologyExams(
						Arrays.asList(data[10].split(",")));
//------------------------------------------------------------				
				patient.setMedicalAnalyses(
						Arrays.asList(data[11].split(",")));
				patient.setChronicDiseases(Arrays.asList(data[12]));
				patient.setCurrentMedications(data[13]);
				patient.setHasMedicationAllergy(
						Boolean.parseBoolean(data[14]));

				patients.add(patient);
				patientService.savePatient(patient);
			}
			br.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Patient> getPatients() {
		return patients;
	}
}
