import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class AddPatient {
    private JFrame frame;
    private JPanel cards;
    private CardLayout cardLayout;
    private JPanel personalInfoPanel;
    private JPanel radiologyPanel;
    private JPanel medicalAnalysisPanel;
    private JPanel chronicDiseasePanel;
    private JPanel allergyPanel;

    private JButton nextButton;
    private JButton previousButton;
    private JButton languageButton;

    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel dobLabel;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField addressField;
    private JTextField phoneNumberField;
    private JTextField socialSecurityField;
    private JTextField bloodGroupField;
    private JTextField lifestyleField;
    private JTextField familyHistoryField;

    private JComboBox<String> genderComboBox;

    private JCheckBox tobaccoCheckBox;
    private JCheckBox alcoholCheckBox;
    private JCheckBox drugsCheckBox;

    private JTextArea chronicDiseaseTextArea;
    private JTextArea medicationTextArea;

    private JRadioButton yesAllergyRadio;
    private JRadioButton noAllergyRadio;
    private ButtonGroup allergyButtonGroup;

    private JTextArea allergyTextArea;

    private JFileChooser fileChooser;

    private List<String> radiologyExams;
    private List<String> medicalAnalyses;
    private List<String> chronicDiseases;
    private List<String> medicationAllergies;
    
    private int currentCard = 0;
    private JPanel panel;

    public AddPatient() extends HospitalStyling {
        frame = new JFrame("Add Patient");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        cardLayout = new CardLayout();
        panel.setLayout(cardLayout);

        personalInfoPanel = createPersonalInfoPanel(); // Initialize the personal info panel

        // Initialize lists to hold information
        radiologyExams = new ArrayList<>();
        medicalAnalyses = new ArrayList<>();
        chronicDiseases = new ArrayList<>();
        medicationAllergies = new ArrayList<>();
        
        panel.add(personalInfoPanel, "personalInfo"); // Add personal info panel to the main panel

        frame.add(panel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCard++;
                if (currentCard < panel.getComponentCount()) {
                    cardLayout.show(panel, "panel" + currentCard);
                } else {
                    // savePatientData();
                    JOptionPane.showMessageDialog(frame, "Patient information submitted!");
                }
            }
        });

        frame.add(nextButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private JPanel createPersonalInfoPanel() {
        JPanel personalInfoPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        personalInfoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Adding labels and text fields for personal information
        JLabel nameLabel = new JLabel("Nom et Prénom:");
        personalInfoPanel.add(nameLabel);
        JTextField nameField = new JTextField();
        personalInfoPanel.add(nameField);

        JLabel dobLabel = new JLabel("Date de naissance:");
        personalInfoPanel.add(dobLabel);
        JTextField dobField = new JTextField();
        personalInfoPanel.add(dobField);

        JLabel addressLabel = new JLabel("Adresse:");
        personalInfoPanel.add(addressLabel);
        JTextField addressField = new JTextField();
        personalInfoPanel.add(addressField);

        JLabel genderLabel = new JLabel("Sexe:");
        personalInfoPanel.add(genderLabel);
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"","Homme", "Femme"});
        personalInfoPanel.add(genderComboBox);

        JLabel phoneLabel = new JLabel("Numéro de téléphone:");
        personalInfoPanel.add(phoneLabel);
        JTextField phoneField = new JTextField();
        personalInfoPanel.add(phoneField);

        JLabel socialSecurityLabel = new JLabel("Numéro de sécurité sociale:");
        personalInfoPanel.add(socialSecurityLabel);
        JTextField socialSecurityField = new JTextField();
        personalInfoPanel.add(socialSecurityField);

        JLabel bloodGroupLabel = new JLabel("Groupe sanguin:");
        personalInfoPanel.add(bloodGroupLabel);
        JComboBox<String> bloodGroupComboBox = new JComboBox<>(new String[]{"","A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        personalInfoPanel.add(bloodGroupComboBox);


        JLabel lifestyleLabel = new JLabel("Mode de vie:");
        personalInfoPanel.add(lifestyleLabel);
        JTextField lifestyleField = new JTextField();
        personalInfoPanel.add(lifestyleField);

        JLabel familyHistoryLabel = new JLabel("Facteurs de risques:");
        personalInfoPanel.add(familyHistoryLabel);
        JTextField familyHistoryField = new JTextField();
        personalInfoPanel.add(familyHistoryField);

        JButton languageButton = new JButton("Toggle Language");
        languageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleLanguage();
            }
        });
        personalInfoPanel.add(languageButton);
        HospitalStyling.applyStyle(personalInfoPanel);
        return personalInfoPanel;
    }



    private JPanel createRadiologyExamsPanel() {
        JPanel radiologyExamsPanel = new JPanel(new GridLayout(5, 1));
        // Create necessary fields for radiology exams section
        // Add these fields to the radiologyExamsPanel

        return radiologyExamsPanel;
    }

    private JPanel createMedicalAnalysesPanel() {
        JPanel medicalAnalysesPanel = new JPanel(new GridLayout(5, 1));
        // Create necessary fields for medical analyses section
        // Add these fields to the medicalAnalysesPanel

        return medicalAnalysesPanel;
    }

    private JPanel createChronicDiseasesPanel() {
        JPanel chronicDiseasesPanel = new JPanel(new GridLayout(5, 1));
        // Create necessary fields for chronic diseases section
        // Add these fields to the chronicDiseasesPanel

        return chronicDiseasesPanel;
    }

    private JPanel createMedicationAllergiesPanel() {
        JPanel medicationAllergiesPanel = new JPanel(new GridLayout(5, 1));
        // Create necessary fields for medication allergies section
        // Add these fields to the medicationAllergiesPanel

        return medicationAllergiesPanel;
    }

    
    private void toggleLanguage() {
        // Implement language toggle logic here
    }
    // Implement methods to collect and handle data entered by the user

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddPatient();
            }
        });
    }
}
