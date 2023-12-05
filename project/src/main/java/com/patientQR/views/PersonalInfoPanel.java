package com.patientQR.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PersonalInfoPanel extends JPanel {

	private JLabel titleLabel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel dobLabel;
	private JTextField dobField;
	private JLabel addressLabel;
	private JTextField addressField;
	private JLabel genderLabel;
	private JComboBox<String> genderComboBox;
	private JLabel phoneLabel;
	private JTextField phoneField;
	private JLabel socialSecurityLabel;
	private JTextField socialSecurityField;
	private JLabel bloodGroupLabel;
	private JComboBox<String> bloodGroupComboBox;
	private JLabel lifestyleLabel;
	private JTextField lifestyleField;
	private JLabel familyHistoryLabel;
	private JTextField familyHistoryField;
	private JButton nextButton;
	private JButton resetButton;

	public PersonalInfoPanel() {
		JPanel personalInfoPanel = new JPanel(
				new GridLayout(0, 2, 10, 10));
		personalInfoPanel.setBorder(
				BorderFactory.createEmptyBorder(20, 20, 20, 20));

		titleLabel = new JLabel("Informations personnelles");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);

		JPanel infoPanel = new JPanel(new GridLayout(0, 2, 10, 10));

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
		JComboBox<String> genderComboBox = new JComboBox<>(
				new String[] { "", "Homme", "Femme" });
		personalInfoPanel.add(genderComboBox);

		JLabel phoneLabel = new JLabel("Numéro de téléphone:");
		personalInfoPanel.add(phoneLabel);
		JTextField phoneField = new JTextField();
		personalInfoPanel.add(phoneField);

		JLabel socialSecurityLabel = new JLabel(
				"Numéro de sécurité sociale:");
		personalInfoPanel.add(socialSecurityLabel);
		JTextField socialSecurityField = new JTextField();
		personalInfoPanel.add(socialSecurityField);

		JLabel bloodGroupLabel = new JLabel("Groupe sanguin:");
		personalInfoPanel.add(bloodGroupLabel);
		JComboBox<String> bloodGroupComboBox = new JComboBox<>(
				new String[] { "", "A+", "A-", "B+", "B-", "AB+", "AB-",
						"O+", "O-" });
		personalInfoPanel.add(bloodGroupComboBox);

		JLabel lifestyleLabel = new JLabel("Mode de vie:");
		personalInfoPanel.add(lifestyleLabel);
		JTextField lifestyleField = new JTextField();
		personalInfoPanel.add(lifestyleField);

		JLabel familyHistoryLabel = new JLabel("Facteurs de risques:");
		personalInfoPanel.add(familyHistoryLabel);
		JTextField familyHistoryField = new JTextField();
		personalInfoPanel.add(familyHistoryField);
		
        add(infoPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        nextButton = new JButton("Next");
        buttonPanel.add(nextButton);

        resetButton = new JButton("Reset");
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);

	}
}
