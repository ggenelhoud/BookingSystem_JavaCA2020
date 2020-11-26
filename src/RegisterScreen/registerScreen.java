package RegisterScreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registerScreen extends JFrame implements ActionListener {

    JTextField nameField, emailField, phoneField, passwordField, repasswordField;
    JButton register;
    private String[] locations = {"Grafton Street", "Candem Street", "O'Connell Street"};

    public static void main(String[] args) {
        new registerScreen();
    }

    public registerScreen() {
        //this.setSize(650, 830);
        this.setMinimumSize(new Dimension(650, 690));
        this.setTitle("Grafton Barber - Create an User Account");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        //mainPanel.setBackground(Color.red);
        this.add(mainPanel);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 17));
        nameLabel.setBounds(20, 90, 80, 25);// dimensions are based in: x, y, width, height
        mainPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 90, 375, 30);
        nameField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        mainPanel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 17));
        emailLabel.setBounds(20, 150, 80, 25);// dimensions are based in: x, y, width, height
        mainPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        emailField.setBounds(180, 150, 375, 30);
        mainPanel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone Number:", JLabel.LEFT);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 17));
        phoneLabel.setBounds(20, 210, 120, 25);
        mainPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        phoneField.setBounds(180, 210, 375, 30);
        mainPanel.add(phoneField);

        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Arial", Font.BOLD, 17));
        password.setBounds(20, 270, 160, 30);
        mainPanel.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 270, 375, 30);
        mainPanel.add(passwordField);

        JLabel repassword = new JLabel("Re-enter Password:");
        repassword.setFont(new Font("Arial", Font.BOLD, 17));
        repassword.setBounds(20, 330, 160, 30);
        mainPanel.add(repassword);

        repasswordField = new JPasswordField();
        repasswordField.setBounds(180, 330, 375, 30);
        mainPanel.add(repasswordField);

        GridLayout bottomLayout = new GridLayout(1, 1);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.red);
        bottomPanel.setLayout(bottomLayout);

        JLabel location = new JLabel("Store Location:");
        location.setFont(new Font("Arial", Font.BOLD, 17));
        location.setBounds(20, 390, 160, 30);
        mainPanel.add(location);

        JComboBox locationBox = new JComboBox(locations);
        locationBox.setBounds(180, 390, 377, 35);
        locationBox.setBackground(Color.LIGHT_GRAY);
        locationBox.setSelectedIndex(0);
        mainPanel.add(locationBox);

        register = new JButton("Register");
        register.setBounds(280, 470, 150, 80);
        register.addActionListener(this);
        mainPanel.add(register);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String email = emailField.getText();
        String mobile = phoneField.getText();
        String password = passwordField.getText();
        String repassword = repasswordField.getText();
        int mobileLen =  mobile.length();
        int passLen = password.length();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty!!!");
        }
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You must enter email address.");
        }
        if (mobileLen < 9 || mobileLen > 10) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number.");
        }

        if (passLen < 8) {
            JOptionPane.showMessageDialog(this, "Password must be AT LEAST 8 characters long!!!");
        }
        if (repassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You must re-enter your password.");
        }
        if (!password.equals(repassword)) {
            JOptionPane.showMessageDialog(this, "Passwords does not match!!!");
        }
        System.out.println(password);
        System.out.println(repassword);

        try {
            String dbServer = "jdbc:mysql://apontejaj.com:3306/Gabriel_2019386?useSSL=false";
            String dbUser = "Gabriel_2019386";
            String dbPassword = "2019386";
            String query = "INSERT INTO user values('" + name + "','" + password + "','" + email + "')";

            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);
            Statement stmt = conn.createStatement();
            int x = stmt.executeUpdate(query);
            if (x == 0) {
                JOptionPane.showMessageDialog(this, "This is alredy exist");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Welcome, Your account is sucessfully created");
            }

            stmt.close();
            conn.close();
        } catch (Exception d) {
            System.out.println(d);
        }
    }
    

    public String getNameField() {
        return nameField.getText();
    }

    public String getEmailField() {
        return emailField.getText();
    }

    public String getPhoneField() {
        return phoneField.getText();
    }

    public String getPasswordField() {
        return passwordField.getText();
    }

    public String getRePassword() {
        return repasswordField.getText();
    }
}
