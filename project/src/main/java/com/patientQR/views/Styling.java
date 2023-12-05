package com.patientQR.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Styling {
    // Colors
	
    private static Color backgroundColor = new Color(240, 240, 240);
    private static Color textColor = Color.BLACK;

    public static final Color BACKGROUND_COLOR = new Color(240, 240, 240);
    public static final Color LIGHT_BACKGROUND_COLOR = new Color(255, 255, 255);
    public static final Color DARK_BACKGROUND_COLOR = new Color(30, 144, 255);
    public static final Color TEXT_COLOR = Color.BLACK;
    public static final Color BUTTON_COLOR = new Color(30, 144, 255);
    public static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    // Fonts
    public static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font INPUT_FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);

    // Dimensions
    public static final Dimension INPUT_FIELD_SIZE = new Dimension(200, 30);
    public static final Dimension BUTTON_SIZE = new Dimension(120, 40);
    public static final Dimension LABEL_SIZE = new Dimension(150, 30);
    
    public static Color getBackgroundColor() {
        return backgroundColor;
    }

    public static void setBackgroundColor(Color newColor) {
        backgroundColor = newColor;
    }

    public static Color getTextColor() {
        return textColor;
    }

    public static void setTextColor(Color newColor) {
        textColor = newColor;
    }
}
