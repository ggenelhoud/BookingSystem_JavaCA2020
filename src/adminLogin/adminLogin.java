package adminLogin;

import customer.MainFrame;
import RegisterScreen.registerScreen;
import controller.Controller;
import model.Model;
import user.User;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class adminLogin extends JFrame implements ActionListener {

    private JLabel userLabel, locationLabel;
    private JTextField userName;
    private JLabel passwordLabel;
    private JPasswordField userPassword;
    JButton loginButton, registerButton;
    public JLabel success;
    private static JLabel exit;
    private static JButton exitbutton;
    Controller controller;
    JComboBox locationBox;
    JRadioButton adminButton;
    Model model;

    String[] locations = {"Grafton Street", "Candem Street", "O'Connell Street"};

    public adminLogin(Controller controller) {//letting the controller see the class and also calling the default contructor

        this.controller = controller;
        new adminLogin();
    }

    public adminLogin() {//default contructor calling the other methods
        components();
        frameValidation();
    }

    public void components() {

        JPanel panel = new JPanel();//creating the panel
        JFrame frame = new JFrame();//creating the frame
        frame.setMinimumSize(new Dimension(388, 212));//setting minimum window size
        //frame.setMaximumSize(new Dimension(350, 200));
        frame.setTitle("Administrator");//labelling the name displayed on the top of the window
        panel.setBackground(Color.CYAN);
        frame.setSize(350, 200);//setting the program STARTING size
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//this will allow us to close only this window without killing the whole proccess
        frame.add(panel);//adding the panel to the frame
        panel.setBackground(Color.cyan);
        panel.setLayout(null);
        frame.setResizable(false);//we dont want the user to resize the screen/frame
      

        userLabel = new JLabel("Username:");
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
        exitbutton.addActionListener(this);
        panel.add(exitbutton);

        loginButton = new JButton("Sign In");
        loginButton.setBounds(100, 110, 80, 25);
        loginButton.addActionListener((this));
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(183, 110, 82, 25);
        registerButton.addActionListener(this);
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

    private void frameValidation() {
        this.validate();
        this.repaint();
    }
//getters and setters to get user name and password so we can use that in the User.java class to verify users credentials
    public String getUsername() {
        return userName.getText();
    }

    public String getPassword() {
        return userPassword.getText();
    }
//    public String getComboBox(){
//        return null;        
//    }

    public void getSuccess(String result) {
        JOptionPane.showMessageDialog(this, "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.loginButton) {
            String un = getUsername();
            String pw = getPassword();
            System.out.println("Username: " + un + " , Password: " + pw);

            User user = new User(un, pw);
            boolean result = this.model.login(user);

            if ((result)) {
                JOptionPane.showMessageDialog(this, "Logged in successfuly!!!");
                new MainFrame();

            } else {
                JOptionPane.showMessageDialog(this, "Wrong Credentials");
            }
        }
        if (e.getSource() == this.registerButton) {

            new registerScreen();

        }
        if (e.getSource() == this.exitbutton) {
            int n = JOptionPane.showConfirmDialog(this.success, "Are you sure you want to exit?", "exit", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                System.exit(n);
            }
        }
    }
}
