package controller;

import customer.MainFrame;
import RegisterScreen.registerScreen;
import adminLogin.adminLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.View;
import model.Model;
import user.User;

public class Controller implements ActionListener {

    View view;
    Model model;

    public Controller() {//getting the model and view so we can interact with those classes and see them
        this.view = new View(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //In here are all the actions for the buttons only in the LOGIN page
        
        if (e.getSource() == view.loginButton) {
            String un = view.getUsername();
            String pw = view.getPassword();
            System.out.println("Username: " + un + " , Password: " + pw);

            User user = new User(un, pw);
            boolean result = model.login(user);//checking user crendentials

            if ((result)) {//if true allow in and open MinFrame.java class
                JOptionPane.showMessageDialog(view.success, "Logged in successfuly!!!");

                new MainFrame();
               

            } else {//if not, send this message
                JOptionPane.showMessageDialog(view.success, "Wrong Credentials");
            }
        }
        if (e.getSource() == view.registerButton) {

            
            new registerScreen();
        }
        if (e.getSource() == view.exitbutton) {
            int n = JOptionPane.showConfirmDialog(view.exitbutton, "Are you sure you want to exit?", "exit", JOptionPane.YES_NO_OPTION);
            if (n == 0) {//when you press exit and then press YES the correspondent integer is 0, thats why we dont do an IF statement to check if the user pressed NO as it wont do anything anyway
                System.exit(n);
            }
        }
        if (e.getSource() == view.adminButton) {//this is to allow administrators to log in as admin when the radio button is clicked

            new adminLogin();
        }

    }
}
