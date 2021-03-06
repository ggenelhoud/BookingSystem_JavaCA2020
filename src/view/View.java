package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
//import javax.swing.WindowConstants;

public class View extends JFrame {

    private JLabel userLabel;
    private JTextField userName;
    private JLabel passwordLabel;
    private JPasswordField userPassword;
    public JButton loginButton, registerButton;
    public JLabel success, labelBarber;
    public JButton exitbutton;
    public JRadioButton adminButton;
    public JFrame frame;
    public ImageIcon barberLogo;
    Controller controller;

    public View(Controller controller) {

        this.controller = controller;

        // We encapsulated the building process of the window
        components();
        validation();
    }

    public void components() {

        JPanel panel = new JPanel();//creating the panel
        frame = new JFrame();//creating the frame
        frame.setMinimumSize(new Dimension(350, 290));//setting minimum window size
        //frame.setMaximumSize(new Dimension(350, 200));
        frame.setTitle("Grafton Barber");//labelling the name displayed on the top of the window
        frame.setSize(350, 300);//setting the program STARTING size
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//to stop running (on netbeans the "running stts" the program once it has been closed.
        frame.add(panel);//adding the panel to the frame
        panel.setBackground(new Color (153, 120, 92));
        panel.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        
    //LOGO BARBER
        barberLogo = new ImageIcon ("logo-barbershop.png");
        labelBarber = new JLabel (barberLogo);
        labelBarber.setBounds(150, 20, 65, 75);
        panel.add(labelBarber);
        
        userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 100, 80, 25);// dimensions are based in: x, y, width, height
        panel.add(userLabel);

        userName = new JTextField();
        userName.setBounds(100, 100, 165, 25);
        panel.add(userName);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 130, 80, 25);
        panel.add(passwordLabel);

        userPassword = new JPasswordField();
        userPassword.setBounds(100, 130, 165, 25);
        panel.add(userPassword);

        loginButton = new JButton("Sign In");
        loginButton.setBounds(100, 160, 80, 25);
        loginButton.addActionListener((controller));
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(183, 160, 82, 25);
        registerButton.addActionListener(controller);
        panel.add(registerButton);

        adminButton = new JRadioButton("admin");
        adminButton.setBounds(20, 200, 100, 25);
        adminButton.addActionListener(controller);
        panel.add(adminButton);

        exitbutton = new JButton("Exit");
        exitbutton.setBounds(250, 200, 70, 25);
        exitbutton.addActionListener(controller);
        panel.add(exitbutton);
        
        success = new JLabel("");
        success.setForeground(new Color(0xFFFFFF));
        success.setBounds(100, 200, 300, 25);
        panel.add(success);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private void validation() {
        this.validate();
        this.repaint();
    }

    public String getUsername() {
        return userName.getText();
    }

    public String getPassword() {
        return userPassword.getText();
    }

    public void getSuccess(String result) {
        JOptionPane.showMessageDialog(this, "");
    }

}
