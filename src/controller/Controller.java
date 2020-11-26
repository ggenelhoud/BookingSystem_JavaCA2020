package controller;

import customer.customerScreen;
import RegisterScreen.registerScreen;
import adminLogin.adminLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.View;
import model.Model;
import user.User;

public class Controller implements ActionListener {

    View view;
    Model model;

    public Controller() {
        this.view = new View(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.loginButton) {
            String un = view.getUsername();
            String pw = view.getPassword();
            System.out.println("Username: " + un + " , Password: " + pw);

            User user = new User(un, pw);
            boolean result = model.login(user);

            if ((result)) {
                JOptionPane.showMessageDialog(view.success, "Logged in successfuly!!!");
                new customerScreen();

            } else {
                JOptionPane.showMessageDialog(view.success, "Wrong Credentials");
            }
        }
        if (e.getSource() == view.registerButton) {

            new registerScreen();
        }
        if (e.getSource() == view.exitbutton) {
            int n = JOptionPane.showConfirmDialog(view.exitbutton, "Are you sure you want to exit?", "exit", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                System.exit(n);
            }
        }
        if (e.getSource() == view.adminButton) {

            new adminLogin();
        }
        
    }
}
