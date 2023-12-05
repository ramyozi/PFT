package com.patientQR.entities;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "social_security_number")
    private String socialSecurityNumber;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "lifestyle")
    private String lifestyle; // Tabac, alcool, drogue...

    @Column(name = "family_history")
    private String familyHistory; // Antécédents familiaux

    // Examen radiologique
    @ElementCollection
    @CollectionTable(name = "radiology_exams", joinColumns = @JoinColumn(name = "patient_id"))
    @MapKeyColumn(name = "exam_title")
    @Column(name = "exam_document", columnDefinition = "LONGBLOB")
    private Map<String, byte[]> radiologyExams; // Titre du document et son contenu binaire

    // Analyses médicales
    @ElementCollection
    @CollectionTable(name = "medical_analyses", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "analysis")
    private List<String> medicalAnalyses; // Types d’analyses

    // Maladie chronique
    @ElementCollection
    @CollectionTable(name = "chronic_diseases", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "disease")
    private List<String> chronicDiseases; // Maladies chroniques

    @Column(name = "current_medications")
    private String currentMedications; // Médicaments en cours de traitement

    @Column(name = "has_medication_allergy")
    private boolean hasMedicationAllergy; // Allergie médicamenteuse

    // Allergies médicamenteuses
    @ElementCollection
    @CollectionTable(name = "medication_allergies", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "medication")
    private List<String> medicationAllergies; // Types de médicaments pour les allergies

	/** Constructeur
	 * 
	 */
	public Patient() {
		super();
	}

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** Getter
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/** Setter
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** Getter
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/** Setter
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** Getter
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/** Setter
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/** Getter
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/** Setter
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** Getter
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/** Setter
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/** Getter
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/** Setter
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/** Getter
	 * @return the socialSecurityNumber
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/** Setter
	 * @param socialSecurityNumber the socialSecurityNumber to set
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	/** Getter
	 * @return the bloodGroup
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/** Setter
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/** Getter
	 * @return the lifestyle
	 */
	public String getLifestyle() {
		return lifestyle;
	}

	/** Setter
	 * @param lifestyle the lifestyle to set
	 */
	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle;
	}

	/** Getter
	 * @return the familyHistory
	 */
	public String getFamilyHistory() {
		return familyHistory;
	}

	/** Setter
	 * @param familyHistory the familyHistory to set
	 */
	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	

	/** Getter
	 * @return the medicalAnalyses
	 */
	public List<String> getMedicalAnalyses() {
		return medicalAnalyses;
	}

	/** Setter
	 * @param medicalAnalyses the medicalAnalyses to set
	 */
	public void setMedicalAnalyses(List<String> medicalAnalyses) {
		this.medicalAnalyses = medicalAnalyses;
	}

	/** Getter
	 * @return the chronicDiseases
	 */
	public List<String> getChronicDiseases() {
		return chronicDiseases;
	}

	/** Setter
	 * @param chronicDiseases the chronicDiseases to set
	 */
	public void setChronicDiseases(List<String> chronicDiseases) {
		this.chronicDiseases = chronicDiseases;
	}

	/** Getter
	 * @return the currentMedications
	 */
	public String getCurrentMedications() {
		return currentMedications;
	}

	/** Setter
	 * @param currentMedications the currentMedications to set
	 */
	public void setCurrentMedications(String currentMedications) {
		this.currentMedications = currentMedications;
	}

	/** Getter
	 * @return the hasMedicationAllergy
	 */
	public boolean isHasMedicationAllergy() {
		return hasMedicationAllergy;
	}

	/** Setter
	 * @param hasMedicationAllergy the hasMedicationAllergy to set
	 */
	public void setHasMedicationAllergy(boolean hasMedicationAllergy) {
		this.hasMedicationAllergy = hasMedicationAllergy;
	}

	/** Getter
	 * @return the medicationAllergies
	 */
	public List<String> getMedicationAllergies() {
		return medicationAllergies;
	}

	/** Setter
	 * @param medicationAllergies the medicationAllergies to set
	 */
	public void setMedicationAllergies(List<String> medicationAllergies) {
		this.medicationAllergies = medicationAllergies;
	}

	/** Getter
	 * @return the radiologyExams
	 */
	public Map<String, byte[]> getRadiologyExams() {
		return radiologyExams;
	}

	/** Setter
	 * @param radiologyExams the radiologyExams to set
	 */
	public void setRadiologyExams(Map<String, byte[]> radiologyExams) {
		this.radiologyExams = radiologyExams;
	}
}
