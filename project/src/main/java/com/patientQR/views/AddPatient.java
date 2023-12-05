package com.patientQR.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class AddPatient extends Styling{
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

    private JLabel titleLabel = new JLabel();
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
    
    private Color backgroundColor = Styling.getBackgroundColor();
    private Color textColor = Styling.getTextColor();


    public AddPatient(){

        frame = new JFrame("Add Patient");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        
        frame.setLocationRelativeTo(null);

        personalInfoPanel = createPersonalInfoPanel(); 
        frame.getContentPane().setBackground(backgroundColor);
        titleLabel.setForeground(textColor);

        

        radiologyExams = new ArrayList<>();
        medicalAnalyses = new ArrayList<>();
        chronicDiseases = new ArrayList<>();
        medicationAllergies = new ArrayList<>();
        
        panel.add(personalInfoPanel, "personalInfo");

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
        JPanel personalInfoPanel = new JPanel(new GridBagLayout());
        personalInfoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;

        JLabel titleLabel = new JLabel("Informations personnelles");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridwidth = 2;
        personalInfoPanel.add(titleLabel, gbc);

        addLabelAndField("Nom et Prénom:", new JTextField(), personalInfoPanel, gbc);
        addLabelAndField("Date de naissance:", new JTextField(), personalInfoPanel, gbc);
        addLabelAndField("Adresse:", new JTextField(), personalInfoPanel, gbc);
        addLabelAndField("Sexe:", new JComboBox<>(new String[]{"", "Homme", "Femme"}), personalInfoPanel, gbc);
        addLabelAndField("Numéro de téléphone:", new JTextField(), personalInfoPanel, gbc);
        addLabelAndField("Numéro de sécurité sociale:", new JTextField(), personalInfoPanel, gbc);
        addLabelAndField("Groupe sanguin:", new JComboBox<>(new String[]{"", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}), personalInfoPanel, gbc);
        addLabelAndField("Mode de vie:", new JTextField(), personalInfoPanel, gbc);
        addLabelAndField("Facteurs de risques:", new JTextField(), personalInfoPanel, gbc);

        JButton languageButton = new JButton("Toggle Language");
        languageButton.addActionListener(e -> toggleLanguage());
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        personalInfoPanel.add(languageButton, gbc);

        return personalInfoPanel;
    }

    private void addLabelAndField(String labelText, JComponent component, JPanel panel, GridBagConstraints gbc) {
        JLabel label = new JLabel(labelText);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(component, gbc);
    }




    private JPanel createRadiologyExamsPanel() {
        JPanel radiologyExamsPanel = new JPanel(new GridLayout(5, 1));

        return radiologyExamsPanel;
    }

    private JPanel createMedicalAnalysesPanel() {
        JPanel medicalAnalysesPanel = new JPanel(new GridLayout(5, 1));

        return medicalAnalysesPanel;
    }

    private JPanel createChronicDiseasesPanel() {
        JPanel chronicDiseasesPanel = new JPanel(new GridLayout(5, 1));

        return chronicDiseasesPanel;
    }

    private JPanel createMedicationAllergiesPanel() {
        JPanel medicationAllergiesPanel = new JPanel(new GridLayout(5, 1));

        return medicationAllergiesPanel;
    }

    
    private void toggleLanguage() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddPatient();
            }
        });
    }
}
