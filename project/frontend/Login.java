import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.MaskFormatter;

public class Login {
    private JFrame frame;
    private JTextField usernameField;
    private JFormattedTextField dobField;
    private JLabel languageLabel;
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel dobLabel;
    private JButton loginButton;

    public Login() {
        frame = new JFrame("Login");
        frame.setSize(400, 300); // Set initial frame size
        centerFrameOnScreen(frame);

        titleLabel = new JLabel("Connexion");
        usernameLabel = new JLabel("Nom d'utilisateur:");
        dobLabel = new JLabel("Date de naissance:");

        loginButton = new JButton("Se connecter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(30, 144, 255));

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        languageLabel = new JLabel("Language: French");
        languageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        languageLabel.setForeground(Color.WHITE);
        languageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        languageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleLanguage();
            }
        });
        topPanel.add(languageLabel, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(240, 240, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(usernameLabel, gbc);

        usernameField = new JTextField(15);
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(usernameField, gbc);

        dobLabel.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(dobLabel, gbc);

        dobField = new JFormattedTextField(createFormatter("####-##-##"));
        dobField.setToolTipText("YYYY-MM-DD");
        dobField.setColumns(15);
        dobField.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(dobField, gbc);

        loginButton.setBackground(new Color(30, 144, 255));
        loginButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        centerPanel.add(loginButton, gbc);

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private MaskFormatter createFormatter(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
            formatter.setPlaceholderCharacter('_');
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }

    private void toggleLanguage() {
        if (languageLabel.getText().equals("Language: French")) {
            languageLabel.setText("اللغة: العربية");
            titleLabel.setText("تسجيل الدخول");
            usernameLabel.setText("اسم المستخدم:");
            dobLabel.setText("تاريخ الميلاد:");
            loginButton.setText("تسجيل الدخول");

            // Align labels to the right for Arabic
            usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            dobLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        } else {
            languageLabel.setText("Language: French");
            titleLabel.setText("Connexion");
            usernameLabel.setText("Nom d'utilisateur:");
            dobLabel.setText("Date de naissance:");
            loginButton.setText("Se connecter");

            // Align labels to the left for French
            usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            dobLabel.setHorizontalAlignment(SwingConstants.LEFT);
        }

        // Refresh the frame to apply the changes
        frame.revalidate();
        frame.repaint();
    }

    private void centerFrameOnScreen(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        frame.setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}
