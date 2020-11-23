
package login;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class adminLogin extends JFrame{
    
    private  JLabel userLabel, passwordLabel;
    private  JTextField userName;
    private  JPasswordField userPassword;
    public JButton loginButton, registerButton,exitbutton;
    public JLabel success, exit, locationLabel;
    Controller controller;
    JComboBox locationBox;
    
    String[] locations = {"Grafton Street", "O'Connell Street", "Candem Street"};
    
    public static void main(String[] args) {
        new adminLogin();
    }
    
    public adminLogin(){
        JPanel panel = new JPanel();//creating the panel
        JFrame frame = new JFrame();//creating the frame
        frame.setMinimumSize(new Dimension(400, 230));//setting minimum window size
        //frame.setMaximumSize(new Dimension(350, 200));
        frame.setTitle("Administrator");//labelling the name displayed on the top of the window
        panel.setBackground(Color.CYAN);
        frame.setSize(350, 200);//setting the program STARTING size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to stop running (on netbeans the "running stts" the program once it has been closed.
        frame.add(panel);//adding the panel to the frame
        //panel.setBackground(Color.cyan);
        panel.setLayout(null);
    
    
        userLabel = new JLabel("E-mail:");
        userLabel.setBounds(10, 20, 80, 25);// dimensions are based in: x, y, width, height
        panel.add(userLabel);
        
        userName = new JTextField();
        userName.setBounds(100, 20, 165, 25);
        panel.add(userName);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        userPassword = new JPasswordField();
        userPassword.setBounds(100, 50, 165, 25);
        panel.add(userPassword);
        
        locationLabel = new JLabel("Location:");
        locationLabel.setBounds(10, 80, 80, 25);
        panel.add(locationLabel);
        
        exitbutton = new JButton("Exit");
        exitbutton.setBounds(295, 140, 70, 25);
        exitbutton.addActionListener(controller);
        panel.add(exitbutton);
        
        loginButton = new JButton("Sign In");
        loginButton.setBounds(100, 110, 80, 25);
        loginButton.addActionListener((controller));
        panel.add(loginButton);
        
        registerButton = new JButton("Register");
        registerButton.setBounds(183, 110, 82, 25);
        registerButton.addActionListener(controller);
        panel.add(registerButton);
              
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        
        locationBox = new JComboBox(locations);
        locationBox.setBounds(100, 80, 166, 25);
        locationBox.setBackground(Color.LIGHT_GRAY);
        locationBox.setSelectedIndex(0);
        panel.add(locationBox);
        
        frame.setVisible(true);
        
    }
}
