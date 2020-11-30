package RegisterScreen;

import controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class registerScreen extends JFrame implements ActionListener {

    JTextField fnameField, lnameField, emailField, phoneField, passwordField, repasswordField, usernameField;
    JLabel adminLabel, storeLocation;
    JButton register;
    Controller controller;
    JRadioButton adminButton, userButton;
    JComboBox locationBox;
    ButtonGroup group;
    private String[] locations = {"Grafton Street", "Candem Street", "O'Connell Street"};

    public registerScreen(Controller controller) {

        this.controller = controller;
        new registerScreen();

    }

    public registerScreen() {
        //this.setSize(650, 830);
        this.setMinimumSize(new Dimension(650, 800));
        this.setResizable(false);
        this.setTitle("Grafton Barber - Create an User Account");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        this.add(mainPanel);
        
        adminLabel = new JLabel("Select registration mode:");
        adminLabel.setForeground(Color.RED);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 17));
        adminLabel.setBounds(10, 40, 220, 25);
        mainPanel.add(adminLabel);
        
        userButton = new JRadioButton("User");
        userButton.setBounds(213, 38, 60, 35);
        userButton.addActionListener(this);
        userButton.setSelected(false);
        mainPanel.add(userButton);   

        adminButton = new JRadioButton("Admin");
        adminButton.setBounds(270, 38, 80, 35);
        adminButton.addActionListener(this);
        adminButton.setSelected(false);
        mainPanel.add(adminButton);
        
        group = new ButtonGroup();
        group.add(userButton);
        group.add(adminButton);
        
        JLabel fname = new JLabel("First Name:");
        fname.setFont(new Font("Arial", Font.BOLD, 17));
        fname.setBounds(20, 105, 110, 30);// dimensions are based in: x, y, width, height
        mainPanel.add(fname);

        fnameField = new JTextField();
        fnameField.setBounds(180, 105, 375, 30);
        fnameField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        mainPanel.add(fnameField);
        
        JLabel lname = new JLabel("Last Name:");
        lname.setFont(new Font("Arial", Font.BOLD, 17));
        lname.setBounds(20, 165, 90, 30);// dimensions are based in: x, y, width, height
        mainPanel.add(lname);
        
        lnameField = new JTextField();
        lnameField.setBounds(180, 165, 375, 30);
        lnameField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        mainPanel.add(lnameField);
        
        JLabel username = new JLabel("Username:");
        username.setFont(new Font("Arial", Font.BOLD, 17));
        username.setBounds(20, 225, 110, 30);// dimensions are based in: x, y, width, height
        mainPanel.add(username);

        usernameField = new JTextField();
        usernameField.setBounds(180, 225, 375, 30);
        usernameField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        mainPanel.add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 17));
        emailLabel.setBounds(20, 285, 80, 25);// dimensions are based in: x, y, width, height
        mainPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        emailField.setBounds(180, 285, 375, 30);
        mainPanel.add(emailField);

        JLabel phoneLabel = new JLabel("Mobile no.:", JLabel.LEFT);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 17));
        phoneLabel.setBounds(20, 345, 120, 30);
        mainPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        phoneField.setBounds(180, 345, 375, 30);
        mainPanel.add(phoneField);

        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Arial", Font.BOLD, 17));
        password.setBounds(20, 405, 160, 30);
        mainPanel.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 405, 375, 30);
        mainPanel.add(passwordField);

        JLabel repassword = new JLabel("Re-enter Password:");
        repassword.setFont(new Font("Arial", Font.BOLD, 17));
        repassword.setBounds(20, 465, 160, 30);
        mainPanel.add(repassword);

        repasswordField = new JPasswordField();
        repasswordField.setBounds(180, 465, 375, 30);
        mainPanel.add(repasswordField);

        storeLocation = new JLabel("Store Location:");
        storeLocation.setFont(new Font("Arial", Font.BOLD, 17));
        storeLocation.setBounds(20, 525, 160, 30);
        mainPanel.add(storeLocation).setVisible(false);

        locationBox = new JComboBox(locations);
        locationBox.setBounds(180, 525, 377, 35);
        locationBox.setBackground(Color.LIGHT_GRAY);
        locationBox.setSelectedIndex(0);
        mainPanel.add(locationBox).setVisible(false);

        register = new JButton("Register");
        register.setBounds(280, 580, 150, 80);
        register.addActionListener(this);
        mainPanel.add(register);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String mobile = phoneField.getText();
        String password = passwordField.getText();
        String repassword = repasswordField.getText();
        int mobileLen = mobile.length();
        int passLen = password.length();

        if ( adminButton.isSelected()) {
            System.out.println("admin radio button working");
            JOptionPane.showMessageDialog(this, "You are now registering as an Administrator.");
            storeLocation.setVisible(true);
            locationBox.setVisible(true);
        }else if (userButton.isSelected()) {
            System.out.println("user radio button working");
            //JOptionPane.showMessageDialog(this, "You are now registering as an Administrator.");
            storeLocation.setVisible(false);
            locationBox.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Please choose a registration mode.");
            }

        if (fname.isEmpty() && lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both first and last name!!!");
        }
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please choose a Username");
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
            String query = "INSERT INTO users (f_name, l_name, username, password, email_address, phone_number)"
                    + " VALUES('" + fnameField.getText() + "','" +lnameField.getText()+ "','" + usernameField.getText()+ "','" + passwordField.getText()
                    + "','" + emailField.getText() + "','" + phoneField.getText()+"')";

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

//    public String getNameField() {
//        return fnameField.getText();
//    }
//
//    public String getEmailField() {
//        return emailField.getText();
//    }
//
//    public String getPhoneField() {
//        return phoneField.getText();
//    }
//
//    public String getPasswordField() {
//        return passwordField.getText();
//    }
//
//    public String getRePassword() {
//        return repasswordField.getText();
//    }
}
