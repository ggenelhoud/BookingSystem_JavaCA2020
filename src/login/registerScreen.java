package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registerScreen extends JFrame {

    public static void main(String[] args) {
        new registerScreen();
    }
    
    public registerScreen(){
         //this.setSize(650, 830);
        this.setMinimumSize(new Dimension (650, 690));
        this.setTitle("Grafton Barber");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        //mainPanel.setBackground(Color.red);
        this.add(mainPanel);
        
        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 17));
        nameLabel.setBounds(20, 90, 80, 25);// dimensions are based in: x, y, width, height
        mainPanel.add(nameLabel);
        
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 90, 375, 30);
        nameField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        mainPanel.add(nameField);
        
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 17));
        emailLabel.setBounds(20, 150, 80, 25);// dimensions are based in: x, y, width, height
        mainPanel.add(emailLabel);
        
        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        emailField.setBounds(180, 150, 375, 30);
        mainPanel.add(emailField);
        
        JLabel phoneLabel = new JLabel("Phone Number", JLabel.LEFT);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 17));
        phoneLabel.setBounds(20, 210, 120, 25);
        mainPanel.add(phoneLabel);
        
        JTextField phoneField = new JTextField();
        phoneField.setFont(new Font("Arial MT", Font.PLAIN, 18));
        phoneField.setBounds(180, 210, 375, 30);
        mainPanel.add(phoneField);
        
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 17));
        password.setBounds(20, 270, 160, 30);
        mainPanel.add(password);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(180, 270, 375, 30);
        mainPanel.add(passwordField);
        
        JLabel repassword = new JLabel("Re-enter Password");
        repassword.setFont(new Font("Arial", Font.BOLD, 17));
        repassword.setBounds(20, 330, 160, 30);
        mainPanel.add(repassword);
        
        JPasswordField repasswordField = new JPasswordField();
        repasswordField.setBounds(180, 330, 375, 30);
        mainPanel.add(repasswordField);
        
        GridLayout bottomLayout = new GridLayout(1, 1);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.red);
        bottomPanel.setLayout(bottomLayout);
       
        JButton register = new JButton("Register");
        register.setBounds(277, 410, 150, 80);
        mainPanel.add(register);
        
        
        
    }
}
