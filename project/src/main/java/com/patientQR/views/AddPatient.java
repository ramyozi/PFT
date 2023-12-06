package com.patientQR.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

public class AddPatient {
	private JFrame frame;
	private JPanel examsListPanel = new JPanel();
	private JPanel diseasesListPanel = new JPanel();
	private JTextField diseaseNameField;
	private JComboBox<String> examTypeComboBox;
    private JTextField examFileField;
    private SpinnerDateModel model;
    
    public AddPatient() {
        frame = new JFrame("Ajouter un patient");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Informations personnelles");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        JTextField nameField = new JTextField(); // Create fields to hold user input
        JTextField dobField = new JTextField();
        JTextField addressField = new JTextField();
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"", "Homme", "Femme"});
        JTextField phoneField = new JTextField();
        JTextField socialSecurityField = new JTextField();
        JComboBox<String> bloodGroupField = new JComboBox<>(new String[]{"", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        JTextField lifestyleField = new JTextField();
        JTextField riskFactorsField = new JTextField();

        formPanel.add(new JLabel("Nom et Prénom:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Date de naissance:"));
        formPanel.add(dobField);

        formPanel.add(new JLabel("Adresse:"));
        formPanel.add(addressField);

        formPanel.add(new JLabel("Sexe:"));
        formPanel.add(genderComboBox);

        formPanel.add(new JLabel("Numéro de téléphone:"));
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Numéro de sécurité sociale:"));
        formPanel.add(socialSecurityField);

        formPanel.add(new JLabel("Groupe sanguin:"));
        formPanel.add(bloodGroupField);

        formPanel.add(new JLabel("Mode de vie:"));
        formPanel.add(lifestyleField);

        formPanel.add(new JLabel("Facteurs de risques:"));
        formPanel.add(riskFactorsField);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(createRadiologyExamsPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(nextButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

	private JPanel createRadiologyExamsPanel() {
        JPanel radiologyExamsPanel = new JPanel(new BorderLayout());
        radiologyExamsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel addExamPanel = new JPanel();
        addExamPanel.setLayout(new BoxLayout(addExamPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Examens de radiologie");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addExamPanel.add(titleLabel);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        examTypeComboBox = new JComboBox<>(new String[]{"", "Radiographie", "TDM", "IRM", "Scintigraphie"});
        examFileField = new JTextField(20);

        JButton importButton = new JButton("Sélectionner un fichier PDF");
        importButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(radiologyExamsPanel);

            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                examFileField.setText(filePath);
            }
        });

        model = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(editor);

        JButton addButton = new JButton("Ajouter un examen");
        addButton.addActionListener(e -> {
            String examType = (String) examTypeComboBox.getSelectedItem();
            String examFile = examFileField.getText();
            String importDate = editor.getFormat().format(model.getDate());
            addNewExam(examType, examFile, importDate);
            clearFields();
        });

        inputPanel.add(new JLabel("Type: "));
        inputPanel.add(examTypeComboBox);
        inputPanel.add(new JLabel("Fichier: "));
        inputPanel.add(examFileField);
        inputPanel.add(importButton);
        inputPanel.add(new JLabel("Date: "));
        inputPanel.add(dateSpinner);
        inputPanel.add(addButton);

        addExamPanel.add(inputPanel);
        radiologyExamsPanel.add(addExamPanel, BorderLayout.NORTH);

        examsListPanel = new JPanel();
        examsListPanel.setLayout(new BoxLayout(examsListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(examsListPanel);
        radiologyExamsPanel.add(scrollPane, BorderLayout.CENTER);

        JButton nextButton = new JButton("Suivant");
        nextButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.add(createMedicalAnalysesPanel());
            frame.revalidate();
            frame.repaint();
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(nextButton);
        radiologyExamsPanel.add(nextButton, BorderLayout.SOUTH);

        return radiologyExamsPanel;
    }

    private void addNewExam(String examType, String examFile, String importDate) {
        JPanel examPanel = new JPanel();
        examPanel.setLayout(new BoxLayout(examPanel, BoxLayout.Y_AXIS));

        JLabel examLabel = new JLabel("Type: " + examType);
        JLabel fileLabel = new JLabel("Fichier: " + examFile);
        JLabel dateLabel = new JLabel("Date: " + importDate);

        examPanel.add(examLabel);
        examPanel.add(fileLabel);
        examPanel.add(dateLabel);
        examPanel.setBorder(BorderFactory.createEtchedBorder());

        examsListPanel.add(examPanel);
        examsListPanel.revalidate();
        examsListPanel.repaint();
    }

    private void clearFields() {
        diseaseNameField.setText("");
        Calendar calendar = Calendar.getInstance();
        calendar.set(0, Calendar.JANUARY, 0);
        model.setValue(calendar.getTime());

    }

    private JPanel createMedicalAnalysesPanel() {
        JPanel medicalAnalysesPanel = new JPanel(new GridLayout(5, 1));

        JLabel titleLabel = new JLabel("Analyses médicales");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        medicalAnalysesPanel.add(titleLabel); // Adding the title label

        JButton nextButton = new JButton("Suivant");
        nextButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.add(createChronicDiseasesPanel());
            frame.revalidate();
            frame.repaint();
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(nextButton);
        medicalAnalysesPanel.add(nextButton); // Add the button to the panel

        return medicalAnalysesPanel;
    }


	

	private JPanel createChronicDiseasesPanel() {
	    JPanel chronicDiseasesPanel = new JPanel(new BorderLayout());
	    chronicDiseasesPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	    JPanel addDiseasePanel = new JPanel();
	    addDiseasePanel.setLayout(new BoxLayout(addDiseasePanel, BoxLayout.Y_AXIS));

	    JLabel titleLabel = new JLabel("Maladie chronique");
	    titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
	    titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    addDiseasePanel.add(titleLabel);

	    JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

	    diseaseNameField = new JTextField(20);

	    JButton addButton = new JButton("Ajouter une maladie");
	    addButton.addActionListener(e -> {
	        String diseaseName = diseaseNameField.getText();
	        addNewDisease(diseaseName);
	        clearFields();
	    });

	    inputPanel.add(new JLabel("La maladie:"));
	    inputPanel.add(diseaseNameField);
	    inputPanel.add(addButton);

	    addDiseasePanel.add(inputPanel);
	    chronicDiseasesPanel.add(addDiseasePanel, BorderLayout.NORTH);

	    diseasesListPanel = new JPanel();
	    diseasesListPanel.setLayout(new BoxLayout(diseasesListPanel, BoxLayout.Y_AXIS));
	    JScrollPane scrollPane = new JScrollPane(diseasesListPanel);
	    chronicDiseasesPanel.add(scrollPane, BorderLayout.CENTER);

	    JButton nextButton = new JButton("Suivant");
	    nextButton.addActionListener(e -> {
	        frame.getContentPane().removeAll();
	        frame.add(createAllergiesPanel());
	        frame.revalidate();
	        frame.repaint();
	    });
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(nextButton);
	    chronicDiseasesPanel.add(nextButton, BorderLayout.SOUTH);

	    return chronicDiseasesPanel;
	}

	private void addNewDisease(String diseaseName) {
	    JPanel diseasePanel = new JPanel();
	    diseasePanel.setLayout(new BoxLayout(diseasePanel, BoxLayout.Y_AXIS));

	    JLabel diseaseLabel = new JLabel("Disease Name: " + diseaseName);

	    diseasePanel.add(diseaseLabel);
	    diseasePanel.setBorder(BorderFactory.createEtchedBorder());

	    diseasesListPanel.add(diseasePanel);
	    diseasesListPanel.revalidate();
	    diseasesListPanel.repaint();
	}

	
	private JPanel createAllergiesPanel() {
	    JPanel allergiesPanel = new JPanel(new GridLayout(5, 1));

	    JLabel titleLabel = new JLabel("Allergie médicamenteuses");
	    titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
	    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    allergiesPanel.add(titleLabel);

	    JButton nextButton = new JButton("Suivant");
	    nextButton.addActionListener(e -> {
	        frame.getContentPane().removeAll();
	        frame.add(recapitulatifPanel());
	        frame.revalidate();
	        frame.repaint();
	    });
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(nextButton);
	    allergiesPanel.add(nextButton, BorderLayout.SOUTH);
	    
		return allergiesPanel;
	}
	
	
	private JPanel recapitulatifPanel() {
        JPanel recapitulatifPanel = new JPanel(new BorderLayout());
        recapitulatifPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Recapitulatif");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        recapitulatifPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        JScrollPane scrollPane = new JScrollPane(infoPanel);
        recapitulatifPanel.add(scrollPane, BorderLayout.CENTER);

        JButton validateButton = new JButton("Valider");
        validateButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Validation successful!", "Validation", JOptionPane.INFORMATION_MESSAGE);
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(validateButton);
        recapitulatifPanel.add(buttonPanel, BorderLayout.SOUTH);

        return recapitulatifPanel;
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
